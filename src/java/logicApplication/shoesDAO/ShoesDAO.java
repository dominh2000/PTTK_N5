/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicApplication.shoesDAO;

import java.util.List;
import model.shoes.Boot;
import model.shoes.BusinessShoes;
import model.shoes.RunningShoes;
import model.shoes.Shoes;
import model.shoes.Sneaker;

/**
 *
 * @author pc
 */
public interface ShoesDAO {
    List<Shoes> getByName(String name);
    boolean addSneaker(Shoes shoes, Sneaker sneaker);
    boolean addBusinessShoes(Shoes shoes, BusinessShoes businessShoes);
    boolean addRunShoes(Shoes shoes, RunningShoes runShoes);
    boolean addBoot(Shoes shoes, Boot boot);
    boolean modifySneaker(Shoes shoes, Sneaker sneaker);
    boolean modifyBusinessShoes(Shoes shoes, BusinessShoes businessShoes);
    boolean modifyRunShoes(Shoes shoes, RunningShoes runShoes);
    boolean modifyBoot(Shoes shoes, Boot boot);
    boolean deleteShoes(Shoes shoes);
}
