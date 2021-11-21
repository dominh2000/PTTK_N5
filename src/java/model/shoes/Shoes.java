/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.shoes;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author pc
 */
public class Shoes implements Serializable{
    private int id;
    private String name;
    private float size;
    private String sizeCountry;
    private String brand;
    private String color;
    private float weight;
    private Date manufactureDate;
    private String countryOrigin;
    private String department;
    private String upperMaterial;
    private String soleMaterial;
    private String liningMaterial;
    private String dimensions;

    public Shoes() {
    }

    public Shoes(int id, String name, float size, String sizeCountry, String brand, String color, float weight, Date manufactureDate, String countryOrigin, String department, String upperMaterial, String soleMaterial, String liningMaterial, String dimensions) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.sizeCountry = sizeCountry;
        this.brand = brand;
        this.color = color;
        this.weight = weight;
        this.manufactureDate = manufactureDate;
        this.countryOrigin = countryOrigin;
        this.department = department;
        this.upperMaterial = upperMaterial;
        this.soleMaterial = soleMaterial;
        this.liningMaterial = liningMaterial;
        this.dimensions = dimensions;
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

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public String getSizeCountry() {
        return sizeCountry;
    }

    public void setSizeCountry(String sizeCountry) {
        this.sizeCountry = sizeCountry;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUpperMaterial() {
        return upperMaterial;
    }

    public void setUpperMaterial(String upperMaterial) {
        this.upperMaterial = upperMaterial;
    }

    public String getSoleMaterial() {
        return soleMaterial;
    }

    public void setSoleMaterial(String soleMaterial) {
        this.soleMaterial = soleMaterial;
    }

    public String getLiningMaterial() {
        return liningMaterial;
    }

    public void setLiningMaterial(String liningMaterial) {
        this.liningMaterial = liningMaterial;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
    
    
}
