/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.itemShoes;

import model.feedback.Feedback;
import model.shoes.Boot;
import model.shoes.BusinessShoes;
import model.shoes.RunningShoes;
import model.shoes.Shoes;
import model.shoes.Sneaker;

/**
 *
 * @author pc
 */
public class ItemShoes {
    private String barcode;
    private float price;
    private String discount;
    private String promoText;
    private String description;
    private String image;
    private Sneaker sneaker;
    private RunningShoes runningShoes;
    private BusinessShoes businessShoes;
    private Boot boot;
    private Feedback feedback;

    public ItemShoes() {
    }

    public ItemShoes(String barcode, float price, String discount, String promoText, String description, String image, Sneaker sneaker) {
        this.barcode = barcode;
        this.price = price;
        this.discount = discount;
        this.promoText = promoText;
        this.description = description;
        this.image = image;
        this.sneaker = sneaker;
    }

    public ItemShoes(String barcode, float price, String discount, String promoText, String description, String image, RunningShoes runningShoes) {
        this.barcode = barcode;
        this.price = price;
        this.discount = discount;
        this.promoText = promoText;
        this.description = description;
        this.image = image;
        this.runningShoes = runningShoes;
    }

    public ItemShoes(String barcode, float price, String discount, String promoText, String description, String image, BusinessShoes businessShoes) {
        this.barcode = barcode;
        this.price = price;
        this.discount = discount;
        this.promoText = promoText;
        this.description = description;
        this.image = image;
        this.businessShoes = businessShoes;
    }

    public ItemShoes(String barcode, float price, String discount, String promoText, String description, String image, Boot boot) {
        this.barcode = barcode;
        this.price = price;
        this.discount = discount;
        this.promoText = promoText;
        this.description = description;
        this.image = image;
        this.boot = boot;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getPromoText() {
        return promoText;
    }

    public void setPromoText(String promoText) {
        this.promoText = promoText;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Sneaker getSneaker() {
        return sneaker;
    }

    public void setSneaker(Sneaker sneaker) {
        this.sneaker = sneaker;
    }

    public RunningShoes getRunningShoes() {
        return runningShoes;
    }

    public void setRunningShoes(RunningShoes runningShoes) {
        this.runningShoes = runningShoes;
    }

    public BusinessShoes getBusinessShoes() {
        return businessShoes;
    }

    public void setBusinessShoes(BusinessShoes businessShoes) {
        this.businessShoes = businessShoes;
    }

    public Boot getBoot() {
        return boot;
    }

    public void setBoot(Boot boot) {
        this.boot = boot;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }
    
    
}
