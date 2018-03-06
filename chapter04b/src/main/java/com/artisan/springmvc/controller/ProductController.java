package com.artisan.springmvc.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.artisan.springmvc.domain.Product;
import com.artisan.springmvc.form.ProductForm;
import com.artisan.springmvc.service.ProductService;

@Controller
public class ProductController {

	private static final Logger logger = Logger.getLogger(ProductController.class);

	private ProductService productService;

	
	public ProductService getProductService() {
		return productService;
	}
	
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(value = "/product_input")
	public String inputProduct() {
		logger.info("inputProduct called ....");
		return "ProductForm";
	}

	@RequestMapping(value = "/product_save", method = RequestMethod.POST)
	public String saveProduct(ProductForm productForm, RedirectAttributes attributes) {
		logger.info("saveProduct called ....");
		// no need to create and instantiate a ProductForm
		// create Product
		Product product = new Product();
		product.setName(productForm.getName());
		product.setDescription(productForm.getDescription());
		try {
			product.setPrice(Float.parseFloat(productForm.getPrice()));
		} catch (NumberFormatException e) {
		}

		// add product
		Product savedProduct = productService.add(product);

		attributes.addFlashAttribute("message", "The product has been saved successfully");
		return "redirect:/product_view/" + savedProduct.getId();
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 * @PathVariable用来获得请求url中的动态参数
	 */
	@RequestMapping(value = "/product_view/{id}")
	public String viewProduct(@PathVariable Long id, Model model) {
		logger.info("getProductById called ....");
		Product product = productService.get(id);
		model.addAttribute("product", product);
		return "ProductView";
	}

}
