package com.artisan.springmvc.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.artisan.springmvc.domain.Product;
/**
 * 
 * @author Mr.Yang
 * ��ע��@Service�ķ����
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	private Map<Long, Product> products = new HashMap<Long, Product>();
	// ʹ��AtomicLong����long�Ĳ����ڶ��߳��±���ԭ����
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
