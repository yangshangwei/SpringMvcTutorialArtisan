package com.artisan.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
/**
 * 
 * @author Mr.Yang
 * @Desc 实现Spring自身的Controller
 *
 */
public class InputProductController implements Controller{
	
	private static final Logger logger = Logger.getLogger(InputProductController.class);

	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("InputProductController called");
        return new ModelAndView("/WEB-INF/jsp/ProductForm.jsp");
	}

}
