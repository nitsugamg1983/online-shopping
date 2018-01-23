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

}