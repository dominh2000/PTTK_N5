/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.itemClothes;

import java.io.Serializable;
import model.clothes.Clothes;
import model.clothes.Coat;
import model.clothes.Jeans;
import model.clothes.Shorts;
import model.clothes.TShirt;
import model.feedback.Feedback;

/**
 *
 * @author pc
 */
public class ItemClothes implements Serializable{
    private String barcode;
    private float price;
    private String discount;
    private String promoText;
    private String description;
    private String image;
    private TShirt tShirt;
    private Coat coat;
    private Jeans jeans;
    private Shorts shorts;
    private Feedback feedback;

    public ItemClothes() {
    }

    public ItemClothes(String barcode, float price, String discount, String promoText, String description, String image, TShirt tShirt) {
        this.barcode = barcode;
        this.price = price;
        this.discount = discount;
        this.promoText = promoText;
        this.description = description;
        this.image = image;
        this.tShirt = tShirt;
    }

    public ItemClothes(String barcode, float price, String discount, String promoText, String description, String image, Coat coat) {
        this.barcode = barcode;
        this.price = price;
        this.discount = discount;
        this.promoText = promoText;
        this.description = description;
        this.image = image;
        this.coat = coat;
    }

    public ItemClothes(String barcode, float price, String discount, String promoText, String description, String image, Jeans jeans) {
        this.barcode = barcode;
        this.price = price;
        this.discount = discount;
        this.promoText = promoText;
        this.description = description;
        this.image = image;
        this.jeans = jeans;
    }

    public ItemClothes(String barcode, float price, String discount, String promoText, String description, String image, Shorts shorts) {
        this.barcode = barcode;
        this.price = price;
        this.discount = discount;
        this.promoText = promoText;
        this.description = description;
        this.image = image;
        this.shorts = shorts;
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

    public TShirt gettShirt() {
        return tShirt;
    }

    public void settShirt(TShirt tShirt) {
        this.tShirt = tShirt;
    }

    public Coat getCoat() {
        return coat;
    }

    public void setCoat(Coat coat) {
        this.coat = coat;
    }

    public Jeans getJeans() {
        return jeans;
    }

    public void setJeans(Jeans jeans) {
        this.jeans = jeans;
    }

    public Shorts getShorts() {
        return shorts;
    }

    public void setShorts(Shorts shorts) {
        this.shorts = shorts;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    
}
