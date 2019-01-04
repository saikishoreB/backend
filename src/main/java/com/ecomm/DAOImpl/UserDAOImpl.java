package com.ecomm.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.DAO.UserDAO;
import com.ecomm.Model.User;
@Repository("userDAO")
@Transactional

public class UserDAOImpl implements UserDAO{
	@Autowired
	SessionFactory sessionFactory;

	public List<User> findAllUsers() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();

	}

	public User findUserById(int id) {
		return (User)sessionFactory.getCurrentSession().createQuery("from User where id="+id).uniqueResult();
		}

	public User findUserByName(String name) {
		return (User)sessionFactory.getCurrentSession().createQuery("from User where name='"+name+"'").uniqueResult();
		
	}

	public boolean addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
		return true;
	}

	public boolean updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
		return true;
		}

	public boolean deleteUser(int id) {
		sessionFactory.getCurrentSession().delete(findUserById(id));	
		return true;
	}

}
