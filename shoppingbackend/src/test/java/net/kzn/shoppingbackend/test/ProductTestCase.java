package net.kzn.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Product;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();		
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	
	@Test
	public void testAddProduct(){
		product = new Product();
		
		product.setName("Opp selfie S53");
		product.setBrand("Opp");
		product.setDescription("this is some description of Opp mobile");
		product.setUnitPrice(new BigDecimal(399.50));	
		product.setQuantity(20);
		product.setActive(true);
		product.setCategoryId(4);
		product.setSupplierId(4);
		
		
		assertEquals("Successfully added a product inside the table",true,productDAO.add(product));
		
	}
	
	@Test
	public void testGetproduct(){
		product = productDAO.get(16);
			
		assertEquals("Successfully fetched a single product from the table","PRD3685EE93-1E10-4F8",product.getCode());
		
		System.out.println(product.toString());
	}
	
	@Test
	public void testUpdateproduct(){
		product = productDAO.get(16);
		
		product.setCategoryId(6);
			
		assertEquals("Successfully updated a single product in the table",true,productDAO.update(product));
		
	}
	
	
	@Test
	public void testDeleteproduct(){
		product = productDAO.get(9);

			
		assertEquals("Successfully deleted a single product in the table",true,productDAO.delete(product));
		
	}
	
	@Test
	public void testListProduct(){
		assertEquals("Successfully fetched the list categories from the table",4,productDAO.list().size());
		
	}
	
	@Test
	public void testListActiveProduct(){
		assertEquals("Successfully fetched the list categories from the table",1,productDAO.listActiveProducts().size());
		
	}
	
	@Test
	public void testListActiveProductByCategory(){
		assertEquals("Successfully fetched the list categories from the table",1,productDAO.listProductsByCategory(6).size());
		
	}
	
	@Test
	public void testListLastestActiveProduct(){
		assertEquals("Successfully fetched the list categories from the table",3,productDAO.getLatestActiveProducts(3).size());
		
	}
	
	

}
