/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.clothes;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author pc
 */
public class Clothes implements Serializable{
    private int id;
    private String name;
    private String brand;
    private String color;
    private Date manufacturerDate;
    private String material;
    private String department;
    private String size;
    private String sizeCountry;
    private String washingType;
    private float weight;
    private String fitType;
    private String closureType;
    private String dimensions;
    private String countryOrigin;

    public Clothes() {
    }

    public Clothes(int id, String name, String brand, String color, Date manufacturerDate, String material, String department, String size, String sizeCountry, String washingType, float weight, String fitType, String closureType, String dimensions, String countryOrigin) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.manufacturerDate = manufacturerDate;
        this.material = material;
        this.department = department;
        this.size = size;
        this.sizeCountry = sizeCountry;
        this.washingType = washingType;
        this.weight = weight;
        this.fitType = fitType;
        this.closureType = closureType;
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

    public Date getManufacturerDate() {
        return manufacturerDate;
    }

    public void setManufacturerDate(Date manufacturerDate) {
        this.manufacturerDate = manufacturerDate;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSizeCountry() {
        return sizeCountry;
    }

    public void setSizeCountry(String sizeCountry) {
        this.sizeCountry = sizeCountry;
    }

    public String getWashingType() {
        return washingType;
    }

    public void setWashingType(String washingType) {
        this.washingType = washingType;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getFitType() {
        return fitType;
    }

    public void setFitType(String fitType) {
        this.fitType = fitType;
    }

    public String getClosureType() {
        return closureType;
    }

    public void setClosureType(String closureType) {
        this.closureType = closureType;
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
