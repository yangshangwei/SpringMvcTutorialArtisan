package com.artisan.springmvc.service;

import com.artisan.springmvc.domain.Product;

public interface ProductService {
	Product add(Product product);
	Product get(long id);
}
