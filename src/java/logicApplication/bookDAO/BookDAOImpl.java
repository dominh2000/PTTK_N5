/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicApplication.bookDAO;

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
import model.book.Author;
import model.book.Book;
import model.book.Category;
import model.book.Publisher;

/**
 *
 * @author pc
 */
public class BookDAOImpl implements BookDAO{

    @Override
    public List<Book> getByTitle(String title) {
        List<Book> resBooks = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        String query1 = "SELECT * FROM book WHERE Title = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = connection.prepareStatement(query1);
            ps.setString(1, title);
            rs = ps.executeQuery();
            
            while(rs.next()){
                String isbn = rs.getString("ISBN");
                int categoryId = rs.getInt("CategoryID");
                int publisherId = rs.getInt("PublisherID");
                String summary = rs.getString("Summary");
                Date publicationDate = rs.getDate("PublicationDate");
                int numOfPages = rs.getInt("NumOfPages");
                String language = rs.getString("Language");
                String dimensions = rs.getString("Dimensions");
                float weight = rs.getFloat("Weight");
                String edition = rs.getString("Edition");
                
                resBooks.add(new Book(isbn, categoryId, publisherId, title, summary, publicationDate, numOfPages, language, dimensions, weight, edition));
            }
            return resBooks;
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
    public Book addBook(Book book, Publisher publisher, Author author, Category cat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifyBookInfo(Book book, Publisher publisher, Author author, Category cat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteBook(Book book) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
