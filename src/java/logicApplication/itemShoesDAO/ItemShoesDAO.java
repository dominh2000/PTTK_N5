/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicApplication.itemShoesDAO;

import java.util.List;
import model.itemShoes.ItemShoes;
import model.shoes.Shoes;

/**
 *
 * @author pc
 */
public interface ItemShoesDAO {
    ItemShoes getItemShoesByCode(String code);
    List<ItemShoes> searchByName(String name);
    Object getShoes(int ID);
    List<Object> getShoesByName(String name);
    ItemShoes addItemShoes(Shoes shoes, ItemShoes itemShoes);
    boolean deleteItemShoes(ItemShoes itemShoes);
    ItemShoes modifyItemShoes(ItemShoes itemShoes);
}
