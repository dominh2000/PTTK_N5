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
public class Shorts extends Clothes implements Serializable{
    private int pocketNumber;
    private int moistureWicking;
    private int breathable;
    private String type;
    private float inseam;
    private float outseam;

    public Shorts() {
    }

    public Shorts(int pocketNumber, int moistureWicking, int breathable, String type, float inseam, float outseam, int id, String name, String brand, String color, Date manufacturerDate, String material, String department, String size, String sizeCountry, String washingType, float weight, String fitType, String closureType, String dimensions, String countryOrigin) {
        super(id, name, brand, color, manufacturerDate, material, department, size, sizeCountry, washingType, weight, fitType, closureType, dimensions, countryOrigin);
        this.pocketNumber = pocketNumber;
        this.moistureWicking = moistureWicking;
        this.breathable = breathable;
        this.type = type;
        this.inseam = inseam;
        this.outseam = outseam;
    }

    public int getPocketNumber() {
        return pocketNumber;
    }

    public void setPocketNumber(int pocketNumber) {
        this.pocketNumber = pocketNumber;
    }

    public int getMoistureWicking() {
        return moistureWicking;
    }

    public void setMoistureWicking(int moistureWicking) {
        this.moistureWicking = moistureWicking;
    }

    public int getBreathable() {
        return breathable;
    }

    public void setBreathable(int breathable) {
        this.breathable = breathable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getInseam() {
        return inseam;
    }

    public void setInseam(float inseam) {
        this.inseam = inseam;
    }

    public float getOutseam() {
        return outseam;
    }

    public void setOutseam(float outseam) {
        this.outseam = outseam;
    }
    
    
}
