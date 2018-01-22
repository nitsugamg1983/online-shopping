package net.kzn.onlineshopping.controller;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
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
}
