package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logicApplication.cartDAO.CartDAOImpl;
import logicApplication.itemBookDAO.ItemBookDAOImpl;
import model.cart.Cart;
import model.itemBook.ItemBook;

/**
 * Servlet implementation class Home
 */
@WebServlet(name = "Home", urlPatterns = {"/Home"})
public class Home extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                default:
                    showHomePage(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
    
    private void showHomePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        RequestDispatcher dispatcher = null;
        
        // Hien thi danh sach mat hang
        ItemBookDAOImpl itemBookDAOImpl = new ItemBookDAOImpl();
        List<ItemBook> itemBooks = itemBookDAOImpl.getAllItemBook();
        request.setAttribute("listItemBook", itemBooks);
        System.out.println(itemBooks.size());
        dispatcher = request.getRequestDispatcher("HomePage.jsp");
        dispatcher.forward(request, response);
    }

}
