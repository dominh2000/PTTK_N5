/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.electronics;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author pc
 */
public class Electronics implements Serializable{
    private int id;
    private String name;
    private String manufacturer;
    private Date manufactureDate;
    private float weight;
    private String color;
    private int warranty;
    private String dimensions;
    private String countryOrigin;

    public Electronics() {
    }

    public Electronics(int id, String name, String manufacturer, Date manufactureDate, float weight, String color, int warranty, String dimensions, String countryOrigin) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.manufactureDate = manufactureDate;
        this.weight = weight;
        this.color = color;
        this.warranty = warranty;
        this.dimensions = dimensions;
        this.countryOrigin = countryOrigin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }
    
    
}
