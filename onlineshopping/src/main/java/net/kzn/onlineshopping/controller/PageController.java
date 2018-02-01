package net.kzn.onlineshopping.controller;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.onlineshopping.exception.ProductNotFoundException;
import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Category;
import net.kzn.shoppingbackend.dto.Product;

@Controller
public class PageController {
	
	
	
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
//	@RequestMapping(value={"/","/home","/index"})
//	public ModelAndView index(){
//		System.out.println("entre por acá");
//		ModelAndView mv = new ModelAndView( "page");
//		mv.addObject("gretting", "Hello world spring mvc");
//		return mv;
//	}
	
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index(){
		System.out.println("entre por acá");
		ModelAndView mv = new ModelAndView( "page2");
		
		logger.info("Inside PAgeController index method INFO");
		logger.debug("Inside PAgeController index method DEBUG");
		
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping(value="/about")
	public ModelAndView about(){
		ModelAndView mv = new ModelAndView( "page2");
		mv.addObject("title", "About us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value="/contact")
	public ModelAndView contact(){
		ModelAndView mv = new ModelAndView( "page2");
		mv.addObject("title", "Contact us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	@RequestMapping(value="/test")
	public ModelAndView test(@RequestParam(value="greeting", required=false) String greeting){
		
		if(greeting==null){
			greeting="hola default";
		}
		
		ModelAndView mv = new ModelAndView( "page");
		mv.addObject("gretting", greeting);
		return mv;
	}
	
	
	@RequestMapping(value="/test2/{greeting}")
	public ModelAndView test2(@PathVariable("greeting") String greeting){
		
		if(greeting==null){
			greeting="hola default";
		}
		
		ModelAndView mv = new ModelAndView( "page");
		mv.addObject("gretting", greeting);
		return mv;
	}
	
	
	@RequestMapping(value={"/show/all/products"})
	public ModelAndView showAllProducts(){
		ModelAndView mv = new ModelAndView( "page2");
		
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("title", "All Products");
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	@RequestMapping(value={"/show/category/{id}/products"})
	public ModelAndView showCategoryProducts(@PathVariable("id") int id){
		ModelAndView mv = new ModelAndView( "page2");
		
		//category to fetch a single category
		Category category = null;
		category = categoryDAO.get(id);		
		
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		//passing a single object
		mv.addObject("category", category);
		
		mv.addObject("title", category.getName());
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
	
	@RequestMapping(value={"/show/{id}/product"})
	public ModelAndView showSingleProduct(@PathVariable("id") int id) throws ProductNotFoundException{
		ModelAndView mv = new ModelAndView( "page2");
		
		System.out.println("id "+id);
		
		Product product = productDAO.get(id);
		
		if(product==null)
			throw new ProductNotFoundException();
		
		product.setViews(product.getViews() + 1);
		
		productDAO.update(product);
		
		
		//passing a single object
		mv.addObject("product", product);
		mv.addObject("title", product.getName());
		mv.addObject("userClickShowProduct", true);
		return mv;
	}
}
