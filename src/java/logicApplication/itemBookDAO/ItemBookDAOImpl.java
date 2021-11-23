/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicApplication.itemBookDAO;

import connectionPool.ConnectionPool;
import connectionPool.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logicApplication.bookDAO.BookDAOImpl;
import model.book.Author;
import model.book.Book;
import model.book.Category;
import model.book.Publisher;
import model.itemBook.ItemBook;

/**
 *
 * @author pc
 */
public class ItemBookDAOImpl implements ItemBookDAO {

    @Override
    public ItemBook getItemBookByCode(String code) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        String query = "SELECT * FROM itembook WHERE Barcode = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, code);
            rs = ps.executeQuery();

            ItemBook itemBook = null;
            if (rs.next()) {
                int feedbackId = rs.getInt("FeedbackID");
                int cartId = rs.getInt("CartID");
                String isbn = rs.getString("BookISBN");
                float price = rs.getFloat("Price");
                String discount = rs.getString("Discount");
                String promoText = rs.getString("PromoText");
                String description = rs.getString("Description");
                String image = rs.getString("Description");
                
                Book book = getBook(isbn);
                itemBook = new ItemBook(code, price, discount, promoText, description, image, book);
            }
            return itemBook;
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
    public List<ItemBook> searchByTitle(String title) {;
        List<Book> listBooks = getBookByTitle(title);

        if (listBooks == null) {
            return null;
        } else {
            List<ItemBook> listItemBooks = new ArrayList<>();
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();

            String query = "SELECT * FROM itembook WHERE BookISBN = ?";
            PreparedStatement ps = null;
            ResultSet rs = null;

            try {
                ps = connection.prepareStatement(query);
                for (Book book : listBooks) {
                    ps.setString(1, book.getIsbn());
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

                        listItemBooks.add(new ItemBook(barcode, price, discount, promoText, description, image, book));
                    }
                }

                return listItemBooks;
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
    public List<ItemBook> getAllItemBook() {
        List<ItemBook> listItemBooks = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        String query = "SELECT * FROM itembook";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                String barcode = rs.getString("Barcode");
                int feedbackId = rs.getInt("FeedbackID");
                int cartId = rs.getInt("CartID");
                String bookISBN = rs.getString("BookISBN");
                float price = rs.getFloat("Price");
                String discount = rs.getString("Discount");
                String promoText = rs.getString("PromoText");
                String description = rs.getString("Description");
                String image = rs.getString("Image");
                Book book = getBook(bookISBN);

                listItemBooks.add(new ItemBook(barcode, price, discount, promoText, description, image, book));
            }
            return listItemBooks;
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
    public Book getBook(String isbn) {
        BookDAOImpl bookDAOImpl = new BookDAOImpl();
        return bookDAOImpl.getByISBN(isbn);
    }
    
    @Override
    public List<Book> getBookByTitle(String title) {
        BookDAOImpl bookDAOImpl = new BookDAOImpl();
        return bookDAOImpl.getByTitle(title);
    }

    @Override
    public ItemBook addItemBook(Book book, ItemBook itemBook) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteItemBook(ItemBook itemBook) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ItemBook modifyItemBook(ItemBook itemBook) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
