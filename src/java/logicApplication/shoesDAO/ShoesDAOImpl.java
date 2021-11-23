/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicApplication.shoesDAO;

import connectionPool.ConnectionPool;
import connectionPool.DBUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.shoes.Boot;
import model.shoes.BusinessShoes;
import model.shoes.RunningShoes;
import model.shoes.Shoes;
import model.shoes.Sneaker;

/**
 *
 * @author pc
 */
public class ShoesDAOImpl implements ShoesDAO {

    @Override
    public Object getByID(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        String query0 = "SELECT * FROM shoes WHERE ID = ?";
        PreparedStatement ps0 = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        PreparedStatement ps4 = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        ResultSet rs4 = null;
        ResultSet rs0 = null;

        try {
            ps0 = connection.prepareStatement(query0);
            ps0.setInt(1, id);
            rs0 = ps0.executeQuery();

            if (rs0.next()) {
                String name = rs0.getString("Name");
                float size = rs0.getFloat("Size");
                String sizeCountry = rs0.getString("SizeCountry");
                String brand = rs0.getString("Brand");
                String color = rs0.getString("Color");
                float weight = rs0.getFloat("Weight");
                Date manufactureDate = rs0.getDate("ManufactureDate");
                String countryOrigin = rs0.getString("CountryOrigin");
                String department = rs0.getString("Department");
                String upperMaterial = rs0.getString("UpperMaterial");
                String soleMaterial = rs0.getString("SoleMaterial");
                String liningMaterial = rs0.getString("LiningMaterial");
                String dimensions = rs0.getString("Dimensions");

                String query1 = "SELECT * FROM sneaker WHERE ShoesID = ?";
                String query2 = "SELECT * FROM businessshoes WHERE ShoesID = ?";
                String query3 = "SELECT * FROM boot WHERE ShoesID = ?";
                String query4 = "SELECT * FROM runningshoes WHERE ShoesID = ?";

                ps1 = connection.prepareStatement(query1);
                ps1.setInt(1, id);
                rs1 = ps1.executeQuery();

                ps2 = connection.prepareStatement(query2);
                ps2.setInt(1, id);
                rs2 = ps2.executeQuery();

                ps3 = connection.prepareStatement(query3);
                ps3.setInt(1, id);
                rs3 = ps3.executeQuery();

                ps4 = connection.prepareStatement(query4);
                ps4.setInt(1, id);
                rs4 = ps4.executeQuery();

                if (rs1 != null) {
                    Sneaker sneaker = null;
                    int nightReflect = rs1.getInt("NightReflect");
                    float heelHeight = rs1.getFloat("HeelHeight");

                    sneaker = new Sneaker(nightReflect, heelHeight, id, name, size, sizeCountry, brand, color, weight, manufactureDate, countryOrigin, department, upperMaterial, soleMaterial, liningMaterial, dimensions);
                    return sneaker;
                } else if (rs2 != null) {
                    BusinessShoes businessShoes = null;
                    float heelHeight = rs2.getFloat("HeelHeight");
                    float heelMeasure = rs2.getFloat("HeelMeasure");

                    businessShoes = new BusinessShoes(heelHeight, heelMeasure, id, name, size, sizeCountry, brand, color, weight, manufactureDate, countryOrigin, department, upperMaterial, soleMaterial, liningMaterial, dimensions);
                    return businessShoes;
                } else if (rs3 != null) {
                    Boot boot = null;
                    String type = rs3.getString("Type");
                    float bootOpening = rs3.getFloat("BootOpening");
                    float heelHeight = rs3.getFloat("HeelHeight");
                    float shaftMeasure = rs3.getFloat("ShaftMeasure");

                    boot = new Boot(type, bootOpening, heelHeight, shaftMeasure, id, name, size, sizeCountry, brand, color, weight, manufactureDate, countryOrigin, department, upperMaterial, soleMaterial, liningMaterial, dimensions);
                    return boot;
                } else if (rs4 != null) {
                    RunningShoes runningShoes = null;
                    int nightReflect = rs4.getInt("NightReflect");
                    String durability = rs4.getString("Durability");
                    int shockAbsorb = rs4.getInt("ShockAbsorb");
                    int ventilation = rs4.getInt("Ventilation");
                    int ankleSupport = rs4.getInt("AnkleSupport");

                    runningShoes = new RunningShoes(nightReflect, durability, shockAbsorb, ventilation, ankleSupport, id, name, size, sizeCountry, brand, color, weight, manufactureDate, countryOrigin, department, upperMaterial, soleMaterial, liningMaterial, dimensions);
                    return runningShoes;
                }
            }
            return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            DBUtil.closeResultSet(rs0);
            DBUtil.closePreparedStatement(ps0);
            DBUtil.closeResultSet(rs1);
            DBUtil.closePreparedStatement(ps1);
            DBUtil.closeResultSet(rs2);
            DBUtil.closePreparedStatement(ps2);
            DBUtil.closeResultSet(rs3);
            DBUtil.closePreparedStatement(ps3);
            DBUtil.closeResultSet(rs4);
            DBUtil.closePreparedStatement(ps4);
            pool.freeConnection(connection);
        }
    }

    @Override
    public List<Object> getByName(String name) {
        List<Object> resShoes = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        String query1 = "SELECT * FROM shoes WHERE Name = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(query1);
            ps.setString(1, name);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                Object shoe = getByID(id);
                resShoes.add(shoe);
            }
            return resShoes;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    @Override
    public boolean addSneaker(Shoes shoes, Sneaker sneaker) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addBusinessShoes(Shoes shoes, BusinessShoes businessShoes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addRunShoes(Shoes shoes, RunningShoes runShoes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addBoot(Shoes shoes, Boot boot) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifySneaker(Shoes shoes, Sneaker sneaker) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifyBusinessShoes(Shoes shoes, BusinessShoes businessShoes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifyRunShoes(Shoes shoes, RunningShoes runShoes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifyBoot(Shoes shoes, Boot boot) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteShoes(Shoes shoes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
