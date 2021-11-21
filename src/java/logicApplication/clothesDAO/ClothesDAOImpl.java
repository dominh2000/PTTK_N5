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
import model.clothes.Clothes;
import model.clothes.Coat;
import model.clothes.Jeans;
import model.clothes.Shorts;
import model.clothes.TShirt;

/**
 *
 * @author pc
 */
public class ClothesDAOImpl implements ClothesDAO{

    @Override
    public List<Clothes> getByName(String name) {
        List<Clothes> resClothes = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        String query1 = "SELECT * FROM clothes WHERE Name = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = connection.prepareStatement(query1);
            ps.setString(1, name);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("ID");
                String brand = rs.getString("Brand");
                String color = rs.getString("Color");
                Date manufactureDate = rs.getDate("ManufactureDate");
                String material = rs.getString("Material");
                String department = rs.getString("Department");
                String size = rs.getString("Size");
                String sizeCountry = rs.getString("SizeCountry");
                String washingType = rs.getString("WashingType");
                float weight = rs.getFloat("Weight");
                String fitType = rs.getString("FitType");
                String closureType = rs.getString("ClosureType");
                String dimensions = rs.getString("Dimensions");
                String countryOrigin = rs.getString("CountryOrigin");
                
                resClothes.add(new Clothes(id, name, brand, color, manufactureDate, material, department, size, sizeCountry, washingType, weight, fitType, closureType, dimensions, countryOrigin));
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
