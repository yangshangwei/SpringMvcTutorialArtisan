package com.artisan.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.artisan.domain.Product;
import com.artisan.validator.ProductValidator;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	 private static final Logger logger = Logger.getLogger(ProductController.class);
	
	 @RequestMapping(value = "/product_input")
	    public String inputProduct(Model model) {
	        model.addAttribute("product", new Product());
	        return "ProductForm";
	    }

	    @RequestMapping(value = "/product_save")
	    public String saveProduct(@ModelAttribute Product product,
	            BindingResult bindingResult, Model model) {
	    	
	        logger.info("product_save");
	        
	        // –£—ÈProduct
	        ProductValidator productValidator = new ProductValidator();
	        productValidator.validate(product, bindingResult);
	        
	        if (bindingResult.hasErrors()) {
	            FieldError fieldError = bindingResult.getFieldError();
	            logger.info("Code:" + fieldError.getCode() + ", field:" + fieldError.getField());

	            return "ProductForm";
	        }

	        // save product here

	        model.addAttribute("product", product);
	        return "ProductDetails";
	    } 
	
	
}
