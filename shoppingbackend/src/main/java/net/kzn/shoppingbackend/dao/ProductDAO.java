package net.kzn.shoppingbackend.dao;

import java.util.List;

import net.kzn.shoppingbackend.dto.Product;

public interface ProductDAO {
	
	Product get(Integer id);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	

	//business methods
	List<Product> listActiveProducts();
	List<Product> listProductsByCategory(Integer categoryId);
	List<Product> getLatestActiveProducts(Integer count);
	
}
