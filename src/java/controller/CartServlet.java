/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logicApplication.cartDAO.CartDAOImpl;
import model.cart.Cart;
import model.itemBook.ItemBook;

/**
 *
 * @author pc
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/CartServlet"})
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/Cart":
                    showCart(request, response);
                    break;
                default:
                    showCart(request, response);
                    break;
            }
        } catch (SQLException e) {

        } catch (Exception e) {
            // TODO Auto-generated catch block
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

    private void showCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CartDAOImpl cartDAOImpl = new CartDAOImpl();
        String cartID = "";
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cartID")) {
                    cartID = cookie.getValue();
                }
            }

        }
        System.out.println(cartID);
        
        if (cartID != "") {
            Cart cart = cartDAOImpl.getCartById(Integer.parseInt(cartID));
            List<ItemBook> itemBooks = cartDAOImpl.getItemBookOfCart(cart);

            request.setAttribute("totalAmount", cart.getAmount());
            request.setAttribute("totalPrice", cart.getPrice());
            request.setAttribute("listItemBooks", itemBooks);
        } else {
            List<ItemBook> itemBooks = new ArrayList<>();

            request.setAttribute("totalAmount", 0);
            request.setAttribute("totalPrice", 0);
            request.setAttribute("listItemBooks", itemBooks);
        }
        request.getRequestDispatcher("Cart.jsp").forward(request, response);
    }
}
