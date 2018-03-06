package com.artisan.validator;

import java.util.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.artisan.domain.Product;

/**
 * 
 * @ClassName: ProductValidator
 * @Description: ʵ��Validator�ӿ�,��Product����У��
 * @author Mr.Yang
 * @date 2018��2��26��
 *
 */

public class ProductValidator implements Validator {
	

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		// ǿ��ת��У�����
		Product product = (Product) target;
		
		// У������ֶ�
		ValidationUtils.rejectIfEmpty(errors, "name", "productname.required");
		ValidationUtils.rejectIfEmpty(errors, "price", "price.required");
		ValidationUtils.rejectIfEmpty(errors, "productionDate", "productiondate.required");
		
		// У��price
		Float price = product.getPrice();
		if (price != null && price < 0) {
			errors.rejectValue("price", "price.negative");
		}
		// У��productionDate
		Date productionDate = product.getProductionDate();
		if (productionDate != null) {
			// The hour,minute,second components of productionDate are 0
			if (productionDate.after(new Date())) {
				errors.rejectValue("productionDate", "productiondate.invalid");
			}
		}

	}

}
