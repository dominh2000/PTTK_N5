/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.itemClothes;

import java.io.Serializable;

/**
 *
 * @author pc
 */
public class ItemClothes implements Serializable{
    private String barcode;
    private int employeeId;
    private int feedbackId;
    private int cartId;
    private int clothesId;
    private float price;
    private String discount;
    private String promoText;
    private String description;
    private String image;

    public ItemClothes() {
    }

    public ItemClothes(String barcode, int employeeId, int feedbackId, int cartId, int clothesId, float price, String discount, String promoText, String description, String image) {
        this.barcode = barcode;
        this.employeeId = employeeId;
        this.feedbackId = feedbackId;
        this.cartId = cartId;
        this.clothesId = clothesId;
        this.price = price;
        this.discount = discount;
        this.promoText = promoText;
        this.description = description;
        this.image = image;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getClothesId() {
        return clothesId;
    }

    public void setClothesId(int clothesId) {
        this.clothesId = clothesId;
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
    
    
}
