/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logicApplication.cartDAO.CartDAOImpl;

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
        String itemID = request.getParameter("itemID");
        String accountID = request.getParameter("accountID");
        String cartId = request.getParameter("cartID");
        int quantity = Integer.parseInt(request.getParameter("quantity"));


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
        if (prePath.equals("Home")) {
            response.sendRedirect("Home");
        } else if (prePath.equals("Cart")) {
            response.sendRedirect("Cart");
        }

    }

}
