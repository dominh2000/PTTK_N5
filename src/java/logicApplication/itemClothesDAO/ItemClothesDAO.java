/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicApplication.itemClothesDAO;

import java.util.List;
import model.clothes.Clothes;
import model.itemClothes.ItemClothes;

/**
 *
 * @author pc
 */
public interface ItemClothesDAO {
    ItemClothes getItemClothesByCode(String code);
    List<ItemClothes> searchByName(String name);
    Object getClothes(Clothes clothes);
    ItemClothes addItemClothes(Clothes clothes, ItemClothes itemClothes);
    boolean deleteItemClothes(ItemClothes itemClothes);
    ItemClothes modifyItemClothes(ItemClothes itemClothes);
}
