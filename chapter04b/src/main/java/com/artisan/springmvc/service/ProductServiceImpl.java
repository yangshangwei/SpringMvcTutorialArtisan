package com.artisan.springmvc.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.artisan.springmvc.domain.Product;
/**
 * 
 * @author Mr.Yang
 * 标注了@Service的服务层
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	private Map<Long, Product> products = new HashMap<Long, Product>();
	// 使用AtomicLong能让long的操作在多线程下保持原子型
	private AtomicLong generator = new AtomicLong();

	public ProductServiceImpl() {
		Product product = new Product();
		add(product);
	}

	@Override
	public Product add(Product product) {
		long newId = generator.incrementAndGet();
		product.setId(newId);
		products.put(newId, product);
		return product;
	}

	@Override
	public Product get(long id) {
		return products.get(id);
	}
}
