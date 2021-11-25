/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicApplication.customerDAO;

import java.util.List;
import model.customer.Account;
import model.customer.Address;
import model.customer.Customer;
import model.customer.FullName;
import connectionPool.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class CustomerDAOImpl implements CustomerDAO{

    private String databaseName;
    private String tableName;
    @Override
    public boolean addCust(Customer cus, Account acc, FullName name, Address addr) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query_1 = "INSERT INTO account (id, employeeID, customerCodeCust, username, password) values (?,?,?,?,?)";
        String query_2 = "INSERT INTO fullname (id, employeeID, customerCodeCust, firstname, lastname, midname) values (?,?,?,?,?,?)";
        String query_3 = "INSERT INTO address (id, employeeID, customerCodeCust, nohouse, street, district ,city) values (?,?,?,?,?,?,?)";
        String query_4 = "INSERT INTO customer (customerCodeCust ,telephone,dateofbirth) values (?,?,?)";
        
        PreparedStatement ps = null;
        
        try {
            ps = connection.prepareStatement(query_1);
            ps.setInt(1, acc.getId());
            ps.setInt(2, acc.getEmployeeId());
            ps.setInt(3, acc.getCustomerId());
            ps.setString(4,acc.getUsername());
            ps.setString(5,acc.getPassword());
            ps.execute();
            
            ps = connection.prepareStatement(query_2);
            ps.setInt(1, name.getId());
            ps.setInt(2, name.getEmployeeId());
            ps.setInt(3, name.getCustomerId());
            ps.setString(4, name.getFirstName());
            ps.setString(5, name.getLastName());
            ps.setString(6, name.getMidName());            
            ps.execute();
            
            ps = connection.prepareStatement(query_3);
            ps.setInt(1, addr.getId());
            ps.setInt(2, addr.getEmployeeId());
            ps.setInt(3, addr.getCustomerId());
            ps.setInt(4, addr.getNoHouse());
            ps.setString(5, addr.getStreet());
            ps.setString(6, addr.getDistrict());
            ps.setString(7, addr.getCity());
            ps.execute();
            
            ps = connection.prepareStatement(query_4);
            ps.setInt(1, cus.getCustomerID());
            ps.setString(2, cus.getTelephone());
            ps.setDate(3, (Date) cus.getDateOfBirth());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    @Override
    public boolean updateCust(Customer cus, Account acc, FullName name, Address addr) {
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query_1 = "UPDATE account SET employeeID = ?, customerCodeCust = ?, username = ?, password = ? WHERE id = ?";
        String query_2 = "UPDATE fullname SET employeeID = ?, customerCodeCust = ?, firstname = ? ,lastname = ?, midname = ? WHERE id = ?";
        String query_3 = "UPDATE address SET employeeID = ?, customerCodeCust = ?, nohouse = ?, street = ?, district = ?, city = ? WHERE id = ?";
        String query_4 = "UPDATE customer SET telephone = ?, dateofbirth = ? WHERE customerCodeCust = ? ";
        
        PreparedStatement ps = null;
        
        try {
            // update account
            ps = connection.prepareStatement(query_1);          
            ps.setInt(1, acc.getEmployeeId());
            ps.setInt(2, acc.getCustomerId());
            ps.setString(3,acc.getUsername());
            ps.setString(4,acc.getPassword());
            ps.setInt(5, acc.getId());
            ps.execute();
            
            // update name
            ps = connection.prepareStatement(query_2);
            ps.setInt(1, name.getEmployeeId());
            ps.setInt(2, name.getCustomerId());
            ps.setString(3, name.getFirstName());
            ps.setString(4, name.getLastName());
            ps.setString(5, name.getMidName());    
            ps.setInt(1, name.getId());
            ps.execute();
            
            // update address
            ps = connection.prepareStatement(query_3);        
            ps.setInt(1, addr.getEmployeeId());
            ps.setInt(2, addr.getCustomerId());
            ps.setInt(3, addr.getNoHouse());
            ps.setString(4, addr.getStreet());
            ps.setString(5, addr.getDistrict());
            ps.setString(6, addr.getCity());
            ps.setInt(1, addr.getId());
            ps.execute();
            // addcustomer
            ps = connection.prepareStatement(query_4);        
            ps.setString(1, cus.getTelephone());
            ps.setDate(2, (Date) cus.getDateOfBirth());
            ps.setInt(3, cus.getCustomerID());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customers = null;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query_1 = "SELECT * FROM customer";       
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(query_1);
            rs = ps.executeQuery();          
            while(rs.next()){
                
                int customerID = rs.getInt("customerCodeCust");
                String telephone = rs.getString("telephone");
                Date dateofbirth = rs.getDate("dateofbirth");
                PreparedStatement ps_2 = null;
                ResultSet rs_2 = null;
                String query_Fullname = "SELECT * FROM name where name.customerCodeCust = ?";
                ps_2 = connection.prepareStatement(query_Fullname);
                ps_2.setInt(1, customerID);
                rs_2 = ps.executeQuery();
                FullName fullname = null;
                while(rs_2.next()){
                    int id_fullname = rs_2.getInt("id");
                    int employeeID = rs_2.getInt("employeeID");
                    int customerID_fullname = rs_2.getInt("customerCodeCust");
                    String firstName = rs_2.getString("firstname");
                    String lastName = rs_2.getString("lastName");
                    String midName = rs_2.getString("midName");
                    fullname = new FullName(id_fullname, employeeID, customerID, firstName, lastName, midName);
                }
                String query_Account = "SELECT * FROM account where account.customerCodeCust = ?";
                ps_2 = connection.prepareStatement(query_Account);
                ps_2.setInt(1, customerID);
                rs_2 = ps.executeQuery();
                Account account = null;
                while(rs_2.next()){
                    int id_acount = rs_2.getInt("id");
                    int employeeID = rs_2.getInt("employeeID");
                    int customerID_fullname = rs_2.getInt("customerCodeCust");
                    String username = rs_2.getString("username");
                    String password = rs_2.getString("password");
                    account = new Account(id_acount, employeeID, customerID, username, password);
                }
                String query_Address = "SELECT * FROM address where address.customerCodeCust = ?";
                ps_2 = connection.prepareStatement(query_Address);
                ps_2.setInt(1, customerID);
                rs_2 = ps.executeQuery();
                Address address = null;
                while(rs_2.next()){
                    int id_address = rs_2.getInt("id");
                    int employeeID = rs_2.getInt("employeeID");
                    int customerID_fullname = rs_2.getInt("customerCodeCust");
                    int noHouse = rs_2.getInt("nohouse");
                    String street = rs_2.getString("street");
                    String district = rs_2.getString("district");
                    String city = rs_2.getString("city");
                    address = new Address(id_address, employeeID, customerID, noHouse, street, district, city);
                }
                Customer customer = new Customer(customerID, dateofbirth, telephone, fullname, account, address);
                customers.add(customer);
            }
            
            return customers;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally{
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    @Override
    public boolean checkLogin(Account account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
