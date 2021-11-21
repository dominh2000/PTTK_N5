/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicApplication.electronicsDAO;

import connectionPool.ConnectionPool;
import connectionPool.DBUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.electronics.Electronics;
import model.electronics.Hairdryer;
import model.electronics.Laptop;
import model.electronics.MobilePhone;
import model.electronics.PC;

/**
 *
 * @author pc
 */
public class ElectronicsDAOImpl implements ElectronicsDAO{

    @Override
    public List<Electronics> getByName(String name) {
        List<Electronics> resElectronics = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        String query1 = "SELECT * FROM electronics WHERE Name = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = connection.prepareStatement(query1);
            ps.setString(1, name);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("ID");
                String manufacturer = rs.getString("Manufacturer");
                Date manufacteDate = rs.getDate("ManufactureDate");
                float weight = rs.getFloat("Weight");
                String color = rs.getString("Color");
                int warranty = rs.getInt("Warranty");
                String dimensions = rs.getString("Dimensions");
                String countryOrigin = rs.getString("CountryOrigin");
                
                resElectronics.add(new Electronics(id, name, manufacturer, manufacteDate, weight, color, warranty, dimensions, countryOrigin));
            }
            return resElectronics;
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
    public boolean addHairdryer(Electronics elec, Hairdryer hairdryer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addMobilePhone(Electronics elec, MobilePhone mobile) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addLaptop(Electronics elec, Laptop laptop) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addPC(Electronics elec, PC pc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifyHairdryer(Electronics elec, Hairdryer hairdryer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifyMobilePhone(Electronics elec, MobilePhone mobile) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifyLaptop(Electronics elec, Laptop laptop) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifyPC(Electronics elec, PC pc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteElec(Electronics elec) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
