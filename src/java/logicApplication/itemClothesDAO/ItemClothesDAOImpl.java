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
                int feedbackId = rs.getInt("FeedbackID");
                int cartId = rs.getInt("CartID");
                int clothesId = rs.getInt("ClothesID");
                float price = rs.getFloat("Price");
                String discount = rs.getString("Discount");
                String promoText = rs.getString("PromoText");
                String description = rs.getString("Description");
                String image = rs.getString("Description");
                
                Object cloth = getClothes(clothesId);
                if (cloth instanceof TShirt) {
                    TShirt tShirt = (TShirt) cloth;
                    itemClothes = new ItemClothes(code, price, discount, promoText, description, image, tShirt);
                } else if (cloth instanceof Coat) {
                    Coat coat = (Coat) cloth;
                    itemClothes = new ItemClothes(code, price, discount, promoText, description, image, coat);
                } else if (cloth instanceof Jeans) {
                    Jeans jeans = (Jeans) cloth;
                    itemClothes = new ItemClothes(code, price, discount, promoText, description, image, jeans);
                } else if (cloth instanceof Shorts) {
                    Shorts shorts = (Shorts) cloth;
                    itemClothes = new ItemClothes(code, price, discount, promoText, description, image, shorts);
                }
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
        List<Object> listClothes = getClothesByName(name);

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
                for (Object cloth : listClothes) {
                    if (cloth instanceof TShirt) {
                        TShirt tShirt = (TShirt) cloth;
                        ps.setInt(1, tShirt.getId());
                    } else if (cloth instanceof Coat) {
                        Coat coat = (Coat) cloth;
                        ps.setInt(1, coat.getId());
                    } else if (cloth instanceof Jeans) {
                        Jeans jeans = (Jeans) cloth;
                        ps.setInt(1, jeans.getId());
                    } else if (cloth instanceof Shorts) {
                        Shorts shorts = (Shorts) cloth;
                        ps.setInt(1, shorts.getId());
                    }
                    rs = ps.executeQuery();

                    while (rs.next()) {
                        String barcode = rs.getString("Barcode");
                        int feedbackId = rs.getInt("FeedbackID");
                        int cartId = rs.getInt("CartID");
                        float price = rs.getFloat("Price");
                        String discount = rs.getString("Discount");
                        String promoText = rs.getString("PromoText");
                        String description = rs.getString("Description");
                        String image = rs.getString("Image");
                        
                        if (cloth instanceof TShirt) {
                            TShirt tShirt = (TShirt) cloth;
                            listItemClothes.add(new ItemClothes(barcode, price, discount, promoText, description, image, tShirt));
                        } else if (cloth instanceof Coat) {
                            Coat coat = (Coat) cloth;
                            listItemClothes.add(new ItemClothes(barcode, price, discount, promoText, description, image, coat));
                        } else if (cloth instanceof Jeans) {
                            Jeans jeans = (Jeans) cloth;
                            listItemClothes.add(new ItemClothes(barcode, price, discount, promoText, description, image, jeans));
                        } else if (cloth instanceof Shorts) {
                            Shorts shorts = (Shorts) cloth;
                            listItemClothes.add(new ItemClothes(barcode, price, discount, promoText, description, image, shorts));
                        }
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
    public Object getClothes(int ID) {
        ClothesDAOImpl clothesDAOImpl = new ClothesDAOImpl();
        return clothesDAOImpl.getByID(ID);
    }
    
    @Override
    public List<Object> getClothesByName(String name) {
        ClothesDAOImpl clothesDAOImpl = new ClothesDAOImpl();
        return clothesDAOImpl.getByName(name);
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
