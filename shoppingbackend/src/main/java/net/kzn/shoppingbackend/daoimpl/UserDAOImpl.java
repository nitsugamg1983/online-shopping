package net.kzn.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.UserDAO;
import net.kzn.shoppingbackend.dto.Address;
import net.kzn.shoppingbackend.dto.Cart;
import net.kzn.shoppingbackend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public boolean addUser(User user) {
		try{
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}	
		
		return false;
	}

	@Override
	@Transactional
	public boolean addAddress(Address address) {
		try{
			sessionFactory.getCurrentSession().persist(address);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}	
		return false;
	}

	@Override
	@Transactional
	public boolean updateCart(Cart cart) {
		try{
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}	
		return false;
	}

	@Override
	@Transactional
	public User getByEmail(String email) {
		String selectQuery = "FROM User WHERE email=:email";
		
		try{		
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery, User.class)
					.setParameter("email", email)
					.getSingleResult();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Address getBillingAddress(User user) {
		String selectQuery = "FROM Address where user=:user AND isBilling=:isBilling";
		try{
			return sessionFactory
					.getCurrentSession()
					.createQuery(selectQuery, Address.class)
					.setParameter("user", user)
					.setParameter("isBilling", true)
					.getSingleResult();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Address> getListShippingAddress(User user) {
		String selectQuery = "FROM Address where user=:user AND isShipping=:isShipping";
		try{
			return sessionFactory
					.getCurrentSession()
					.createQuery(selectQuery, Address.class)
					.setParameter("user", user)
					.setParameter("isShipping", true)
					.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
