package com.ecomm.DAO;

import java.util.List;

import com.ecomm.Model.User;

public interface UserDAO {
			public List<User> findAllUsers();
		public User findUserById(int id);
		public User findUserByName(String name);
		public boolean addUser(User user);
		public boolean updateUser(User user);
		public boolean deleteUser(int id);
	}


