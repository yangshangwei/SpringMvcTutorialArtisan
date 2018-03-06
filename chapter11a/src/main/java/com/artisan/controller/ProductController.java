package com.artisan.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.artisan.domain.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
		
	private static final Logger logger = Logger.getLogger(ProductController.class);
	
	@RequestMapping(value="/product_input",method=RequestMethod.GET)
	public String inputProduct(Model model){
		model.addAttribute("product",new Product());
		return "ProductForm";
	}
	
	
	@RequestMapping(value="/product_save",method=RequestMethod.POST)
	public String saveProduct(HttpServletRequest servletRequest,@ModelAttribute Product product,
			BindingResult bindingResult, Model model) {

		List<MultipartFile> files = product.getImages();
		List<String> fileNames = new ArrayList<String>();

		if (null != files && files.size() > 0) {
			for (MultipartFile multipartFile : files) {

				String fileName = multipartFile.getOriginalFilename();
				logger.info("fileName:" + fileName);
				fileNames.add(fileName);

				// 上传后的文件保存目录及名字
				File imageFile = new File("D:/", fileName);
				try {
					// 转存文件
					multipartFile.transferTo(imageFile);
					logger.info("save image successfully");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		// save product here
		model.addAttribute("product", product);
		return "ProductDetails";
	}
	
}
