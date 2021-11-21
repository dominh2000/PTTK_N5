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
public class Address implements Serializable{
    private int id;
    private int employeeId;
    private int customerId;
    private int noHouse;
    private String street;
    private String district;
    private String city;

    public Address() {
    }

    public Address(int id, int employeeId, int customerId, int noHouse, String street, String district, String city) {
        this.id = id;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.noHouse = noHouse;
        this.street = street;
        this.district = district;
        this.city = city;
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
  
    public int getNoHouse() {
        return noHouse;
    }

    public void setNoHouse(int noHouse) {
        this.noHouse = noHouse;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
}
