package com.artisan.validator;

import java.util.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.artisan.domain.Product;

/**
 * 
 * @ClassName: ProductValidator
 * @Description: 实现Validator接口,对Product进行校验
 * @author Mr.Yang
 * @date 2018年2月26日
 *
 */

public class ProductValidator implements Validator {
	

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		// 强制转成校验对象
		Product product = (Product) target;
		
		// 校验必填字段
		ValidationUtils.rejectIfEmpty(errors, "name", "productname.required");
		ValidationUtils.rejectIfEmpty(errors, "price", "price.required");
		ValidationUtils.rejectIfEmpty(errors, "productionDate", "productiondate.required");
		
		// 校验price
		Float price = product.getPrice();
		if (price != null && price < 0) {
			errors.rejectValue("price", "price.negative");
		}
		// 校验productionDate
		Date productionDate = product.getProductionDate();
		if (productionDate != null) {
			// The hour,minute,second components of productionDate are 0
			if (productionDate.after(new Date())) {
				errors.rejectValue("productionDate", "productiondate.invalid");
			}
		}

	}

}
