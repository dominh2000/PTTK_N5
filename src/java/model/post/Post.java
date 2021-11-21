/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.post;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author AD
 */
public class Post implements Serializable{
    private int id;
    private int employeeId;
    private String title, content;
    private Date date;

    public Post() {
    }

    public Post(int id, int employeeId, String title, String content, Date date) {
        this.id = id;
        this.employeeId = employeeId;
        this.title = title;
        this.content = content;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
