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
                int feedbackId = rs.getInt("FeedbackID");
                int cartId = rs.getInt("CartID");
                int shoesId = rs.getInt("ShoesID");
                float price = rs.getFloat("Price");
                String discount = rs.getString("Discount");
                String promoText = rs.getString("PromoText");
                String description = rs.getString("Description");
                String image = rs.getString("Description");
                
                Object shoe = getShoes(shoesId);
                if (shoe instanceof Sneaker) {
                    Sneaker sneaker = (Sneaker) shoe;
                    itemShoes = new ItemShoes(code, price, discount, promoText, description, image, sneaker);
                } else if (shoe instanceof BusinessShoes) {
                    BusinessShoes businessShoes = (BusinessShoes) shoe;
                    itemShoes = new ItemShoes(code, price, discount, promoText, description, image, businessShoes);
                } else if (shoe instanceof RunningShoes) {
                    RunningShoes runningShoes = (RunningShoes) shoe;
                    itemShoes = new ItemShoes(code, price, discount, promoText, description, image, runningShoes);
                } else if (shoe instanceof Boot) {
                    Boot boot = (Boot) shoe;
                    itemShoes = new ItemShoes(code, price, discount, promoText, description, image, boot);
                }
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
        List<Object> listShoes = getShoesByName(name);

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
                for (Object shoe : listShoes) {
                    if (shoe instanceof Sneaker) {
                        Sneaker sneaker = (Sneaker) shoe;
                        ps.setInt(1, sneaker.getId());
                    } else if (shoe instanceof BusinessShoes) {
                        BusinessShoes businessShoes = (BusinessShoes) shoe;
                        ps.setInt(1, businessShoes.getId());
                    } else if (shoe instanceof RunningShoes) {
                        RunningShoes runningShoes = (RunningShoes) shoe;
                        ps.setInt(1, runningShoes.getId());
                    } else if (shoe instanceof Boot) {
                        Boot boot = (Boot) shoe;
                        ps.setInt(1, boot.getId());
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
                        
                        if (shoe instanceof Sneaker) {
                            Sneaker sneaker = (Sneaker) shoe;
                            listItemShoes.add(new ItemShoes(barcode, price, discount, promoText, description, image, sneaker));
                        } else if (shoe instanceof BusinessShoes) {
                            BusinessShoes businessShoes = (BusinessShoes) shoe;
                            listItemShoes.add(new ItemShoes(barcode, price, discount, promoText, description, image, businessShoes));
                        } else if (shoe instanceof RunningShoes) {
                            RunningShoes runningShoes = (RunningShoes) shoe;
                            listItemShoes.add(new ItemShoes(barcode, price, discount, promoText, description, image, runningShoes));
                        } else if (shoe instanceof Boot) {
                            Boot boot = (Boot) shoe;
                            listItemShoes.add(new ItemShoes(barcode, price, discount, promoText, description, image, boot));
                        }
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
    public Object getShoes(int ID) {
        ShoesDAOImpl shoesDAOImpl = new ShoesDAOImpl();
        return shoesDAOImpl.getByID(ID);
    }
    
    @Override
    public List<Object> getShoesByName(String name) {
        ShoesDAOImpl shoesDAOImpl = new ShoesDAOImpl();
        return shoesDAOImpl.getByName(name);
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
