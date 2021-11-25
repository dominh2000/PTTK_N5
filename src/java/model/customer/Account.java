/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.customer;

import java.io.Serializable;

/**
 *
 * @author pc
 */
public class Account implements Serializable{
    private int id;
    private int employeeId;
    private int customerCodeCust;
    private String username;
    private String password;

    public Account() {
    }

    public Account(int id, int employeeId, int customerId, String username, String password) {
        this.id = id;
        this.employeeId = employeeId;
        this.customerCodeCust = customerId;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getCustomerId() {
        return customerCodeCust;
    }

    public void setCustomerId(int customerId) {
        this.customerCodeCust = customerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
