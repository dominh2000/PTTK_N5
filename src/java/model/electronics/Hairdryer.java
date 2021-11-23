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
public class Hairdryer extends Electronics implements Serializable{
    private String hairType;
    private float wattage;
    private String material;
    private int voltage;
    private int speedSettings;
    private int heatSettings;

    public Hairdryer() {
    }
    
    public Hairdryer(String hairType, float wattage, String material, int voltage, int speedSettings, int heatSettings, int id, String name, String manufacturer, Date manufactureDate, float weight, String color, int warranty, String dimensions, String countryOrigin) {
        super(id, name, manufacturer, manufactureDate, weight, color, warranty, dimensions, countryOrigin);
        this.hairType = hairType;
        this.wattage = wattage;
        this.material = material;
        this.voltage = voltage;
        this.speedSettings = speedSettings;
        this.heatSettings = heatSettings;
    }

    public String getHairType() {
        return hairType;
    }

    public void setHairType(String hairType) {
        this.hairType = hairType;
    }

    public float getWattage() {
        return wattage;
    }

    public void setWattage(float wattage) {
        this.wattage = wattage;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    public int getSpeedSettings() {
        return speedSettings;
    }

    public void setSpeedSettings(int speedSettings) {
        this.speedSettings = speedSettings;
    }

    public int getHeatSettings() {
        return heatSettings;
    }

    public void setHeatSettings(int heatSettings) {
        this.heatSettings = heatSettings;
    }
    
    
}
