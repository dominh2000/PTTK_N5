/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
 *
 * @author pc
 */
@WebServlet(name = "AddToCart", urlPatterns = {"/AddToCart"})
public class AddToCart extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/AddToCart":
                    addToCart(request, response);
                    break;
                default:
                    addToCart(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CartDAOImpl cartDAOImpl = new CartDAOImpl();
        ItemBookDAOImpl itemBookDAOImpl = new ItemBookDAOImpl();
        
        String itemID = request.getParameter("itemID");
        String accountID = request.getParameter("accountID");
        String cartId;
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        
        if(request.getParameter("cartID").isEmpty()){
            Cart cart = cartDAOImpl.createCart();
            Cookie cartCookie = new Cookie("cartID", Integer.toString(cart.getId()));
            cartCookie.setMaxAge(60*60);
            response.addCookie(cartCookie);
            cartId = Integer.toString(cart.getId());
        } else{
            cartId = request.getParameter("cartID");
            System.out.println(cartId);
        }
        
        System.out.println("Them vao gio hang co ma " + cartId);
        Cart cartNew = cartDAOImpl.getCartById(Integer.parseInt(cartId));
        ItemBook itemBook = itemBookDAOImpl.getItemBookByCode(itemID);
        if(cartDAOImpl.addItemBookToCart(itemBook, cartNew)){
            List<ItemBook> itemBooks = cartNew.getItemBooks();
            itemBooks.add(itemBook);
            cartNew.setItemBooks(itemBooks);
        }
        
        String prePath = "";
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("prePath")) {
                    prePath = cookie.getValue();
                }
            }

        }
        System.out.println(prePath);
        response.sendRedirect(prePath);

    }

}
