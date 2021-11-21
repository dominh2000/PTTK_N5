/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicApplication.itemShoesDAO;

import connectionPool.ConnectionPool;
import connectionPool.DBUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logicApplication.shoesDAO.ShoesDAOImpl;
import model.itemShoes.ItemShoes;
import model.shoes.Boot;
import model.shoes.BusinessShoes;
import model.shoes.RunningShoes;
import model.shoes.Shoes;
import model.shoes.Sneaker;

/**
 *
 * @author pc
 */
public class ItemShoesDAOImpl implements ItemShoesDAO {

    @Override
    public ItemShoes getItemShoesByCode(String code) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        String query = "SELECT * FROM itemshoes WHERE Barcode = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, code);
            rs = ps.executeQuery();

            ItemShoes itemShoes = null;
            if (rs.next()) {
                int employeeId = rs.getInt("EmployeeID");
                int feedbackId = rs.getInt("FeedbackID");
                int cartId = rs.getInt("CartID");
                int shoesId = rs.getInt("ShoesID");
                float price = rs.getFloat("Price");
                String discount = rs.getString("Discount");
                String promoText = rs.getString("PromoText");
                String description = rs.getString("Description");
                String image = rs.getString("Description");
                itemShoes = new ItemShoes(code, employeeId, feedbackId, cartId, shoesId, price, discount, promoText, description, image);
            }
            return itemShoes;
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
    public List<ItemShoes> searchByName(String name) {
        ShoesDAOImpl shoesDAO = new ShoesDAOImpl();
        List<Shoes> listShoes = shoesDAO.getByName(name);

        if (listShoes == null) {
            return null;
        } else {
            List<ItemShoes> listItemShoes = new ArrayList<>();
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();

            String query = "SELECT * FROM itemshoes WHERE ShoesID = ?";
            PreparedStatement ps = null;
            ResultSet rs = null;

            try {
                ps = connection.prepareStatement(query);
                for (Shoes shoes : listShoes) {
                    ps.setInt(1, shoes.getId());
                    rs = ps.executeQuery();

                    while (rs.next()) {
                        String barcode = rs.getString("Barcode");
                        int employeeId = rs.getInt("EmployeeID");
                        int feedbackId = rs.getInt("FeedbackID");
                        int cartId = rs.getInt("CartID");
                        float price = rs.getFloat("Price");
                        String discount = rs.getString("Discount");
                        String promoText = rs.getString("PromoText");
                        String description = rs.getString("Description");
                        String image = rs.getString("Image");

                        listItemShoes.add(new ItemShoes(barcode, employeeId, feedbackId, cartId, shoes.getId(), price, discount, promoText, description, image));
                    }
                }

                return listItemShoes;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return null;
            } finally {
                DBUtil.closeResultSet(rs);
                DBUtil.closePreparedStatement(ps);
                pool.freeConnection(connection);
            }
        }
    }

    @Override
    public Object getShoes(Shoes shoes) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        int id = shoes.getId();
        String name = shoes.getName();
        float size = shoes.getSize();
        String sizeCountry = shoes.getSizeCountry();
        String brand = shoes.getBrand();
        String color = shoes.getColor();
        float weight = shoes.getWeight();
        Date manufactureDate = shoes.getManufactureDate();
        String countryOrigin = shoes.getCountryOrigin();
        String department = shoes.getDepartment();
        String upperMaterial = shoes.getUpperMaterial();
        String soleMaterial = shoes.getSoleMaterial();
        String liningMaterial = shoes.getLiningMaterial();
        String dimensions = shoes.getDimensions();

        String query1 = "SELECT * FROM sneaker WHERE ShoesID = ?";
        String query2 = "SELECT * FROM businessshoes WHERE ShoesID = ?";
        String query3 = "SELECT * FROM boot WHERE ShoesID = ?";
        String query4 = "SELECT * FROM runningshoes WHERE ShoesID = ?";

        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        PreparedStatement ps4 = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        ResultSet rs4 = null;

        try {
            ps1 = connection.prepareStatement(query1);
            ps1.setInt(1, shoes.getId());
            rs1 = ps1.executeQuery();

            ps2 = connection.prepareStatement(query2);
            ps2.setInt(1, shoes.getId());
            rs2 = ps2.executeQuery();

            ps3 = connection.prepareStatement(query3);
            ps3.setInt(1, shoes.getId());
            rs3 = ps3.executeQuery();

            ps4 = connection.prepareStatement(query4);
            ps4.setInt(1, shoes.getId());
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
            return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
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
    public ItemShoes addItemShoes(Shoes shoes, ItemShoes itemShoes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteItemShoes(ItemShoes itemShoes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ItemShoes modifyItemShoes(ItemShoes itemShoes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
