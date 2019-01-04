package com.ecomm.DAO;

import java.util.List;

import com.ecomm.Model.Customer;
import com.ecomm.Model.CartItem;
import com.ecomm.Model.CustomerOrder;
import com.ecomm.Model.User;

public interface CartItemDAO {
	void addToCart(CartItem cartItem);
	User getUser(String email);
	List<CartItem>  getCart(String email);//select * from cartitem where user_email=?
	void removeCartItem(int cartItemId);
	CustomerOrder createCustomerOrder(CustomerOrder customerOrder);	
}
