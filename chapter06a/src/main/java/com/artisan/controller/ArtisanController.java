package com.artisan.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.artisan.domain.Artisan;


/**
 * 
* @ClassName: ArtisanController  
* @Description: @Controller��ע��Artisan���Ʋ�
* @author Mr.Yang  
* @date 2018��2��10��  
*
 */
@Controller
public class ArtisanController {
    
	private Logger logger = Logger.getLogger(ArtisanController.class);
	
	 @RequestMapping(value="/artisan_input")
	    public String inputArtisan(Model model) {
	        model.addAttribute(new Artisan());
	        return "ArtisanForm";
	    }

	    @RequestMapping(value="/artisan_save")
	    public String saveArtisan(@ModelAttribute Artisan artisan, BindingResult bindingResult,
	            Model model) {
	    	// ������������ת��ArtisanFormҳ��
	        if (bindingResult.hasErrors()) {
	            FieldError fieldError = bindingResult.getFieldError();
	            logger.info("Code:" + fieldError.getCode() 
	                    + ", field:" + fieldError.getField());
	            return "ArtisanForm";
	        }
	        
	        // save Artisan here
	        
	        model.addAttribute("artisan", artisan);
	        return "ArtisanDetails";
	    }
}
