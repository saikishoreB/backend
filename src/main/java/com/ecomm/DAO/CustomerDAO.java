package com.ecomm.DAO;

import com.ecomm.Model.Customer;

public interface CustomerDAO {
	void registerCustomer(Customer customer);
	boolean isEmailUnique(String email);
}
