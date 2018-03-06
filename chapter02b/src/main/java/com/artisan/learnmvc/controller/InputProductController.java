package com.artisan.learnmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InputProductController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("find page");
		return "/WEB-INF/jsp/ProductForm.jsp";
	}

}
