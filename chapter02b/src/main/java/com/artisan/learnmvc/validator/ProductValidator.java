package com.artisan.learnmvc.validator;

import java.util.ArrayList;
import java.util.List;

import com.artisan.learnmvc.form.ProductForm;

public class ProductValidator {
	
	
	public List<String> validate(ProductForm form){
			
		List<String> errors = new ArrayList<String>();
		
		String name = form.getName();
		if(name == null || name.trim().isEmpty()){
			System.out.println("name must input");
			errors.add("Product must have a name");
		}
		
		String price = form.getPrice();
		if (price == null || price.trim().isEmpty()) {
			System.out.println("price must input");
			errors.add("Product must have a price");
		}else {
			try {
				Float.parseFloat(price);
			} catch (NumberFormatException e) {
				System.out.println("price must be right format");
				errors.add("Invalid price");
				e.printStackTrace();
			}
		}
		
		return errors;
	}
	
	
	
}
