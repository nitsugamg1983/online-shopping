package net.kzn.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.UserDAO;
import net.kzn.shoppingbackend.dto.Address;
import net.kzn.shoppingbackend.dto.Cart;
import net.kzn.shoppingbackend.dto.User;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static UserDAO userDAO;
	
	private Cart cart;
	private Address address;
	private User user;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();		
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
//	@Test
//	public void addTest(){
//		
//		user = new User();
//		user.setRole("USER");
//		user.setPassword("123456");
//		user.setContactNumber("1132346565");
//		user.setFirstName("Agustin");
//		user.setLastName("Morales");
//		user.setEmail("nistugamg@hotmail.com");
//			
//		assertEquals("Failed to add user!",true, userDAO.addUser(user));
//		
//		
//		 address = new Address();
//		  address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
//		  address.setAddressLineTwo("Near Kaabil Store");
//		  address.setCity("Mumbai");
//		  address.setState("Maharashtra");
//		  address.setCountry("India");
//		  address.setPostalCode("400001");
//		  address.setBilling(true);
//		  
//		  address.setUserId(user.getId());
//		  
//		  assertEquals("Failed to add user address!",true, userDAO.addAddress(address));
//		  
//		  
//		  address = new Address();
//			address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
//			address.setAddressLineTwo("Near Kudrat Store");
//			address.setCity("Mumbai");
//			address.setState("Maharashtra");
//			address.setCountry("India");
//			address.setPostalCode("400001");
//			address.setUserId(user.getId());
//			assertEquals("Failed to add the shipping address!", true, userDAO.addAddress(address));
//		  
//		  
//		  cart = new Cart();
//		  cart.setUser(user);
//		  
//		  
//		  
//		
//		  assertEquals("Failed to add user address!",true, userDAO.addCart(cart));
//	}
	
//	@Test
//	public void addTestOneToOneBidireccional(){
//		
//		user = new User();
//		user.setRole("USER");
//		user.setPassword("123456");
//		user.setContactNumber("1132346565");
//		user.setFirstName("Agustin");
//		user.setLastName("Morales");
//		user.setEmail("nistugamg@hotmail.com");
//			
//		cart = new Cart();
//		cart.setUser(user);
//		
//		user.setCart(cart);
//		  
//		assertEquals("Failed to add user!",true, userDAO.addUser(user));  
//		  
//	}
	
	
//	@Test
//	public void testUpdateCart(){
//		
//		user = userDAO.getByEmail("nistugamg@hotmail.com");
//		
//		cart = user.getCart();
//		
//		cart.setCartLines(2);
//		cart.setGrandTotal(new BigDecimal("799"));		
//		  
//		assertEquals("Failed to update cart!",true, userDAO.updateCart(cart));  
//		  
//	}
	
	
//	@Test
//	public void testAddAddress(){
//		
//		user = new User();
//		user.setRole("USER");
//		user.setPassword("123456");
//		user.setContactNumber("1132346565");
//		user.setFirstName("Agustin");
//		user.setLastName("Morales");
//		user.setEmail("nistugamg@hotmail.com");
//		
//		assertEquals("Failed to add user!",true, userDAO.addUser(user));
//		
//		
//		 address = new Address();
//		  address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
//		  address.setAddressLineTwo("Near Kaabil Store");
//		  address.setCity("Mumbai");
//		  address.setState("Maharashtra");
//		  address.setCountry("India");
//		  address.setPostalCode("400001");
//		  address.setBilling(true);
//		  
//		  
//		  address.setUser(user);
//		  
//		  assertEquals("Failed to add billing address!",true, userDAO.addAddress(address));
//		  
//		  
//		  address = new Address();
//			address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
//			address.setAddressLineTwo("Near Kudrat Store");
//			address.setCity("Mumbai");
//			address.setState("Maharashtra");
//			address.setCountry("India");
//			address.setPostalCode("400001");
//			address.setShipping(true);
//			address.setUser(user);
//			
//			assertEquals("Failed to add the shipping address!", true, userDAO.addAddress(address));
//			
//			
//		
//		
//	}
	
	
//	@Test
//	public void testAddAddress(){
//		
//		
//		user = userDAO.getByEmail("nistugamg@hotmail.com");
//		
//				
//		
//		 address = new Address();
//		  address.setAddressLineOne("2343/B Jadoo Society, Krissh Nagar");
//		  address.setAddressLineTwo("Near Kaabil Store");
//		  address.setCity("Ecatepec");
//		  address.setState("Ecatepec");
//		  address.setCountry("India");
//		  address.setPostalCode("400001");
//		  address.setShipping(true);
//		  
//		  
//		  address.setUser(user);
//		  
//		  assertEquals("Failed to add billing address!",true, userDAO.addAddress(address));
//		  
//		  
//		  address = new Address();
//			address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
//			address.setAddressLineTwo("Near Kudrat Store");
//			address.setCity("Zumpango");
//			address.setState("Zumpango");
//			address.setCountry("India");
//			address.setPostalCode("400001");
//			address.setShipping(true);
//			address.setUser(user);
//			
//			assertEquals("Failed to add the shipping address!", true, userDAO.addAddress(address));
//			
//			
//		
//		
//	}
	
	@Test
	public void testGetAddresses(){
		user = userDAO.getByEmail("nistugamg@hotmail.com");
		
		assertEquals("failed to fecth the list of addresses and and size does not match", 4, user.getAddresses().size());
		
		assertEquals("failed to fecth the list of addresses and and size does not match", 3, userDAO.getListShippingAddress(user).size());
		
		assertEquals("failed to fecth the billing address and and size does not match", "Mumbai", userDAO.getBillingAddress(user).getCity());
	}

}
