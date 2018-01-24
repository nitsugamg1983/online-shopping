package net.kzn.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	
	private static List<Product> products = new ArrayList<Product>();
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product get(Integer id) {
		return sessionFactory.getCurrentSession().get(Product.class, id);
	}

	@Override
	public List<Product> list() {
		return sessionFactory
				.getCurrentSession()
				.createQuery("FROM Product", Product.class)
				.getResultList();
	}

	@Override
	public boolean add(Product product) {
		try{
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Product product) {
		try{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Product product) {
		try{
			product.setActive(false);
			sessionFactory.getCurrentSession().update(product);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> listActiveProducts() {
		// TODO Auto-generated method stub
		String selectProductActive = "From Product where active=:active";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectProductActive, Product.class)
						.setParameter("active", true)
							.getResultList();
	}

	@Override
	public List<Product> listProductsByCategory(Integer categoryId) {
		String selectProductActiveByCategory = "From Product where active=:active and categoryId=:categoryId";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectProductActiveByCategory, Product.class)
						.setParameter("active", true)
							.setParameter("categoryId", categoryId)
								.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(Integer count) {
		String selectProductActiveLastest = "From Product where active=:active order by id";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectProductActiveLastest, Product.class)
						.setParameter("active", true)
							.setFirstResult(0)
								.setMaxResults(count)
									.getResultList();
	}

}
