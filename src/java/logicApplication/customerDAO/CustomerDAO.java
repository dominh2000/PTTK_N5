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

/**
 *
 * @author pc
 */
public interface CustomerDAO {
    boolean addCust(Customer cus, Account acc, FullName name, Address addr);
    boolean updateCust(Customer cus, Account acc, FullName name, Address addr);
    List<Customer> getAllCustomer();
    boolean checkLogin(Account account);
}
