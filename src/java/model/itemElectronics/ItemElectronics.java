/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.itemElectronics;

import model.electronics.Electronics;
import model.electronics.Hairdryer;
import model.electronics.Laptop;
import model.electronics.MobilePhone;
import model.electronics.PC;
import model.feedback.Feedback;

/**
 *
 * @author pc
 */
public class ItemElectronics {
    private String barcode;
    private float price;
    private String discount;
    private String promoText;
    private String description;
    private String image;
    private Hairdryer hairdryer;
    private Laptop laptop;
    private MobilePhone mobilePhone;
    private PC pc;
    private Feedback feedback;

    public ItemElectronics() {
    }

    public ItemElectronics(String barcode, float price, String discount, String promoText, String description, String image, Hairdryer hairdryer) {
        this.barcode = barcode;
        this.price = price;
        this.discount = discount;
        this.promoText = promoText;
        this.description = description;
        this.image = image;
        this.hairdryer = hairdryer;
    }

    public ItemElectronics(String barcode, float price, String discount, String promoText, String description, String image, Laptop laptop) {
        this.barcode = barcode;
        this.price = price;
        this.discount = discount;
        this.promoText = promoText;
        this.description = description;
        this.image = image;
        this.laptop = laptop;
    }

    public ItemElectronics(String barcode, float price, String discount, String promoText, String description, String image, MobilePhone mobilePhone) {
        this.barcode = barcode;
        this.price = price;
        this.discount = discount;
        this.promoText = promoText;
        this.description = description;
        this.image = image;
        this.mobilePhone = mobilePhone;
    }

    public ItemElectronics(String barcode, float price, String discount, String promoText, String description, String image, PC pc) {
        this.barcode = barcode;
        this.price = price;
        this.discount = discount;
        this.promoText = promoText;
        this.description = description;
        this.image = image;
        this.pc = pc;
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

    public Hairdryer getHairdryer() {
        return hairdryer;
    }

    public void setHairdryer(Hairdryer hairdryer) {
        this.hairdryer = hairdryer;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public MobilePhone getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(MobilePhone mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public PC getPc() {
        return pc;
    }

    public void setPc(PC pc) {
        this.pc = pc;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }
    
}
