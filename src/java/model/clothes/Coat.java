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
public class Coat extends Clothes implements Serializable{
    private int waterResistant;
    private int moistureWicking;
    private int pocketNumber;

    public Coat() {
    }

    public Coat(int waterResistant, int moistureWicking, int pocketNumber, int id, String name, String brand, String color, Date manufacturerDate, String material, String department, String size, String sizeCountry, String washingType, float weight, String fitType, String closureType, String dimensions, String countryOrigin) {
        super(id, name, brand, color, manufacturerDate, material, department, size, sizeCountry, washingType, weight, fitType, closureType, dimensions, countryOrigin);
        this.waterResistant = waterResistant;
        this.moistureWicking = moistureWicking;
        this.pocketNumber = pocketNumber;
    }

    public int getWaterResistant() {
        return waterResistant;
    }

    public void setWaterResistant(int waterResistant) {
        this.waterResistant = waterResistant;
    }

    public int getMoistureWicking() {
        return moistureWicking;
    }

    public void setMoistureWicking(int moistureWicking) {
        this.moistureWicking = moistureWicking;
    }

    public int getPocketNumber() {
        return pocketNumber;
    }

    public void setPocketNumber(int pocketNumber) {
        this.pocketNumber = pocketNumber;
    }
    
    
}
