package com.artisan.springmvc.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.artisan.springmvc.domian.Artisan;
import com.artisan.springmvc.domian.Org;
import com.artisan.springmvc.service.ArtisanService;

/**
 * 
* @ClassName: ArtisanController  
* @Description: ʹ��@Controllerע���ArtisanController
* @author Mr.Yang  
* @date 2018��1��30��  
*
 */

@Controller
@RequestMapping("/artisan")
public class ArtisanController {
	
	private static final Logger logger  = Logger.getLogger(ArtisanController.class);
	
	private ArtisanService artisanService;
	
	public ArtisanService getArtisanService() {
		return artisanService;
	}
	
	/**
	 * 
	* @Title: setArtisanService  
	* @Description: ͨ�� @Autowiredע��ArtisanService
	* @param @param artisanService    ����  
	* @return void    ��������  
	* @throws
	 */
	@Autowired
	public void setArtisanService(ArtisanService artisanService) {
		this.artisanService = artisanService;
	}

	
	/**
	 * 
	* @Title: getAllArtisans  
	* @Description: ��ȡȫ��ģ���artisanList  
	* @param @param model
	* @param @return    ����  
	* @return String    ��������  
	* @throws
	 */
	@RequestMapping(value="/artisan_list",method=RequestMethod.GET)
	public String getAllArtisans(Model model){
		logger.info("getAllArtisans called....");
		
		List<Artisan> artisanList = artisanService.getArtisans();
		// ��ӵ�Model�У��Ա�ǰ̨�ܷ��ʵ�
		model.addAttribute("artisanList", artisanList);
		
		return "ArtisanList";
	}
	
	/**
	 * 
	* @Title: inputArtisan  
	* @Description: ����inputArtisan��ҳ�� 
	* @param @return    ����  
	* @return String    ��������  
	* @throws
	 */
	@RequestMapping(value="/artisan_input")
	public String inputArtisan(Model model){
		// ��ȡȫ����org
		List<Org> orgs = artisanService.getAllOrgs();
		// ����org��Model���Ա�ǰ̨չʾ
		model.addAttribute("orgs", orgs);
		// ǰ̨form  commandNameΪartisan����˱��뱣֤model�д���һ��artisan
		model.addAttribute("artisan",new Artisan());
		return "AddArtisan";
		
	}
	
	
	@RequestMapping(value="/artisan_add",method=RequestMethod.POST)
	public String addArtisan(@ModelAttribute Artisan artisan){
		logger.info("addArtisan called...");
		
		// ��ȡҳ�������
		logger.info("orgId:" + artisan.getOrg().getOrgId());
		logger.info("Name:" + artisan.getName());
		logger.info("Code:" + artisan.getCode());
		logger.info("Sex:" + artisan.getSex());
		
		//����ǰ̨����󶨵�orgId,��ȡOrg
		Org org = artisanService.getOrg(artisan.getOrg().getOrgId());
		// ����org
		artisan.setOrg(org);
		// ����artisan
		artisanService.addArtisan(artisan);

		// ��ת��listҳ��
		return "redirect:/artisan/artisan_list";
	}
	
	
	
	/**
	 * 
	* @Title: editArtisan  
	* @Description: ��ת���༭Artisanҳ��  
	* @param @param model
	* @param @param id
	* @param @return    ����  
	* @return String    ��������  
	* @throws
	 */
	@RequestMapping(value="/artisan_edit/{id}")
	public String editArtisan(Model model,@PathVariable long  id){
		logger.info("Artisan ID��" + id);
		// ����Orgȫ������ ����ѡ��
		List<Org> orgList = artisanService.getAllOrgs();
		// ��ӵ�model���Ա�ǰ̨����
		model.addAttribute("orgList", orgList);
		
		// ���ݴ����id,��ȡ��Ӧ��artisan��Ϣ ���ڱ༭ҳ��չʾArtisan��Ϣ
		Artisan artisan = artisanService.getArtisanById(id);
		// ��ӵ�model���Ա�ǰ̨����
		model.addAttribute("artisan", artisan);
		
		return "EditArtisan";
	}
	
	
	@RequestMapping(value="/artisan_update",method=RequestMethod.POST)
	public String artisanUpdate(@ModelAttribute Artisan artisan){
		logger.info("artisanUpdate called");
		
		logger.info("artisan orgId:" + artisan.getOrg().getOrgId());
		logger.info("artisan Id:" + artisan.getId());
		logger.info("artisan Name:" + artisan.getName());
		logger.info("artisan Sex:" + artisan.getSex());
		logger.info("artisan Code:" + artisan.getCode());
		
		// ����orgId��ȡorg
		Org org = artisanService.getOrg(artisan.getOrg().getOrgId());
		logger.info("Org Name :" + org.getOrgName());
		artisan.setOrg(org);
		// ��������
		artisanService.updateArtisan(artisan);
		 
		return "redirect:/artisan/artisan_list";
	}
	
	
	@RequestMapping(value="/artisan_delete/{id}")
	public String deleteArtisan(Model model ,@PathVariable long id){
		logger.info("deleteArtisan called ,id��" + id);
		// ��������
		// artisanService.deleteArtisanById(id);
		return "redirect:/artisan/artisan_list";
	}
	
}
