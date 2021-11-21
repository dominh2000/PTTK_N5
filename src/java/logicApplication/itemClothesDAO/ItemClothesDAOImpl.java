/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicApplication.itemClothesDAO;

import connectionPool.ConnectionPool;
import connectionPool.DBUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logicApplication.clothesDAO.ClothesDAOImpl;
import model.clothes.Clothes;
import model.clothes.Coat;
import model.clothes.Jeans;
import model.clothes.Shorts;
import model.clothes.TShirt;
import model.itemClothes.ItemClothes;

/**
 *
 * @author pc
 */
public class ItemClothesDAOImpl implements ItemClothesDAO{

    @Override
    public ItemClothes getItemClothesByCode(String code) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        String query = "SELECT * FROM itemclothes WHERE Barcode = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, code);
            rs = ps.executeQuery();

            ItemClothes itemClothes = null;
            if (rs.next()) {
                int employeeId = rs.getInt("EmployeeID");
                int feedbackId = rs.getInt("FeedbackID");
                int cartId = rs.getInt("CartID");
                int clothesId = rs.getInt("ClothesID");
                float price = rs.getFloat("Price");
                String discount = rs.getString("Discount");
                String promoText = rs.getString("PromoText");
                String description = rs.getString("Description");
                String image = rs.getString("Description");
                itemClothes = new ItemClothes(code, employeeId, feedbackId, cartId, clothesId, price, discount, promoText, description, image);
            }
            return itemClothes;
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
    public List<ItemClothes> searchByName(String name) {
        ClothesDAOImpl clothesDAO = new ClothesDAOImpl();
        List<Clothes> listClothes = clothesDAO.getByName(name);

        if (listClothes == null) {
            return null;
        } else {
            List<ItemClothes> listItemClothes = new ArrayList<>();
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();

            String query = "SELECT * FROM itemclothes WHERE ClothesID = ?";
            PreparedStatement ps = null;
            ResultSet rs = null;

            try {
                ps = connection.prepareStatement(query);
                for (Clothes clothes : listClothes) {
                    ps.setInt(1, clothes.getId());
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

                        listItemClothes.add(new ItemClothes(barcode, employeeId, feedbackId, cartId, clothes.getId(), price, discount, promoText, description, image));
                    }
                }

                return listItemClothes;
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
    public Object getClothes(Clothes clothes) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        int id = clothes.getId();
        String name = clothes.getName();
        String brand = clothes.getBrand();
        String color = clothes.getColor();
        Date manufactureDate = clothes.getManufacturerDate();
        String material = clothes.getMaterial();
        String department = clothes.getDepartment();
        String size = clothes.getSize();
        String sizeCountry = clothes.getSize();
        String washingType = clothes.getWashingType();
        float weight = clothes.getWeight();
        String fitType = clothes.getFitType();
        String closureType = clothes.getClosureType();
        String dimensions = clothes.getDimensions();
        String countryOrigin = clothes.getCountryOrigin();
        
        String query1 = "SELECT * FROM `t-shirt` WHERE ClothesID = ?";
        String query2 = "SELECT * FROM coat WHERE ClothesID = ?";
        String query3 = "SELECT * FROM jeans WHERE ClothesID = ?";
        String query4 = "SELECT * FROM shorts WHERE ClothesID = ?";

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
            ps1.setInt(1, clothes.getId());
            rs1 = ps1.executeQuery();
            
            ps2 = connection.prepareStatement(query2);
            ps2.setInt(1, clothes.getId());
            rs2 = ps2.executeQuery();
            
            ps3 = connection.prepareStatement(query3);
            ps3.setInt(1, clothes.getId());
            rs3 = ps3.executeQuery();
            
            ps4 = connection.prepareStatement(query4);
            ps4.setInt(1, clothes.getId());
            rs4 = ps4.executeQuery();
            
            if(rs1 != null){
                TShirt tshirt = null;
                int tagFree = rs1.getInt("TagFree");
                int layFlat = rs1.getInt("LayFlat");
                float sleeveHem = rs1.getFloat("SleeveHem");
                int moistureWicking = rs1.getInt("MoistureWicking");
                int tapedNeck = rs1.getInt("TapedNeck");
                float bottomHem = rs1.getFloat("BottemHem");
                
                tshirt = new TShirt(tagFree, layFlat, sleeveHem, moistureWicking, tapedNeck, bottomHem, id, name, brand, color, manufactureDate, material, department, size, sizeCountry, washingType, weight, fitType, closureType, dimensions, countryOrigin);
                return tshirt;
            }
            else if(rs2 != null){
                Coat coat = null;
                int waterResistant = rs2.getInt("WaterResistant");
                int moistureWicking = rs2.getInt("MoistureWicking");
                int pocketNumber = rs2.getInt("PocketNumber");
                
                coat = new Coat(waterResistant, moistureWicking, pocketNumber, id, name, brand, color, manufactureDate, material, department, size, sizeCountry, washingType, weight, fitType, closureType, dimensions, countryOrigin);
                return coat;
            }
            else if(rs3 != null){
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
            }
            else if(rs4 != null){
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
    public ItemClothes addItemClothes(Clothes clothes, ItemClothes itemClothes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteItemClothes(ItemClothes itemClothes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ItemClothes modifyItemClothes(ItemClothes itemClothes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
