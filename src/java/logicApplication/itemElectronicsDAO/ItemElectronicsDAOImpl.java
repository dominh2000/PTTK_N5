/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicApplication.itemElectronicsDAO;

import connectionPool.ConnectionPool;
import connectionPool.DBUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logicApplication.electronicsDAO.ElectronicsDAOImpl;
import model.electronics.Electronics;
import model.electronics.Hairdryer;
import model.electronics.Laptop;
import model.electronics.MobilePhone;
import model.electronics.PC;
import model.itemElectronics.ItemElectronics;

/**
 *
 * @author pc
 */
public class ItemElectronicsDAOImpl implements ItemElectronicsDAO{

    @Override
    public ItemElectronics getItemElecByCode(String code) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        String query = "SELECT * FROM itemelectronics WHERE Barcode = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, code);
            rs = ps.executeQuery();

            ItemElectronics itemElectronics = null;
            if (rs.next()) {
                int feedbackId = rs.getInt("FeedbackID");
                int cartId = rs.getInt("CartID");
                int elecId = rs.getInt("ElectronicsID");
                float price = rs.getFloat("Price");
                String discount = rs.getString("Discount");
                String promoText = rs.getString("PromoText");
                String description = rs.getString("Description");
                String image = rs.getString("Description");
                
                Object elec = getElectronics(elecId);
                if (elec instanceof Hairdryer) {
                    Hairdryer hairdryer = (Hairdryer) elec;
                    itemElectronics = new ItemElectronics(code, price, discount, promoText, description, image, hairdryer);
                } else if (elec instanceof Laptop) {
                    Laptop laptop = (Laptop) elec;
                    itemElectronics = new ItemElectronics(code, price, discount, promoText, description, image, laptop);
                } else if (elec instanceof MobilePhone) {
                    MobilePhone mobilePhone = (MobilePhone) elec;
                    itemElectronics = new ItemElectronics(code, price, discount, promoText, description, image, mobilePhone);
                } else if (elec instanceof PC) {
                    PC pc = (PC) elec;
                    itemElectronics = new ItemElectronics(code, price, discount, promoText, description, image, pc);
                }
            }
            return itemElectronics;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    @Override
    public List<ItemElectronics> searchByName(String name) {
        List<Object> listElectronics = getElecByName(name);

        if (listElectronics == null) {
            return null;
        } else {
            List<ItemElectronics> listItemElectronics = new ArrayList<>();
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();

            String query = "SELECT * FROM itemelectronics WHERE ElectronicsID = ?";
            PreparedStatement ps = null;
            ResultSet rs = null;

            try {
                ps = connection.prepareStatement(query);
                for (Object elec : listElectronics) {
                    if (elec instanceof Hairdryer) {
                        Hairdryer hairdryer = (Hairdryer) elec;
                        ps.setInt(1, hairdryer.getId());
                    } else if (elec instanceof Laptop) {
                        Laptop laptop = (Laptop) elec;
                        ps.setInt(1, laptop.getId());
                    } else if (elec instanceof MobilePhone) {
                        MobilePhone mobilePhone = (MobilePhone) elec;
                        ps.setInt(1, mobilePhone.getId());
                    } else if (elec instanceof PC) {
                        PC pc = (PC) elec;
                        ps.setInt(1, pc.getId());
                    }
                    rs = ps.executeQuery();

                    while (rs.next()) {
                        String barcode = rs.getString("Barcode");
                        int feedbackId = rs.getInt("FeedbackID");
                        int cartId = rs.getInt("CartID");
                        float price = rs.getFloat("Price");
                        String discount = rs.getString("Discount");
                        String promoText = rs.getString("PromoText");
                        String description = rs.getString("Description");
                        String image = rs.getString("Image");
                        
                        if (elec instanceof Hairdryer) {
                            Hairdryer hairdryer = (Hairdryer) elec;
                            listItemElectronics.add(new ItemElectronics(barcode, price, discount, promoText, description, image, hairdryer));
                        } else if (elec instanceof Laptop) {
                            Laptop laptop = (Laptop) elec;
                            listItemElectronics.add(new ItemElectronics(barcode, price, discount, promoText, description, image, laptop));
                        } else if (elec instanceof MobilePhone) {
                            MobilePhone mobilePhone = (MobilePhone) elec;
                            listItemElectronics.add(new ItemElectronics(barcode, price, discount, promoText, description, image, mobilePhone));
                        } else if (elec instanceof PC) {
                            PC pc = (PC) elec;
                            listItemElectronics.add(new  ItemElectronics(barcode, price, discount, promoText, description, image, pc));
                        }
                    }
                }

                return listItemElectronics;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return null;
            } finally {
                DBUtil.closeResultSet(rs);
                DBUtil.closePreparedStatement(ps);
                pool.freeConnection(connection);
            }
        }
    }

    @Override
    public Object getElectronics(int ID) {
        ElectronicsDAOImpl electronicsDAOImpl = new ElectronicsDAOImpl();
        return electronicsDAOImpl.getByID(ID);
    } 
    
    @Override
    public List<Object> getElecByName(String name) {
        ElectronicsDAOImpl electronicsDAOImpl = new ElectronicsDAOImpl();
        return electronicsDAOImpl.getByName(name);
    }
    
    @Override
    public ItemElectronics addItemElectronics(Electronics elec, ItemElectronics itemElec) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteItemElec(ItemElectronics itemElec) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ItemElectronics modifyItemElec(ItemElectronics itemElec) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
