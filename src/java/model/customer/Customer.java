/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.customer;

import java.util.Date;

/**
 *
 * @author pc
 */
public class Customer {
    private int customerID;
    private Date dateOfBirth;
    private String telephone;
    private FullName fullname;
    private Account account;
    private Address address;

    public Customer(int customerID, Date dateOfBirth, String telephone, FullName fullname, Account account, Address address) {
        this.customerID = customerID;
        this.dateOfBirth = dateOfBirth;
        this.telephone = telephone;
        this.fullname = fullname;
        this.account = account;
        this.address = address;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public FullName getFullname() {
        return fullname;
    }

    public void setFullname(FullName fullname) {
        this.fullname = fullname;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
}
