package com.artisan.learnmvc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artisan.learnmvc.controller.InputProductController;
import com.artisan.learnmvc.controller.SaveProductController;

public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = -5454977373262337215L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		/*
		 * uri is in this form: /contextName/resourceName, for example:
		 * /chapter02b/product_input.action However, in the event of a default
		 * context, the context name is empty, and uri has this form
		 * /resourceName, e.g.: /product_input
		 */
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		System.out.println("action:" +  action);	
		
		String dispatchUrl = null;
		// execute an action
		if (action.equals("product_input.action")) {
			InputProductController inputProductController = new InputProductController();
			dispatchUrl = inputProductController.handleRequest(request, response);
		} else if (action.equals("product_save.action")) {
			SaveProductController saveProductController = new SaveProductController();
            dispatchUrl = saveProductController.handleRequest(request, response);
		}
		System.out.println("dispatchUrl:" + dispatchUrl);
		// Ò³ÃæÌø×ª
		 if (dispatchUrl != null) {
	            RequestDispatcher rd =
	                    request.getRequestDispatcher(dispatchUrl);
	            rd.forward(request, response);
	        }

	}
}
