package com.artisan.springmvc.service;

import java.util.List;


import com.artisan.springmvc.domian.Artisan;
import com.artisan.springmvc.domian.Org;

public interface ArtisanService {
	// 获取所有的Artisan
	List<Artisan> getArtisans();
	
	// 获取所有的Org
	List<Org> getAllOrgs();
	
	// 增加Artisan
	Artisan addArtisan(Artisan artisan);
	
	// 根据orgId 获取 Org
	Org getOrg(int orgId);
	
	// 更新Artisan
	Artisan updateArtisan(Artisan artisan);
	
	// 根据id获取Artisan
	Artisan getArtisanById(long id);
	
}
