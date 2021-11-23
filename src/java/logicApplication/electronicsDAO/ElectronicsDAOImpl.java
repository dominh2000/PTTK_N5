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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.electronics.Electronics;
import model.electronics.Hairdryer;
import model.electronics.Laptop;
import model.electronics.MobilePhone;
import model.electronics.PC;

/**
 *
 * @author pc
 */
public class ElectronicsDAOImpl implements ElectronicsDAO {

    @Override
    public Object getByID(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        String query0 = "SELECT * FROM electronics WHERE ID = ?";
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
                String manufacturer = rs0.getString("Manufacturer");
                Date manufactureDate = rs0.getDate("ManufactureDate");
                float weight = rs0.getFloat("Weight");
                String color = rs0.getString("Color");
                int warranty = rs0.getInt("Warranty");
                String dimensions = rs0.getString("Dimensions");
                String countryOrigin = rs0.getString("CountryOrigin");

                String query1 = "SELECT * FROM hairdryer WHERE ElectronicsID = ?";
                String query2 = "SELECT * FROM mobilephone WHERE ElectronicsID = ?";
                String query3 = "SELECT * FROM laptop WHERE ElectronicsID = ?";
                String query4 = "SELECT * FROM pc WHERE ElectronicsID = ?";

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
                    Hairdryer hairdryer = null;
                    String hairType = rs1.getString("HairType");
                    float wattage = rs1.getFloat("Wattage");
                    String material = rs1.getString("Material");
                    int voltage = rs1.getInt("Voltage");
                    int speedSettings = rs1.getInt("SpeedSettings");
                    int heatSetiings = rs1.getInt("HeatSettings");

                    hairdryer = new Hairdryer(hairType, wattage, material, voltage, speedSettings, heatSetiings, id, name, manufacturer, manufactureDate, weight, color, warranty, dimensions, countryOrigin);
                    return hairdryer;
                } else if (rs2 != null) {
                    MobilePhone mobilePhone = null;
                    String cpu = rs2.getString("Cpu");
                    String gpu = rs2.getString("Gpu");
                    int storageSize = rs2.getInt("StorageSize");
                    float screensSize = rs2.getFloat("ScreenSize");
                    String screenResolution = rs2.getString("ScreenResolution");
                    int ramSize = rs2.getInt("RamSize");
                    String connections = rs2.getString("Connections");
                    String interfaces = rs2.getString("Interfaces");
                    String battery = rs2.getString("Battery");
                    String os = rs2.getString("Os");
                    String frontCam = rs2.getString("FrontCamera");
                    String rearCam = rs2.getString("RearCamera");
                    String speaker = rs2.getString("Speaker");

                    mobilePhone = new MobilePhone(cpu, gpu, storageSize, screensSize, screenResolution, ramSize, connections, interfaces, battery, os, frontCam, rearCam, speaker, id, name, manufacturer, manufactureDate, weight, color, warranty, dimensions, countryOrigin);
                    return mobilePhone;
                } else if (rs3 != null) {
                    Laptop laptop = null;
                    String cpu = rs3.getString("Cpu");
                    String gpu = rs3.getString("Gpu");
                    int storageSize = rs3.getInt("StorageSize");
                    String storageType = rs3.getString("StorageType");
                    float screensSize = rs3.getFloat("ScreenSize");
                    String screenResolution = rs3.getString("ScreenResolution");
                    int ramSize = rs3.getInt("RamSize");
                    String ramType = rs3.getString("RamType");
                    String connections = rs3.getString("Connections");
                    String interfaces = rs3.getString("Interfaces");
                    String battery = rs3.getString("Battery");
                    String os = rs3.getString("Os");
                    String speaker = rs3.getString("Speaker");

                    laptop = new Laptop(cpu, gpu, storageSize, storageType, screensSize, screenResolution, ramSize, ramType, connections, interfaces, battery, os, speaker, id, name, manufacturer, manufactureDate, weight, color, warranty, dimensions, countryOrigin);
                    return laptop;
                } else if (rs4 != null) {
                    PC pc = null;
                    String cpu = rs4.getString("Cpu");
                    String gpu = rs4.getString("Gpu");
                    int storageSize = rs4.getInt("StorageSize");
                    String storageType = rs4.getString("StorageType");
                    int ramSize = rs4.getInt("RamSize");
                    String ramType = rs4.getString("RamType");
                    String connections = rs4.getString("Connections");
                    String interfaces = rs4.getString("Interfaces");
                    String os = rs4.getString("Os");

                    pc = new PC(cpu, gpu, storageSize, storageType, ramSize, ramType, connections, interfaces, os, id, name, manufacturer, manufactureDate, weight, color, warranty, dimensions, countryOrigin);
                    return pc;
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
        List<Object> resElectronics = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        String query1 = "SELECT * FROM electronics WHERE Name = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(query1);
            ps.setString(1, name);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                Object elec = getByID(id);
                resElectronics.add(elec);
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
