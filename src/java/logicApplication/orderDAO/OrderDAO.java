/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicApplication.orderDAO;
import java.util.List;
import model.order.*;
import model.cart.*;
/**
 *
 * @author ASUS
 */
public interface OrderDAO {
    
    Object getPaymentByID(int id);
    boolean addOrder(Order order, Cart cart, Payment payment, Shipment shipment);
    boolean updateOrder(Order order, Cart cart, Payment payment, Shipment shipment);
    boolean deleteOrder(Order order);
    List<Order> getAllOrder();
    boolean refund(Order order, Payment payment);
    
    
}
