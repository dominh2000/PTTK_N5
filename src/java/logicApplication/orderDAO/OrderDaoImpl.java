/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicApplication.orderDAO;

import connectionPool.ConnectionPool;
import connectionPool.DBUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.cart.Cart;
import model.order.*;

/**
 *
 * @author ASUS
 */
public class OrderDaoImpl implements OrderDAO {

    @Override
    public boolean addOrder(Order order, Cart cart, Payment payment, Shipment shipment) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query_1 = "INSERT INTO payment ( id, cartID, shipmentID, orderID, method) values (?,?,?,?,?)";
        String query_2 = "INSERT INTO shipment (id, orderID, method, cost, shippingAddress) values (?,?,?,?)";
        String query_3 = "INSERT INTO cart ( id, orderID, amount,  price)values (?,?,?,?)";
        String query_4 = "INSERT INTO order ( id, employeeID, customerCodeCust, totalPrice, tax, status) values (?,?,?,?)";

        PreparedStatement ps = null;

        try {
            //add payment
            ps = connection.prepareStatement(query_1);
            ps.setInt(1, payment.getId());
            ps.setInt(2, payment.getCartID());
            ps.setInt(3, payment.getShipmentID());
            ps.setInt(4, payment.getOrderID());
            ps.setString(5, payment.getMethod());
            ps.execute();

            //add shipment
            ps = connection.prepareStatement(query_2);
            ps.setInt(1, shipment.getId());
            ps.setInt(2,shipment.getOrderID());
            ps.setString(3, shipment.getMethod());
            ps.setFloat(4, shipment.getCost());
            ps.setString(5, shipment.getShippingAddress());
            ps.execute();

            //add cart
            ps = connection.prepareStatement(query_3);
            ps.setInt(1, cart.getId());
            ps.setInt(2, cart.getOrderID());
            ps.setInt(3, cart.getAmount());
            ps.setFloat(4, cart.getPrice());
            ps.execute();
            
            //add order
            ps = connection.prepareStatement(query_4);
            ps.setInt(1, order.getId());
            ps.setInt(2, order.getEmployeeID());
            ps.setInt(3, order.getCustomerCodeCust());
            ps.setFloat(4, order.getTotalPrice());
            ps.setFloat(5, order.getTax());
            ps.setString(6, order.getStatus());
            ps.execute();
            
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
    public boolean updateOrder(Order order, Cart cart, Payment payment, Shipment shipment) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query_1 = "UPDATE payment SET cartID = ? , shipmentID = ?, method = ? WHERE payment.orderID = ?";
        String query_2 = "UPDATE shipment SET method = ? , cost = ? , shippingAddress = ? WHERE shipment.orderID = ?";
        String query_3 = "UPDATE cart SET amount = ? ,  price = ?  WHERE cart.orderID = ?";
        String query_4 = "UPDATE order SET employeeID = ? , customerCodeCust = ? , totalPrice = ? , tax = ?, status = ? WHERE order.ID = ?";
        PreparedStatement ps = null;
        try {
            //update payment
            ps = connection.prepareStatement(query_1);
            ps.setInt(1, payment.getCartID());
            ps.setInt(2, payment.getShipmentID());
            ps.setString(3, payment.getMethod());
            ps.setInt(4, payment.getOrderID());
            ps.execute();

            //update shipment
            ps = connection.prepareStatement(query_2);
            ps.setString(1, shipment.getMethod());
            ps.setFloat(2, shipment.getCost());
            ps.setString(3, shipment.getShippingAddress());
            ps.setInt(4, shipment.getOrderID());
            ps.execute();

            //update cart
            ps = connection.prepareStatement(query_3);          
            ps.setInt(1, cart.getAmount());
            ps.setFloat(2, cart.getPrice());
            ps.setInt(1, cart.getOrderID());
            ps.execute();
            
            //update order
            ps = connection.prepareStatement(query_4);
            ps.setInt(1, order.getEmployeeID());
            ps.setInt(2, order.getCustomerCodeCust());
            ps.setFloat(3, order.getTotalPrice());
            ps.setFloat(4, order.getTax());
            ps.setString(5, order.getStatus());
            ps.setInt(1, order.getId());
            ps.execute();
            
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
    public boolean deleteOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Order> getAllOrder() {
        List<Order> orders = null;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query_1 = "SELECT * FROM order";       
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(query_1);
            rs = ps.executeQuery();          
            while(rs.next()){               
                int id = rs.getInt("id");
                int employeeID = rs.getInt("employeeID");
                int customerCodeCust = rs.getInt("customerCodeCust");
                float totalPrice = rs.getFloat("totalPrice");
                float tax = rs.getFloat("tax");
                String status = rs.getString("status");
                
                PreparedStatement ps_2 = null;
                ResultSet rs_2 = null;
                String query_Payment = "SELECT * FROM payment where payment.orderID = ?";
                ps_2 = connection.prepareStatement(query_Payment);
                ps_2.setInt(1, id);
                rs_2 = ps.executeQuery();
                Payment payment = null;
                while(rs_2.next()){
                    int id_payment = rs_2.getInt("id");                  
                    int cartID = rs_2.getInt("cartID");
                    int shipmentID = rs_2.getInt("shipmentID");
                    int orderID = rs_2.getInt("orderID");       
                    String method = rs_2.getString("method");
                    payment = new Payment(id, method, cartID, shipmentID, orderID);
                }
                String query_Shipment = "SELECT * FROM shipment where shipnment.orderID = ?";
                ps_2 = connection.prepareStatement(query_Shipment);
                ps_2.setInt(1, id);
                rs_2 = ps.executeQuery();
                Shipment shipment = null;
                while(rs_2.next()){
                    int id_Shipment = rs_2.getInt("id");
                    int orderID = rs_2.getInt("orderID"); 
                    float cost = rs_2.getFloat("cost");
                    String method = rs_2.getString("method");
                    String shipping_Add = rs_2.getString("shippingAddress");
                    shipment = new Shipment(id, orderID, method, cost, shipping_Add, payment);
                }
                String query_Cart = "SELECT * FROM cart where cart.orderID = ?";
                ps_2 = connection.prepareStatement(query_Cart);
                ps_2.setInt(1, id);
                rs_2 = ps.executeQuery();
                Cart cart = null;
                while(rs_2.next()){
                    int id_cart = rs_2.getInt("id");
                    int orderID = rs_2.getInt("orderID");
                    int amount = rs_2.getInt("amount");
                    float price = rs_2.getFloat("price");
                    cart = new Cart(id, orderID, amount, totalPrice);
                }
                Order order = new Order(id, employeeID, customerCodeCust, totalPrice, tax, status, shipment, payment, cart);
                orders.add(order);
            }
            
            return orders;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally{
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    @Override
    public boolean refund(Order order, Payment payment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getPaymentByID(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        String query0 = "SELECT * FROM payment WHERE ID = ?";
        PreparedStatement ps0 = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        ResultSet rs0 = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;

        try {
            ps0 = connection.prepareStatement(query0);
            ps0.setInt(1, id);
            rs0 = ps0.executeQuery();

            if (rs0.next()) {
                String method = rs0.getString("Method");

                String query1 = "SELECT * FROM cash WHERE PaymentID = ?";
                String query2 = "SELECT * FROM credit WHERE PaymentID = ?";

                ps1 = connection.prepareStatement(query1);
                ps1.setInt(1, id);
                rs1 = ps1.executeQuery();

                ps2 = connection.prepareStatement(query2);
                ps2.setInt(1, id);
                rs2 = ps2.executeQuery();

                if (rs1 != null) {
                    Cash cash = null;
                    float cashTendered = rs1.getFloat("CashTendered");
                    cash = new Cash(cashTendered, id, method);
                    return cash;
                } else if (rs2 != null) {
                    Credit credit = null;
                    String number = rs2.getString("Number");
                    String type = rs2.getString("Type");
                    Date expDate = rs2.getDate("ExpDate");
                    credit = new Credit(number, type, expDate, id, method);
                    return credit;
                }
            }
            return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            DBUtil.closeResultSet(rs0);
            DBUtil.closePreparedStatement(ps0);
            DBUtil.closeResultSet(rs1);
            DBUtil.closePreparedStatement(ps1);
            DBUtil.closeResultSet(rs2);
            DBUtil.closePreparedStatement(ps2);
            pool.freeConnection(connection);
        }
    }

}
