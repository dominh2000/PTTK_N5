/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicApplication.clothesDAO;

import java.util.List;
import model.clothes.Clothes;
import model.clothes.Coat;
import model.clothes.Jeans;
import model.clothes.Shorts;
import model.clothes.TShirt;

/**
 *
 * @author pc
 */
public interface ClothesDAO {
    List<Clothes> getByName(String name);
    boolean addTShirt(Clothes clothes, TShirt tShirt);
    boolean addCoat(Clothes clothes, Coat coat);
    boolean addJeans(Clothes clothes, Jeans jeans);
    boolean addShorts(Clothes clothes, Shorts shorts);
    boolean modifyTShirt(Clothes clothes, TShirt tShirt);
    boolean modifyCoat(Clothes clothes, Coat coat);
    boolean modifyJeans(Clothes clothes, Jeans jeans);
    boolean modifyShorts(Clothes clothes, Shorts shorts);
    boolean deleteClothes(Clothes clothes);
}
