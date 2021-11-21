/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.chat;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author AD
 */
public class Chat implements Serializable{
    private int id;
    private int customerCodeCust;
    private String content;
    private Date date;

    public Chat() {
    }

    public Chat(int id, int customerCodeCust, String content, Date date) {
        this.id = id;
        this.customerCodeCust = customerCodeCust;
        this.content = content;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
