/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicApplication.electronicsDAO;

import java.util.List;
import model.electronics.Electronics;
import model.electronics.Hairdryer;
import model.electronics.Laptop;
import model.electronics.MobilePhone;
import model.electronics.PC;

/**
 *
 * @author pc
 */
public interface ElectronicsDAO {
    Object getByID(int id);
    List<Object> getByName(String name);
    boolean addHairdryer(Electronics elec, Hairdryer hairdryer);
    boolean addMobilePhone(Electronics elec, MobilePhone mobile);
    boolean addLaptop(Electronics elec, Laptop laptop);
    boolean addPC(Electronics elec, PC pc);
    boolean modifyHairdryer(Electronics elec, Hairdryer hairdryer);
    boolean modifyMobilePhone(Electronics elec, MobilePhone mobile);
    boolean modifyLaptop(Electronics elec, Laptop laptop);
    boolean modifyPC(Electronics elec, PC pc);
    boolean deleteElec(Electronics elec);
}
