/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.feedback;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author AD
 */
public class Feedback implements Serializable{
    private int id;
    private int employeeId;
    private int customerCodeCust;
    private String content, response;
    private Date date;

    public Feedback() {
    }

    public Feedback(int id, int employeeId, int customerCodeCust, String content, String response, Date date) {
        this.id = id;
        this.employeeId = employeeId;
        this.customerCodeCust = customerCodeCust;
        this.content = content;
        this.response = response;
        this.date = date;
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

    public int getCustomerCodeCust() {
        return customerCodeCust;
    }

    public void setCustomerCodeCust(int customerCodeCust) {
        this.customerCodeCust = customerCodeCust;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
