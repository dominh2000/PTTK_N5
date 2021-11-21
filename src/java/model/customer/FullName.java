/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.customer;

/**
 *
 * @author pc
 */
public class FullName {
    private int id;
    private int employeeId;
    private int customerId;
    private String firstName;
    private String lastName;
    private String midName;

    public FullName(int id, int employeeId, int customerId, String firstName, String lastName, String midName) {
        this.id = id;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.midName = midName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }
    
}
