package net.kzn.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
	
	@Test
	public void testAddCategory(){
		category = new Category();
		
		category.setDescription("This is some description for Laptop");
		category.setImageURL("CAT_3.png");
		category.setName("Laptop");
		
		assertEquals("Successfully added a category inside the table",true,categoryDAO.add(category));
		
	}
	
	@Test
	public void testGetCategory(){
		category = categoryDAO.get(4);
			
		assertEquals("Successfully fetched a single category from the table","Television",category.getName());
		
	}
	
	@Test
	public void testUpdateCategory(){
		category = categoryDAO.get(4);
		
		category.setName("TV");
			
		assertEquals("Successfully updated a single category in the table",true,categoryDAO.update(category));
		
	}
	
	
	@Test
	public void testDeleteCategory(){
		category = categoryDAO.get(3);

			
		assertEquals("Successfully deleted a single category in the table",true,categoryDAO.delete(category));
		
	}
	
	@Test
	public void testListCategory(){
		assertEquals("Successfully fetched the list categories from the table",2,categoryDAO.list().size());
		
	}
	
	

}
