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
                int employeeId = rs.getInt("EmployeeID");
                int feedbackId = rs.getInt("FeedbackID");
                int cartId = rs.getInt("CartID");
                String isbn = rs.getString("BookISBN");
                float price = rs.getFloat("Price");
                String discount = rs.getString("Discount");
                String promoText = rs.getString("PromoText");
                String description = rs.getString("Description");
                String image = rs.getString("Description");
                itemBook = new ItemBook(code, employeeId, feedbackId, cartId, isbn, price, discount, promoText, description, image);
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
    public List<ItemBook> searchByTitle(String title) {
        BookDAOImpl bookDAO = new BookDAOImpl();
        List<Book> listBooks = bookDAO.getByTitle(title);

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
                        int employeeId = rs.getInt("EmployeeID");
                        int feedbackId = rs.getInt("FeedbackID");
                        int cartId = rs.getInt("CartID");
                        float price = rs.getFloat("Price");
                        String discount = rs.getString("Discount");
                        String promoText = rs.getString("PromoText");
                        String description = rs.getString("Description");
                        String image = rs.getString("Image");

                        listItemBooks.add(new ItemBook(barcode, employeeId, feedbackId, cartId, book.getIsbn(), price, discount, promoText, description, image));
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
    public Book getBook(Book book) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        String query1 = "SELECT * FROM book_author WHERE BookISBN = ?";
        String query2 = "SELECT * FROM author WHERE ID = ?";
        String query3 = "SELECT * FROM publisher WHERE ID = ?";
        String query4 = "SELECT * FROM category WHERE ID = ?";
        
        List<Author> listAuthors = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = connection.prepareStatement(query1);
            ps.setString(1, book.getIsbn());
            rs = ps.executeQuery();
            
            List<Integer> listAuthorId = new ArrayList<>();
            while(rs.next()){
                int authorId = rs.getInt("AuthorID");
                listAuthorId.add(authorId);
            }
            
            ps = connection.prepareStatement(query2);
            for(Integer i: listAuthorId){
                ps.setInt(1, i);
                rs = ps.executeQuery();
                
                if(rs.next()){
                    String name = rs.getString("Name");
                    String biography = rs.getString("Biography");
                    listAuthors.add(new Author(i, name, biography));
                }
            }
            book.setAuthor(listAuthors);
            
            Publisher publisher = null;
            ps = connection.prepareStatement(query3);
            ps.setInt(1, book.getPublisherId());
            rs = ps.executeQuery();
            if(rs.next()){
                String name = rs.getString("Name");
                String address = rs.getString("Address");
                publisher = new Publisher(book.getPublisherId(), name, address);
            }
            book.setPublisher(publisher);
            
            Category category = null;
            ps = connection.prepareStatement(query4);
            ps.setInt(1, book.getCategoryId());
            rs = ps.executeQuery();
            if(rs.next()){
                String type = rs.getString("Type");
                category = new Category(book.getCategoryId(), type);
            }
            book.setCategory(category);
            
            return book;
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
