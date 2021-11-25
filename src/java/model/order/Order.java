/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.order;

import model.cart.Cart;

/**
 *
 * @author ASUS
 */
public class Order {
    private int id;
    private int employeeID;
    private int customerCodeCust;
    private float totalPrice;
    private float tax;
    private String status;
    private Shipment shipment;
    private Payment payment;
    private Cart cart;

    public Order(int id, float totalPrice, float tax, String status, Shipment shipment, Payment payment, Cart cart) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.tax = tax;
        this.status = status;
        this.shipment = shipment;
        this.payment = payment;
        this.cart = cart;
    }

    public Order(int id, int employeeID, int customerCodeCust, float totalPrice, float tax, String status, Shipment shipment, Payment payment, Cart cart) {
        this.id = id;
        this.employeeID = employeeID;
        this.customerCodeCust = customerCodeCust;
        this.totalPrice = totalPrice;
        this.tax = tax;
        this.status = status;
        this.shipment = shipment;
        this.payment = payment;
        this.cart = cart;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getCustomerCodeCust() {
        return customerCodeCust;
    }

    public void setCustomerCodeCust(int customerCodeCust) {
        this.customerCodeCust = customerCodeCust;
    }
    
   

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
