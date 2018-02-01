package net.kzn.onlineshopping.exception;

import java.io.Serializable;

import org.springframework.web.bind.annotation.ControllerAdvice;

public class ProductNotFoundException extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3924721261587169989L;
	private String message;
	public ProductNotFoundException(){
		this("Product is not available!");
	}
	
	public ProductNotFoundException(String message){
		this.message = System.currentTimeMillis()+": "+message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
