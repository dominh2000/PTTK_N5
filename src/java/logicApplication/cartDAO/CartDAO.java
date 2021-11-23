/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicApplication.cartDAO;

import java.util.List;
import model.cart.Cart;
import model.itemBook.ItemBook;
import model.itemClothes.ItemClothes;
import model.itemElectronics.ItemElectronics;
import model.itemShoes.ItemShoes;
import model.order.Order;
import model.order.Payment;

/**
 *
 * @author pc
 */
public interface CartDAO {
    Cart createCart(Order order);
    Cart getCartById(int id);
    List<Payment> getListPaymentsOfCart(int cartID);
    boolean addItemBookToCart(ItemBook itemBook, Cart cart);
    boolean addItemElecToCart(ItemElectronics itemElec, Cart cart);
    boolean addItemShoesToCart(ItemShoes itemShoes, Cart cart);
    boolean addItemClothesToCart(ItemClothes itemClothes, Cart cart);
    boolean removeItemBookFromCart(ItemBook itemBook, Cart cart);
    boolean removeItemElecFromCart(ItemElectronics itemElec, Cart cart);
    boolean removeItemClothesFromCart(ItemClothes itemClothes, Cart cart);
    boolean removeItemShoesFromCart(ItemShoes itemShoes, Cart cart);
    List<ItemBook> getItemBookOfCart(Cart cart);
    List<ItemElectronics> getItemElecOfCart(Cart cart);
    List<ItemShoes> getItemShoesOfCart(Cart cart);
    List<ItemClothes> getItemClothesOfCart(Cart cart);
}
