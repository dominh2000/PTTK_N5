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
import java.util.logging.Level;
import java.util.logging.Logger;
import logicApplication.bookDAO.BookDAOImpl;
import logicApplication.clothesDAO.ClothesDAOImpl;
import logicApplication.electronicsDAO.ElectronicsDAOImpl;
import logicApplication.orderDAO.OrderDaoImpl;
import logicApplication.shoesDAO.ShoesDAOImpl;
import model.book.Book;
import model.cart.Cart;
import model.clothes.Coat;
import model.clothes.Jeans;
import model.clothes.Shorts;
import model.clothes.TShirt;
import model.electronics.Hairdryer;
import model.electronics.Laptop;
import model.electronics.MobilePhone;
import model.electronics.PC;
import model.itemBook.ItemBook;
import model.itemClothes.ItemClothes;
import model.itemElectronics.ItemElectronics;
import model.itemShoes.ItemShoes;
import model.order.Cash;
import model.order.Credit;
import model.order.Payment;
import model.shoes.Boot;
import model.shoes.BusinessShoes;
import model.shoes.RunningShoes;
import model.shoes.Sneaker;

/**
 *
 * @author pc
 */
public class CartDAOImpl implements CartDAO {

    @Override
    public Cart getCartById(int id) {
        OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
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

            if (rs.next()) {
                int amount = rs.getInt("Amount");
                float totalPrice = rs.getFloat("TotalPrice");

                List<ItemBook> itemBooks = getItemBookOfCart(cart);
                List<ItemElectronics> itemElectronics = getItemElecOfCart(cart);
                List<ItemClothes> itemClothes = getItemClothesOfCart(cart);
                List<ItemShoes> itemShoes = getItemShoesOfCart(cart);
                List<Payment> payments = getListPaymentsOfCart(id);
                List<Cash> cashes = new ArrayList<>();
                List<Credit> credits = new ArrayList<>();

                for (Payment payment : payments) {
                    Object pay = orderDaoImpl.getPaymentByID(payment.getId());
                    if (pay instanceof Cash) {
                        Cash cash = (Cash) pay;
                        cashes.add(cash);
                    } else if (pay instanceof Credit) {
                        Credit credit = (Credit) pay;
                        credits.add(credit);
                    }
                }

                cart = new Cart(id, amount, totalPrice, itemBooks, itemElectronics, itemClothes, itemShoes, cashes, credits);
            }

            return cart;
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
    public List<Payment> getListPaymentsOfCart(int cartID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        List<Payment> payments = new ArrayList<>();
        String query = "SELECT * FROM payment WHERE CartID = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, cartID);
            rs = ps.executeQuery();

            while (rs.next()) {
                Payment payment = null;
                int id = rs.getInt("ID");
                String method = rs.getString("Method");
                payment = new Payment(id, method);
                payments.add(payment);
            }
            return payments;
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
        BookDAOImpl bookDAOImpl = new BookDAOImpl();
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

            while (rs.next()) {
                String barcode = rs.getString("Barcode");
                int feedbackId = rs.getInt("FeedbackID");
                String isbn = rs.getString("BookISBN");
                float price = rs.getFloat("Price");
                String discount = rs.getString("Discount");
                String promoText = rs.getString("PromoText");
                String description = rs.getString("Description");
                String image = rs.getString("Image");

                Book book = bookDAOImpl.getByISBN(isbn);
                itemBooks.add(new ItemBook(barcode, price, discount, promoText, description, image, book));
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
        ElectronicsDAOImpl electronicsDAOImpl = new ElectronicsDAOImpl();
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

            while (rs.next()) {
                String barcode = rs.getString("Barcode");
                int feedbackId = rs.getInt("FeedbackID");
                int elecId = rs.getInt("ElectronicsID");
                float price = rs.getFloat("Price");
                String discount = rs.getString("Discount");
                String promoText = rs.getString("PromoText");
                String description = rs.getString("Description");
                String image = rs.getString("Image");

                Object elec = electronicsDAOImpl.getByID(elecId);
                if (elec instanceof Hairdryer) {
                    Hairdryer hairdryer = (Hairdryer) elec;
                    itemElecs.add(new ItemElectronics(barcode, price, discount, promoText, description, image, hairdryer));
                } else if (elec instanceof Laptop) {
                    Laptop laptop = (Laptop) elec;
                    itemElecs.add(new ItemElectronics(barcode, price, discount, promoText, description, image, laptop));
                } else if (elec instanceof MobilePhone) {
                    MobilePhone mobilePhone = (MobilePhone) elec;
                    itemElecs.add(new ItemElectronics(barcode, price, discount, promoText, description, image, mobilePhone));
                } else if (elec instanceof PC) {
                    PC pc = (PC) elec;
                    itemElecs.add(new ItemElectronics(barcode, price, discount, promoText, description, image, pc));
                }
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
        ShoesDAOImpl shoesDAOImpl = new ShoesDAOImpl();
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

            while (rs.next()) {
                String barcode = rs.getString("Barcode");
                int feedbackId = rs.getInt("FeedbackID");
                int shoesId = rs.getInt("ShoesID");
                float price = rs.getFloat("Price");
                String discount = rs.getString("Discount");
                String promoText = rs.getString("PromoText");
                String description = rs.getString("Description");
                String image = rs.getString("Image");

                Object shoe = shoesDAOImpl.getByID(shoesId);
                if (shoe instanceof Sneaker) {
                    Sneaker sneaker = (Sneaker) shoe;
                    itemShoes.add(new ItemShoes(barcode, price, discount, promoText, description, image, sneaker));
                } else if (shoe instanceof BusinessShoes) {
                    BusinessShoes businessShoes = (BusinessShoes) shoe;
                    itemShoes.add(new ItemShoes(barcode, price, discount, promoText, description, image, businessShoes));
                } else if (shoe instanceof RunningShoes) {
                    RunningShoes runningShoes = (RunningShoes) shoe;
                    itemShoes.add(new ItemShoes(barcode, price, discount, promoText, description, image, runningShoes));
                } else if (shoe instanceof Boot) {
                    Boot boot = (Boot) shoe;
                    itemShoes.add(new ItemShoes(barcode, price, discount, promoText, description, image, boot));
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
    public List<ItemClothes> getItemClothesOfCart(Cart cart) {
        ClothesDAOImpl clothesDAOImpl = new ClothesDAOImpl();
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

            while (rs.next()) {
                String barcode = rs.getString("Barcode");
                int feedbackId = rs.getInt("FeedbackID");
                int clothesId = rs.getInt("ClothesID");
                float price = rs.getFloat("Price");
                String discount = rs.getString("Discount");
                String promoText = rs.getString("PromoText");
                String description = rs.getString("Description");
                String image = rs.getString("Image");

                Object cloth = clothesDAOImpl.getByID(clothesId);
                if (cloth instanceof TShirt) {
                    TShirt tShirt = (TShirt) cloth;
                    itemClothes.add(new ItemClothes(barcode, price, discount, promoText, description, image, tShirt));
                } else if (cloth instanceof Coat) {
                    Coat coat = (Coat) cloth;
                    itemClothes.add(new ItemClothes(barcode, price, discount, promoText, description, image, coat));
                } else if (cloth instanceof Jeans) {
                    Jeans jeans = (Jeans) cloth;
                    itemClothes.add(new ItemClothes(barcode, price, discount, promoText, description, image, jeans));
                } else if (cloth instanceof Shorts) {
                    Shorts shorts = (Shorts) cloth;
                    itemClothes.add(new ItemClothes(barcode, price, discount, promoText, description, image, shorts));
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

}
