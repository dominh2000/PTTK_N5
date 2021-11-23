/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.itemBook;

import java.io.Serializable;
import model.book.Book;
import model.feedback.Feedback;

/**
 *
 * @author pc
 */
public class ItemBook implements Serializable{
    private String barcode;
    private float price;
    private String discount;
    private String promoText;
    private String description;
    private String image;
    private Book book;
    private Feedback feedback;

    public ItemBook() {
    }

    public ItemBook(String barcode, float price, String discount, String promoText, String description, String image, Book book) {
        this.barcode = barcode;
        this.price = price;
        this.discount = discount;
        this.promoText = promoText;
        this.description = description;
        this.image = image;
        this.book = book;
    }
    
    public ItemBook(String barcode, float price, String discount, String promoText, String description, String image, Book book, Feedback feedback) {
        this.barcode = barcode;
        this.price = price;
        this.discount = discount;
        this.promoText = promoText;
        this.description = description;
        this.image = image;
        this.book = book;
        this.feedback = feedback;
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }
    
    
}
