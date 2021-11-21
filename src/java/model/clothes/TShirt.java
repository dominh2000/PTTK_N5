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
public class TShirt extends Clothes implements Serializable{
    private int tagFree;
    private int layFlat;
    private float sleeveHem;
    private int moistureWicking;
    private int tapedNeck;
    private float bottomHem;

    public TShirt() {
    }

    public TShirt(int tagFree, int layFlat, float sleeveHem, int moistureWicking, int tapedNeck, float bottomHem, int id, String name, String brand, String color, Date manufacturerDate, String material, String department, String size, String sizeCountry, String washingType, float weight, String fitType, String closureType, String dimensions, String countryOrigin) {
        super(id, name, brand, color, manufacturerDate, material, department, size, sizeCountry, washingType, weight, fitType, closureType, dimensions, countryOrigin);
        this.tagFree = tagFree;
        this.layFlat = layFlat;
        this.sleeveHem = sleeveHem;
        this.moistureWicking = moistureWicking;
        this.tapedNeck = tapedNeck;
        this.bottomHem = bottomHem;
    }

    public int getTagFree() {
        return tagFree;
    }

    public void setTagFree(int tagFree) {
        this.tagFree = tagFree;
    }

    public int getLayFlat() {
        return layFlat;
    }

    public void setLayFlat(int layFlat) {
        this.layFlat = layFlat;
    }

    public float getSleeveHem() {
        return sleeveHem;
    }

    public void setSleeveHem(float sleeveHem) {
        this.sleeveHem = sleeveHem;
    }

    public int getMoistureWicking() {
        return moistureWicking;
    }

    public void setMoistureWicking(int moistureWicking) {
        this.moistureWicking = moistureWicking;
    }

    public int getTapedNeck() {
        return tapedNeck;
    }

    public void setTapedNeck(int tapedNeck) {
        this.tapedNeck = tapedNeck;
    }

    public float getBottomHem() {
        return bottomHem;
    }

    public void setBottomHem(float bottomHem) {
        this.bottomHem = bottomHem;
    }
    
    
}
