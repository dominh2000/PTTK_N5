/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logicApplication.itemBookDAO.ItemBookDAOImpl;
import model.itemBook.ItemBook;

/**
 *
 * @author pc
 */
@WebServlet(name = "BookPage", urlPatterns = {"/BookPage"})
public class BookPage extends HttpServlet {
private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookPage() {
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
                    showBookPage(request, response);
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

    private void showBookPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        RequestDispatcher dispatcher = null;
        ItemBookDAOImpl itemBookDAOImpl = new ItemBookDAOImpl();
        List<ItemBook> itemBooks = itemBookDAOImpl.getAllItemBook();
        request.setAttribute("listItemBook", itemBooks);
        System.out.println(itemBooks.size());
        dispatcher = request.getRequestDispatcher("BookPage.jsp");
        dispatcher.forward(request, response);
    }
}
