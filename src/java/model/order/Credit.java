/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.order;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author pc
 */
public class Credit extends Payment implements Serializable{
    private String number;
    private String type;
    private Date expDate;

    public Credit() {
    }

    public Credit(String number, String type, Date expDate, int id, String method) {
        super(id, method);
        this.number = number;
        this.type = type;
        this.expDate = expDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }
    
    
}
