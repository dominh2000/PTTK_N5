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
public class Sneaker extends Shoes implements Serializable{
    private int nightReflect;
    private float heelHeight;

    public Sneaker() {
    }

    public Sneaker(int nightReflect, float heelHeight, int id, String name, float size, String sizeCountry, String brand, String color, float weight, Date manufactureDate, String countryOrigin, String department, String upperMaterial, String soleMaterial, String liningMaterial, String dimensions) {
        super(id, name, size, sizeCountry, brand, color, weight, manufactureDate, countryOrigin, department, upperMaterial, soleMaterial, liningMaterial, dimensions);
        this.nightReflect = nightReflect;
        this.heelHeight = heelHeight;
    }

    public int getNightReflect() {
        return nightReflect;
    }

    public void setNightReflect(int nightReflect) {
        this.nightReflect = nightReflect;
    }

    public float getHeelHeight() {
        return heelHeight;
    }

    public void setHeelHeight(float heelHeight) {
        this.heelHeight = heelHeight;
    }
    
    
}
