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
* @Description: 使用@Controller注解的ArtisanController
* @author Mr.Yang  
* @date 2018年1月30日  
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
	* @Description: 通过 @Autowired注入ArtisanService
	* @param @param artisanService    参数  
	* @return void    返回类型  
	* @throws
	 */
	@Autowired
	public void setArtisanService(ArtisanService artisanService) {
		this.artisanService = artisanService;
	}

	
	/**
	 * 
	* @Title: getAllArtisans  
	* @Description: 获取全部模拟的artisanList  
	* @param @param model
	* @param @return    参数  
	* @return String    返回类型  
	* @throws
	 */
	@RequestMapping(value="/artisan_list",method=RequestMethod.GET)
	public String getAllArtisans(Model model){
		logger.info("getAllArtisans called....");
		
		List<Artisan> artisanList = artisanService.getArtisans();
		// 添加到Model中，以便前台能访问到
		model.addAttribute("artisanList", artisanList);
		
		return "ArtisanList";
	}
	
	/**
	 * 
	* @Title: inputArtisan  
	* @Description: 进入inputArtisan的页面 
	* @param @return    参数  
	* @return String    返回类型  
	* @throws
	 */
	@RequestMapping(value="/artisan_input")
	public String inputArtisan(Model model){
		// 获取全部的org
		List<Org> orgs = artisanService.getAllOrgs();
		// 加载org到Model中以便前台展示
		model.addAttribute("orgs", orgs);
		// 前台form  commandName为artisan，因此必须保证model中存在一个artisan
		model.addAttribute("artisan",new Artisan());
		return "AddArtisan";
		
	}
	
	
	@RequestMapping(value="/artisan_add",method=RequestMethod.POST)
	public String addArtisan(@ModelAttribute Artisan artisan){
		logger.info("addArtisan called...");
		
		// 获取页面的数据
		logger.info("orgId:" + artisan.getOrg().getOrgId());
		logger.info("Name:" + artisan.getName());
		logger.info("Code:" + artisan.getCode());
		logger.info("Sex:" + artisan.getSex());
		
		//根据前台传入绑定的orgId,获取Org
		Org org = artisanService.getOrg(artisan.getOrg().getOrgId());
		// 设置org
		artisan.setOrg(org);
		// 保存artisan
		artisanService.addArtisan(artisan);

		// 跳转到list页面
		return "redirect:/artisan/artisan_list";
	}
	
	
	
	/**
	 * 
	* @Title: editArtisan  
	* @Description: 跳转到编辑Artisan页面  
	* @param @param model
	* @param @param id
	* @param @return    参数  
	* @return String    返回类型  
	* @throws
	 */
	@RequestMapping(value="/artisan_edit/{id}")
	public String editArtisan(Model model,@PathVariable long  id){
		logger.info("Artisan ID：" + id);
		// 加载Org全部数据 用于选择
		List<Org> orgList = artisanService.getAllOrgs();
		// 添加到model，以便前台访问
		model.addAttribute("orgList", orgList);
		
		// 根据传入的id,获取对应的artisan信息 用于编辑页面展示Artisan信息
		Artisan artisan = artisanService.getArtisanById(id);
		// 添加到model，以便前台访问
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
		
		// 根据orgId获取org
		Org org = artisanService.getOrg(artisan.getOrg().getOrgId());
		logger.info("Org Name :" + org.getOrgName());
		artisan.setOrg(org);
		// 更新数据
		artisanService.updateArtisan(artisan);
		 
		return "redirect:/artisan/artisan_list";
	}
	
	
	@RequestMapping(value="/artisan_delete/{id}")
	public String deleteArtisan(Model model ,@PathVariable long id){
		logger.info("deleteArtisan called ,id：" + id);
		// 更新数据
		// artisanService.deleteArtisanById(id);
		return "redirect:/artisan/artisan_list";
	}
	
}
