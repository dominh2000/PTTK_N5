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
public class Jeans extends Clothes implements Serializable{
    private float waist;
    private float frontRise;
    private float backRise;
    private float upperThigh;
    private float inseam;
    private float legOpening;
    private int pocketNumber;

    public Jeans() {
    }

    public Jeans(float waist, float frontRise, float backRise, float upperThigh, float inseam, float legOpening, int pocketNumber, int id, String name, String brand, String color, Date manufacturerDate, String material, String department, String size, String sizeCountry, String washingType, float weight, String fitType, String closureType, String dimensions, String countryOrigin) {
        super(id, name, brand, color, manufacturerDate, material, department, size, sizeCountry, washingType, weight, fitType, closureType, dimensions, countryOrigin);
        this.waist = waist;
        this.frontRise = frontRise;
        this.backRise = backRise;
        this.upperThigh = upperThigh;
        this.inseam = inseam;
        this.legOpening = legOpening;
        this.pocketNumber = pocketNumber;
    }

    public float getWaist() {
        return waist;
    }

    public void setWaist(float waist) {
        this.waist = waist;
    }

    public float getFrontRise() {
        return frontRise;
    }

    public void setFrontRise(float frontRise) {
        this.frontRise = frontRise;
    }

    public float getBackRise() {
        return backRise;
    }

    public void setBackRise(float backRise) {
        this.backRise = backRise;
    }

    public float getUpperThigh() {
        return upperThigh;
    }

    public void setUpperThigh(float upperThigh) {
        this.upperThigh = upperThigh;
    }

    public float getInseam() {
        return inseam;
    }

    public void setInseam(float inseam) {
        this.inseam = inseam;
    }

    public float getLegOpening() {
        return legOpening;
    }

    public void setLegOpening(float legOpening) {
        this.legOpening = legOpening;
    }

    public int getPocketNumber() {
        return pocketNumber;
    }

    public void setPocketNumber(int pocketNumber) {
        this.pocketNumber = pocketNumber;
    }
    
    
}
