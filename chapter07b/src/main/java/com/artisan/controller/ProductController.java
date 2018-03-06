package com.artisan.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.artisan.domain.Product;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
	
	private static final Logger logger = Logger.getLogger(ProductController.class);
	
	@RequestMapping(value = "/product_input", method = RequestMethod.GET)
	public String productInput(Model model) {
		model.addAttribute("product", new Product());
		return "ProductForm";
	}
	
	/**
	 * 
	* @Title: productSave  
	* @Description: 标注了@Valid 对product进行校验
	* @param @param product
	* @param @param bindingResult
	* @param @param model
	* @param @return    参数  
	* @return String    返回类型  
	* @throws
	 */
	@RequestMapping(value = "/product_save", method = RequestMethod.POST)
	public String productSave(@Valid @ModelAttribute Product product, 
			BindingResult bindingResult, Model model) {
		// 校验
		if (bindingResult.hasErrors()) {
			FieldError fieldError = bindingResult.getFieldError();
			logger.info("Code:" + fieldError.getCode() + " ,field:" + fieldError.getField());
			return "ProductForm";
		}
		
		// simulate save product here

        model.addAttribute("product", product);
        model.addAttribute("message", "add successfully");
        return "ProductView";
	}

}
