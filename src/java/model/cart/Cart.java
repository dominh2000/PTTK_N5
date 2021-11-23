/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.cart;

import java.io.Serializable;
import java.util.List;
import model.itemBook.ItemBook;
import model.itemClothes.ItemClothes;
import model.itemElectronics.ItemElectronics;
import model.itemShoes.ItemShoes;
import model.order.Cash;
import model.order.Credit;
import model.order.Payment;

/**
 *
 * @author pc
 */
public class Cart implements Serializable{
    private int id;
    private int amount;
    private float price;
    private List<ItemBook> itemBooks;
    private List<ItemElectronics> itemElectronics;
    private List<ItemClothes> itemClothes;
    private List<ItemShoes> itemShoes;
    private List<Cash> cashes;
    private List<Credit> credits;

    public Cart() {
    }

    public Cart(int id, int amount, float price) {
        this.id = id;
        this.amount = amount;
        this.price = price;
    }
    
    public Cart(int id, int amount, float price, List<ItemBook> itemBooks, List<ItemElectronics> itemElectronics, List<ItemClothes> itemClothes, List<ItemShoes> itemShoes, List<Cash> cashes, List<Credit> credits) {
        this.id = id;
        this.amount = amount;
        this.price = price;
        this.itemBooks = itemBooks;
        this.itemElectronics = itemElectronics;
        this.itemClothes = itemClothes;
        this.itemShoes = itemShoes;
        this.cashes = cashes;
        this.credits = credits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<ItemBook> getItemBooks() {
        return itemBooks;
    }

    public void setItemBooks(List<ItemBook> itemBooks) {
        this.itemBooks = itemBooks;
    }

    public List<ItemElectronics> getItemElectronics() {
        return itemElectronics;
    }

    public void setItemElectronics(List<ItemElectronics> itemElectronics) {
        this.itemElectronics = itemElectronics;
    }

    public List<ItemClothes> getItemClothes() {
        return itemClothes;
    }

    public void setItemClothes(List<ItemClothes> itemClothes) {
        this.itemClothes = itemClothes;
    }

    public List<ItemShoes> getItemShoes() {
        return itemShoes;
    }

    public void setItemShoes(List<ItemShoes> itemShoes) {
        this.itemShoes = itemShoes;
    }

    public List<Cash> getCashes() {
        return cashes;
    }

    public void setCashes(List<Cash> cashes) {
        this.cashes = cashes;
    }

    public List<Credit> getCredits() {
        return credits;
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }
    
    
}
