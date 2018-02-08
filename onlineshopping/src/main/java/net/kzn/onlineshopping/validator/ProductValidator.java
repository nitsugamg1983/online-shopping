package net.kzn.onlineshopping.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import net.kzn.shoppingbackend.dto.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Product.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Product product = (Product)target;
		//when file is been selected
		if(product.getFile() == null || product.getFile().getOriginalFilename().equals("")){
			errors.rejectValue("file", null, "Please select an imgage file to upload!");
			return;
		}
		
		if(!(product.getFile().getContentType().equals("imgage/jpeg") || 
				product.getFile().getContentType().equals("imgage/png") ||
				product.getFile().getContentType().equals("imgage/gif"))){
			errors.rejectValue("file", null, "Please use only image file for upload");
			return;
		}
		
		

	}

}
