/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.order;

/**
 *
 * @author ASUS
 */
public class Payment {
    private int id;
    private String method;
    private int cartID;
    private int shipmentID;
    private int orderID;
    
    public Payment() {
    }

    public Payment(int id, String method) {
        this.id = id;
        this.method = method;
    }

    public Payment(int id, String method, int cartID, int shipmentID, int orderID) {
        this.id = id;
        this.method = method;
        this.cartID = cartID;
        this.shipmentID = shipmentID;
        this.orderID = orderID;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getShipmentID() {
        return shipmentID;
    }

    public void setShipmentID(int shipmentID) {
        this.shipmentID = shipmentID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    
}
