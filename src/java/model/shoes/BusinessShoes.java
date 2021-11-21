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
public class BusinessShoes extends Shoes implements Serializable{
    private float heelHeight;
    private float heelMeasure;

    public BusinessShoes() {
    }

    public BusinessShoes(float heelHeight, float heelMeasure, int id, String name, float size, String sizeCountry, String brand, String color, float weight, Date manufactureDate, String countryOrigin, String department, String upperMaterial, String soleMaterial, String liningMaterial, String dimensions) {
        super(id, name, size, sizeCountry, brand, color, weight, manufactureDate, countryOrigin, department, upperMaterial, soleMaterial, liningMaterial, dimensions);
        this.heelHeight = heelHeight;
        this.heelMeasure = heelMeasure;
    }

    public float getHeelHeight() {
        return heelHeight;
    }

    public void setHeelHeight(float heelHeight) {
        this.heelHeight = heelHeight;
    }

    public float getHeelMeasure() {
        return heelMeasure;
    }

    public void setHeelMeasure(float heelMeasure) {
        this.heelMeasure = heelMeasure;
    }
    
    
}
