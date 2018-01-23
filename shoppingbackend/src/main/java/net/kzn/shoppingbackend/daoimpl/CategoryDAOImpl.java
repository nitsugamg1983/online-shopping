package net.kzn.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	private static List<Category> categories = new ArrayList<Category>();
	@Autowired
	private SessionFactory sessionFactory;
	
	
//	static {
//		Category category = new Category();
//		category.setActive(true);
//		category.setDescription("This is some description for television");
//		category.setId(1);
//		category.setImageURL("CAT_1.png");
//		category.setName("Television");
//		categories.add(category);
//		
//		category = new Category();
//		category.setActive(true);
//		category.setDescription("This is some description for mobile");
//		category.setId(2);
//		category.setImageURL("CAT_2.png");
//		category.setName("Mobile");
//		categories.add(category);
//		
//		category = new Category();
//		category.setActive(true);
//		category.setDescription("This is some description for laptop");
//		category.setId(3);
//		category.setImageURL("CAT_3.png");
//		category.setName("Laptop");
//		categories.add(category);
//		
//		
//	}

	@Override
	public List<Category> list() {
		String selectActiveCategories = "FROM Category WHERE active=:active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategories);
		query.setParameter("active", true);
		return query.getResultList();
	}
	
	@Override
	public Category get(int id){		
//		for(Category category:categories){
//			if(category.getId()==id){
//				return category;
//			}
//		}
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	@Transactional
	public boolean add(Category category) {
		try{
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Category category) {
		try{
			category.setActive(false);
			sessionFactory.getCurrentSession().update(category);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Category category) {
		try{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
