package com.artisan.springmvc.service;

import java.util.List;


import com.artisan.springmvc.domian.Artisan;
import com.artisan.springmvc.domian.Org;

public interface ArtisanService {
	// ��ȡ���е�Artisan
	List<Artisan> getArtisans();
	
	// ��ȡ���е�Org
	List<Org> getAllOrgs();
	
	// ����Artisan
	Artisan addArtisan(Artisan artisan);
	
	// ����orgId ��ȡ Org
	Org getOrg(int orgId);
	
	// ����Artisan
	Artisan updateArtisan(Artisan artisan);
	
	// ����id��ȡArtisan
	Artisan getArtisanById(long id);
	
}
