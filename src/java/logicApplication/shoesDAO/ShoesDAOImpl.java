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
import model.shoes.Boot;
import model.shoes.BusinessShoes;
import model.shoes.RunningShoes;
import model.shoes.Shoes;
import model.shoes.Sneaker;

/**
 *
 * @author pc
 */
public class ShoesDAOImpl implements ShoesDAO{

    @Override
    public List<Shoes> getByName(String name) {
        List<Shoes> resShoes = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        String query1 = "SELECT * FROM shoes WHERE Name = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = connection.prepareStatement(query1);
            ps.setString(1, name);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("ID");
                float size = rs.getFloat("Size");
                String sizeCountry = rs.getString("SizeCountry");
                String brand = rs.getString("Brand");
                String color = rs.getString("Color");
                float weight = rs.getFloat("Weight");
                Date manufactureDate = rs.getDate("ManufactureDate");
                String countryOrigin = rs.getString("CountryOrigin");
                String department = rs.getString("Department");
                String upperMaterial = rs.getString("UpperMaterial");
                String soleMaterial = rs.getString("SoleMaterial");
                String liningMaterial = rs.getString("LiningMaterial");
                String dimensions = rs.getString("Dimensions");
                
                resShoes.add(new Shoes(id, name, size, sizeCountry, brand, color, weight, manufactureDate, countryOrigin, department, upperMaterial, soleMaterial, liningMaterial, dimensions));
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
