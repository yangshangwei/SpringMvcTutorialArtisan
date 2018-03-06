package com.artisan.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.artisan.springmvc.form.ProductForm;
import com.artisan.springmvc.model.Product;
/**
 * 
 * @author Mr.Yang
 * @Desc 实现Spring自身的Controller
 *
 */
public class SaveProductController implements Controller{
	
	
	 private static final Logger logger = Logger.getLogger(SaveProductController.class);
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 logger.info("SaveProductController called");
	        ProductForm productForm = new ProductForm();
	        // populate action properties
	        productForm.setName(request.getParameter("name"));
	        productForm.setDescription(request.getParameter("description"));
	        productForm.setPrice(request.getParameter("price"));

	        // create model
	        Product product = new Product();
	        product.setName(productForm.getName());
	        product.setDescription(productForm.getDescription());
	        try {
	            product.setPrice(Float.parseFloat(productForm.getPrice()));
	        } catch (NumberFormatException e) {
	        }

	        // insert code to save Product

	        return new ModelAndView("/WEB-INF/jsp/ProductDetails.jsp", "product",
	                product);
		
	}

}
