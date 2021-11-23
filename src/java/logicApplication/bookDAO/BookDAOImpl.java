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
public class BookDAOImpl implements BookDAO {

    @Override
    public Book getByISBN(String isbn) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        Book book = new Book();

        String query1 = "SELECT * FROM book WHERE ISBN = ?";
        String query2 = "SELECT * FROM publisher WHERE ID = ?";
        String query3 = "SELECT * FROM category WHERE ID = ?";
        String query4 = "SELECT AuthorID FROM book_author WHERE BookISBN = ?";
        String query5 = "SELECT * FROM author WHERE ID = ?";

        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        PreparedStatement ps4 = null;
        PreparedStatement ps5 = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        ResultSet rs4 = null;
        ResultSet rs5 = null;

        try {
            ps1 = connection.prepareStatement(query1);
            ps1.setString(1, isbn);
            rs1 = ps1.executeQuery();

            if (rs1.next()) {
                // Lay cac tham so co ban cua Book
                int categoryId = rs1.getInt("CategoryID");
                int publisherId = rs1.getInt("PublisherID");
                String title = rs1.getString("Title");
                String summary = rs1.getString("Summary");
                Date publicationDate = rs1.getDate("PublicationDate");
                int numOfPages = rs1.getInt("NumOfPages");
                String language = rs1.getString("Language");
                String dimensions = rs1.getString("Dimensions");
                float weight = rs1.getFloat("Weight");
                String edition = rs1.getString("Edition");

                book.setIsbn(isbn);
                book.setTitle(title);
                book.setSummary(summary);
                book.setPublicatioDate(publicationDate);
                book.setNumOfPages(numOfPages);
                book.setLanguage(language);
                book.setDimensions(dimensions);
                book.setWeight(weight);
                book.setEdition(edition);

                Publisher publisher = null;
                Category category = null;
                List<Integer> authorIDs = new ArrayList<>();
                List<Author> authors = new ArrayList<>();

                // Lay Publisher
                ps2 = connection.prepareStatement(query2);
                ps2.setInt(1, publisherId);
                rs2 = ps2.executeQuery();

                if (rs2.next()) {
                    String name = rs2.getString("Name");
                    String address = rs2.getString("Address");
                    publisher = new Publisher(publisherId, name, address);
                    book.setPublisher(publisher);
                }

                // Lay Category
                ps3 = connection.prepareStatement(query3);
                ps3.setInt(1, categoryId);
                rs3 = ps3.executeQuery();

                if (rs3.next()) {
                    String type = rs3.getString("Type");
                    category = new Category(categoryId, type);
                    book.setCategory(category);
                }

                // Lay danh sach ID cac tac gia
                ps4 = connection.prepareStatement(query4);
                ps4.setString(1, isbn);
                rs4 = ps4.executeQuery();

                while (rs4.next()) {
                    int authorID = rs4.getInt("AuthorID");
                    authorIDs.add(authorID);
                }

                // Lay List<Author>
                ps5 = connection.prepareStatement(query5);
                for (Integer authorID : authorIDs) {
                    Author author = null;
                    ps5.setInt(1, authorID);
                    rs5 = ps5.executeQuery();

                    if (rs5.next()) {
                        String name = rs5.getString("Name");
                        String bio = rs5.getString("Biography");
                        author = new Author(authorID, name, bio);
                        authors.add(author);
                    }
                }
                book.setAuthor(authors);

                return book;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps1);
            DBUtil.closePreparedStatement(ps2);
            DBUtil.closePreparedStatement(ps3);
            DBUtil.closePreparedStatement(ps4);
            DBUtil.closePreparedStatement(ps5);
            DBUtil.closeResultSet(rs1);
            DBUtil.closeResultSet(rs2);
            DBUtil.closeResultSet(rs3);
            DBUtil.closeResultSet(rs4);
            DBUtil.closeResultSet(rs5);
            pool.freeConnection(connection);
        }
    }

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

            while (rs.next()) {
                String isbn = rs.getString("ISBN");
                Book book = getByISBN(isbn);
                resBooks.add(book);
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
