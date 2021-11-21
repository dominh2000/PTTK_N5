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
public class RunningShoes extends Shoes implements Serializable{
    private int nightReflect;
    private String durability;
    private int shockAbsorb;
    private int ventilation;
    private int ankleSupport;

    public RunningShoes() {
    }

    public RunningShoes(int nightReflect, String durability, int shockAbsorb, int ventilation, int ankleSupport, int id, String name, float size, String sizeCountry, String brand, String color, float weight, Date manufactureDate, String countryOrigin, String department, String upperMaterial, String soleMaterial, String liningMaterial, String dimensions) {
        super(id, name, size, sizeCountry, brand, color, weight, manufactureDate, countryOrigin, department, upperMaterial, soleMaterial, liningMaterial, dimensions);
        this.nightReflect = nightReflect;
        this.durability = durability;
        this.shockAbsorb = shockAbsorb;
        this.ventilation = ventilation;
        this.ankleSupport = ankleSupport;
    }

    public int getNightReflect() {
        return nightReflect;
    }

    public void setNightReflect(int nightReflect) {
        this.nightReflect = nightReflect;
    }

    public String getDurability() {
        return durability;
    }

    public void setDurability(String durability) {
        this.durability = durability;
    }

    public int getShockAbsorb() {
        return shockAbsorb;
    }

    public void setShockAbsorb(int shockAbsorb) {
        this.shockAbsorb = shockAbsorb;
    }

    public int getVentilation() {
        return ventilation;
    }

    public void setVentilation(int ventilation) {
        this.ventilation = ventilation;
    }

    public int getAnkleSupport() {
        return ankleSupport;
    }

    public void setAnkleSupport(int ankleSupport) {
        this.ankleSupport = ankleSupport;
    }
    
    
}
