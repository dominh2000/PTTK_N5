/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicApplication.itemElectronicsDAO;

import java.util.List;
import model.electronics.Electronics;
import model.itemElectronics.ItemElectronics;

/**
 *
 * @author pc
 */
public interface ItemElectronicsDAO {
    ItemElectronics getItemElecByCode(String code);
    List<ItemElectronics> searchByName(String name);
    Object getElectronics(int ID);
    List<Object> getElecByName(String name);
    ItemElectronics addItemElectronics(Electronics elec, ItemElectronics itemElec);
    boolean deleteItemElec(ItemElectronics itemElec);
    ItemElectronics modifyItemElec(ItemElectronics itemElec);
}
