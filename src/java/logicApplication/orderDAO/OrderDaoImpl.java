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
import java.sql.SQLException;
import java.util.List;
import model.cart.Cart;
import model.order.*;

/**
 *
 * @author ASUS
 */
public class OrderDaoImpl implements OrderDAO{

    @Override
    public boolean addOrder(Order order, Cart cart, Payment payment, Shipment shipment) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query_1 = "INSERT INTO payment ( id, cartID, shipmentID, orderID, method) values (?,?,?,?,?)";
        String query_2 = "INSERT INTO shipment (id, OrderID, method, cost, shippingAddress) values (?,?,?,?,?)";
        String query_3 = "INSERT INTO cart ( id,  orderId,  amount,  price)values (?,?,?,?)";
        String query_4 = "INSERT INTO order ( id, totalPrice, tax, status) values (?,?,?,?)";
        
        PreparedStatement ps = null;
        
        try {
            ps = connection.prepareStatement(query_1);
            ps.setInt(1, payment.getId());
            ps.setInt(2, payment.getCartID());
            ps.setInt(3, payment.getShipmentID());
            ps.setInt(4, payment.getOrderID());
            ps.setString(5, payment.getMethod());
            ps.execute();
            
            ps = connection.prepareStatement(query_2);
            ps.setInt(1, shipment.getId());
            ps.setInt(2, shipment.getOrderID());
            ps.setString(3, shipment.getMethod());
            ps.setFloat(4, shipment.getCost());
            ps.setString(5, shipment.getShippingAddress());           
            ps.execute();
            
            ps = connection.prepareStatement(query_3);
            ps.setInt(1, cart.getId());
            ps.setInt(2, cart.getOrderId());
            ps.setInt(3, cart.getAmount());
            ps.setFloat(4, cart.getPrice());     
            ps.execute();
            
            ps = connection.prepareStatement(query_4);
            ps.setInt(1, order.getId());
            ps.setFloat(2, order.getTotalPrice());
            ps.setFloat(3, order.getTax());
            ps.setString(4, order.getStatus());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Order> getAllOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean refund(Order order, Payment payment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
