/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicApplication.clothesDAO;

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
import model.clothes.Clothes;
import model.clothes.Coat;
import model.clothes.Jeans;
import model.clothes.Shorts;
import model.clothes.TShirt;

/**
 *
 * @author pc
 */
public class ClothesDAOImpl implements ClothesDAO {

    @Override
    public Object getByID(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        String query0 = "SELECT * FROM clothes WHERE ID = ?";
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
            ps0 = connection.prepareCall(query0);
            ps0.setInt(1, id);
            rs0 = ps0.executeQuery();

            if (rs0.next()) {
                String name = rs0.getString("Name");
                String brand = rs0.getString("Brand");
                String color = rs0.getString("Color");
                Date manufactureDate = rs0.getDate("ManufactureDate");
                String material = rs0.getString("Material");
                String department = rs0.getString("Department");
                String size = rs0.getString("Size");
                String sizeCountry = rs0.getString("SizeCountry");
                String washingType = rs0.getString("WashingType");
                float weight = rs0.getFloat("Weight");
                String fitType = rs0.getString("FitType");
                String closureType = rs0.getString("ClosureType");
                String dimensions = rs0.getString("Dimensions");
                String countryOrigin = rs0.getString("CountryOrigin");

                String query1 = "SELECT * FROM `t-shirt` WHERE ClothesID = ?";
                String query2 = "SELECT * FROM coat WHERE ClothesID = ?";
                String query3 = "SELECT * FROM jeans WHERE ClothesID = ?";
                String query4 = "SELECT * FROM shorts WHERE ClothesID = ?";

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
                    TShirt tshirt = null;
                    int tagFree = rs1.getInt("TagFree");
                    int layFlat = rs1.getInt("LayFlat");
                    float sleeveHem = rs1.getFloat("SleeveHem");
                    int moistureWicking = rs1.getInt("MoistureWicking");
                    int tapedNeck = rs1.getInt("TapedNeck");
                    float bottomHem = rs1.getFloat("BottemHem");

                    tshirt = new TShirt(tagFree, layFlat, sleeveHem, moistureWicking, tapedNeck, bottomHem, id, name, brand, color, manufactureDate, material, department, size, sizeCountry, washingType, weight, fitType, closureType, dimensions, countryOrigin);
                    return tshirt;
                } else if (rs2 != null) {
                    Coat coat = null;
                    int waterResistant = rs2.getInt("WaterResistant");
                    int moistureWicking = rs2.getInt("MoistureWicking");
                    int pocketNumber = rs2.getInt("PocketNumber");

                    coat = new Coat(waterResistant, moistureWicking, pocketNumber, id, name, brand, color, manufactureDate, material, department, size, sizeCountry, washingType, weight, fitType, closureType, dimensions, countryOrigin);
                    return coat;
                } else if (rs3 != null) {
                    Jeans jeans = null;
                    float waist = rs3.getFloat("Waist");
                    float frontRise = rs3.getFloat("FrontRise");
                    float backRise = rs3.getFloat("BackRise");
                    float upperThigh = rs3.getFloat("UpperThigh");
                    float inseam = rs3.getFloat("Inseam");
                    float legOpening = rs3.getFloat("LegOpening");
                    int pocketNumber = rs3.getInt("PocketNumber");

                    jeans = new Jeans(waist, frontRise, backRise, upperThigh, inseam, legOpening, pocketNumber, id, name, brand, color, manufactureDate, material, department, size, sizeCountry, washingType, weight, fitType, closureType, dimensions, countryOrigin);
                    return jeans;
                } else if (rs4 != null) {
                    Shorts shorts = null;
                    int pocketNunber = rs4.getInt("PocketNumber");
                    int moistureWicking = rs4.getInt("MoistureWicking");
                    int breathable = rs4.getInt("Breathable");
                    String type = rs4.getString("Type");
                    float inseam = rs4.getFloat("Inseam");
                    float outseam = rs4.getFloat("Outseam");

                    shorts = new Shorts(pocketNunber, moistureWicking, breathable, type, inseam, outseam, id, name, brand, color, manufactureDate, material, department, size, sizeCountry, washingType, weight, fitType, closureType, dimensions, countryOrigin);
                    return shorts;
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
        List<Object> resClothes = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        String query1 = "SELECT * FROM clothes WHERE Name = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(query1);
            ps.setString(1, name);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                Object cloth = getByID(id);
                resClothes.add(cloth);
            }
            return resClothes;
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
    public boolean addTShirt(Clothes clothes, TShirt tShirt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addCoat(Clothes clothes, Coat coat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addJeans(Clothes clothes, Jeans jeans) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addShorts(Clothes clothes, Shorts shorts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifyTShirt(Clothes clothes, TShirt tShirt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifyCoat(Clothes clothes, Coat coat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifyJeans(Clothes clothes, Jeans jeans) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifyShorts(Clothes clothes, Shorts shorts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteClothes(Clothes clothes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
