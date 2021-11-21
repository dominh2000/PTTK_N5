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
public class Boot extends Shoes implements Serializable{
    private String type;
    private float bootOpening;
    private float heelHeight;
    private float shaftMeasure;

    public Boot() {
    }

    public Boot(String type, float bootOpening, float heelHeight, float shaftMeasure, int id, String name, float size, String sizeCountry, String brand, String color, float weight, Date manufactureDate, String countryOrigin, String department, String upperMaterial, String soleMaterial, String liningMaterial, String dimensions) {
        super(id, name, size, sizeCountry, brand, color, weight, manufactureDate, countryOrigin, department, upperMaterial, soleMaterial, liningMaterial, dimensions);
        this.type = type;
        this.bootOpening = bootOpening;
        this.heelHeight = heelHeight;
        this.shaftMeasure = shaftMeasure;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getBootOpening() {
        return bootOpening;
    }

    public void setBootOpening(float bootOpening) {
        this.bootOpening = bootOpening;
    }

    public float getHeelHeight() {
        return heelHeight;
    }

    public void setHeelHeight(float heelHeight) {
        this.heelHeight = heelHeight;
    }

    public float getShaftMeasure() {
        return shaftMeasure;
    }

    public void setShaftMeasure(float shaftMeasure) {
        this.shaftMeasure = shaftMeasure;
    }
    
    
}
