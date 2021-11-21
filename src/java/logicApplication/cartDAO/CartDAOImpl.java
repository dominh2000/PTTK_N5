/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicApplication.cartDAO;

import connectionPool.ConnectionPool;
import connectionPool.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.cart.Cart;
import model.itemBook.ItemBook;
import model.itemClothes.ItemClothes;
import model.itemElectronics.ItemElectronics;
import model.itemShoes.ItemShoes;

/**
 *
 * @author pc
 */
public class CartDAOImpl implements CartDAO{
    
    @Override
    public Cart getCartById(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "SELECT * FROM cart WHERE ID = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            Cart cart = null;
            
            if(rs.next()){
                int orderId = rs.getInt("OrderID");
                int amount = rs.getInt("Amount");
                float totalPrice = rs.getFloat("TotalPrice");
                cart = new Cart(id, orderId, amount, totalPrice);
            }
            
            return cart;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally{
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
    }
    
    @Override
    public boolean addItemBookToCart(ItemBook itemBook, Cart cart) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query1 = "UPDATE itembook SET CartID = ? WHERE Barcode = ?";
        String query2 = "UPDATE cart SET Amount = Amount + 1, Price = Price + ? WHERE ID = ?";
        PreparedStatement ps = null;
        
        try {
            ps = connection.prepareStatement(query1);
            ps.setInt(1, cart.getId());
            ps.setString(2, itemBook.getBarcode());
            ps.executeUpdate();
            
            ps = connection.prepareStatement(query2);
            ps.setFloat(1, itemBook.getPrice());
            ps.setInt(2, cart.getId());
            ps.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    @Override
    public boolean addItemElecToCart(ItemElectronics itemElec, Cart cart) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query1 = "UPDATE itemelectronics SET CartID = ? WHERE Barcode = ?";
        String query2 = "UPDATE cart SET Amount = Amount + 1, Price = Price + ? WHERE ID = ?";
        PreparedStatement ps = null;
        
        try {
            ps = connection.prepareStatement(query1);
            ps.setInt(1, cart.getId());
            ps.setString(2, itemElec.getBarcode());
            ps.executeUpdate();
            
            ps = connection.prepareStatement(query2);
            ps.setFloat(1, itemElec.getPrice());
            ps.setInt(2, cart.getId());
            ps.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    @Override
    public boolean addItemShoesToCart(ItemShoes itemShoes, Cart cart) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query1 = "UPDATE itemshoes SET CartID = ? WHERE Barcode = ?";
        String query2 = "UPDATE cart SET Amount = Amount + 1, Price = Price + ? WHERE ID = ?";
        PreparedStatement ps = null;
        
        try {
            ps = connection.prepareStatement(query1);
            ps.setInt(1, cart.getId());
            ps.setString(2, itemShoes.getBarcode());
            ps.executeUpdate();
            
            ps = connection.prepareStatement(query2);
            ps.setFloat(1, itemShoes.getPrice());
            ps.setInt(2, cart.getId());
            ps.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    @Override
    public boolean addItemClothesToCart(ItemClothes itemClothes, Cart cart) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query1 = "UPDATE itemclothes SET CartID = ? WHERE Barcode = ?";
        String query2 = "UPDATE cart SET Amount = Amount + 1, Price = Price + ? WHERE ID = ?";
        PreparedStatement ps = null;
        
        try {
            ps = connection.prepareStatement(query1);
            ps.setInt(1, cart.getId());
            ps.setString(2, itemClothes.getBarcode());
            ps.executeUpdate();
            
            ps = connection.prepareStatement(query2);
            ps.setFloat(1, itemClothes.getPrice());
            ps.setInt(2, cart.getId());
            ps.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    @Override
    public boolean removeItemBookFromCart(ItemBook itemBook, Cart cart) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query1 = "UPDATE itembook SET CartID = ? WHERE Barcode = ?";
        String query2 = "UPDATE cart SET Amount = Amount - 1, Price = Price - ? WHERE ID = ?";
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(query1);
            ps.setNull(1, java.sql.Types.INTEGER);
            ps.setString(2, itemBook.getBarcode());
            ps.executeUpdate();
            
            ps = connection.prepareStatement(query2);
            ps.setFloat(1, itemBook.getPrice());
            ps.setInt(2, cart.getId());
            ps.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    @Override
    public boolean removeItemElecFromCart(ItemElectronics itemElec, Cart cart) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query1 = "UPDATE itemelectronics SET CartID = ? WHERE Barcode = ?";
        String query2 = "UPDATE cart SET Amount = Amount - 1, Price = Price - ? WHERE ID = ?";
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(query1);
            ps.setNull(1, java.sql.Types.INTEGER);
            ps.setString(2, itemElec.getBarcode());
            ps.executeUpdate();
            
            ps = connection.prepareStatement(query2);
            ps.setFloat(1, itemElec.getPrice());
            ps.setInt(2, cart.getId());
            ps.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    @Override
    public boolean removeItemClothesFromCart(ItemClothes itemClothes, Cart cart) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query1 = "UPDATE itemclothes SET CartID = ? WHERE Barcode = ?";
        String query2 = "UPDATE cart SET Amount = Amount - 1, Price = Price - ? WHERE ID = ?";
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(query1);
            ps.setNull(1, java.sql.Types.INTEGER);
            ps.setString(2, itemClothes.getBarcode());
            ps.executeUpdate();
            
            ps = connection.prepareStatement(query2);
            ps.setFloat(1, itemClothes.getPrice());
            ps.setInt(2, cart.getId());
            ps.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    @Override
    public boolean removeItemShoesFromCart(ItemShoes itemShoes, Cart cart) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query1 = "UPDATE itemshoes SET CartID = ? WHERE Barcode = ?";
        String query2 = "UPDATE cart SET Amount = Amount - 1, Price = Price - ? WHERE ID = ?";
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(query1);
            ps.setNull(1, java.sql.Types.INTEGER);
            ps.setString(2, itemShoes.getBarcode());
            ps.executeUpdate();
            
            ps = connection.prepareStatement(query2);
            ps.setFloat(1, itemShoes.getPrice());
            ps.setInt(2, cart.getId());
            ps.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    @Override
    public List<ItemBook> getItemBookOfCart(Cart cart) {
        List<ItemBook> itemBooks = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "SELECT * FROM itembook WHERE CartID = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, cart.getId());
            rs = ps.executeQuery();
            
            while(rs.next()){
                String barcode = rs.getString("Barcode");
                int employeeId = rs.getInt("EmployeeID");
                int feedbackId = rs.getInt("FeedbackID");
                String isbn = rs.getString("BookISBN");
                float price = rs.getFloat("Price");
                String discount = rs.getString("Discount");
                String promoText = rs.getString("PromoText");
                String description = rs.getString("Description");
                String image = rs.getString("Image");
                itemBooks.add(new ItemBook(barcode, employeeId, feedbackId, cart.getId(), isbn, price, discount, promoText, description, image));
            }
            
            return itemBooks;
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
    public List<ItemElectronics> getItemElecOfCart(Cart cart) {
        List<ItemElectronics> itemElecs = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "SELECT * FROM itemelectronics WHERE CartID = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, cart.getId());
            rs = ps.executeQuery();
            
            while(rs.next()){
                String barcode = rs.getString("Barcode");
                int employeeId = rs.getInt("EmployeeID");
                int feedbackId = rs.getInt("FeedbackID");
                int elecId = rs.getInt("ElectronicsID");
                float price = rs.getFloat("Price");
                String discount = rs.getString("Discount");
                String promoText = rs.getString("PromoText");
                String description = rs.getString("Description");
                String image = rs.getString("Image");
                itemElecs.add(new ItemElectronics(barcode, employeeId, feedbackId, cart.getId(), elecId, price, discount, promoText, description, image));
            }
            
            return itemElecs;
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
    public List<ItemShoes> getItemShoesOfCart(Cart cart) {
        List<ItemShoes> itemShoes = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "SELECT * FROM itemshoes WHERE CartID = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, cart.getId());
            rs = ps.executeQuery();
            
            while(rs.next()){
                String barcode = rs.getString("Barcode");
                int employeeId = rs.getInt("EmployeeID");
                int feedbackId = rs.getInt("FeedbackID");
                int shoesId = rs.getInt("ShoesID");
                float price = rs.getFloat("Price");
                String discount = rs.getString("Discount");
                String promoText = rs.getString("PromoText");
                String description = rs.getString("Description");
                String image = rs.getString("Image");
                itemShoes.add(new ItemShoes(barcode, employeeId, feedbackId, cart.getId(), shoesId, price, discount, promoText, description, image));
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
    public List<ItemClothes> getItemClothesOfCart(Cart cart) {
        List<ItemClothes> itemClothes = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "SELECT * FROM itemclothes WHERE CartID = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, cart.getId());
            rs = ps.executeQuery();
            
            while(rs.next()){
                String barcode = rs.getString("Barcode");
                int employeeId = rs.getInt("EmployeeID");
                int feedbackId = rs.getInt("FeedbackID");
                int clothesId = rs.getInt("ClothesID");
                float price = rs.getFloat("Price");
                String discount = rs.getString("Discount");
                String promoText = rs.getString("PromoText");
                String description = rs.getString("Description");
                String image = rs.getString("Image");
                itemClothes.add(new ItemClothes(barcode, employeeId, feedbackId, cart.getId(), clothesId, price, discount, promoText, description, image));
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
    
}
