package com.artisan.springmvc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.artisan.springmvc.domian.Artisan;
import com.artisan.springmvc.domian.Org;

/**
 * 
 * @ClassName: ArtisanServiceImpl
 * @Description: 通过@Service标注的服务层 ,
 * @author Mr.Yang
 * @date 2018年1月30日
 *
 */

@Service
public class ArtisanServiceImpl implements ArtisanService {
	
	public static final Logger logger = Logger.getLogger(ArtisanServiceImpl.class);
	/*
	 * this implementation is not thread-safe
	 */

	private List<Artisan> artisanList = null;
	private List<Org> orgList = null;
	private String sex = null;

	/**
	 * 
	 * 创建一个新的实例 ArtisanServiceImpl的同时初始化模拟数据
	 *
	 */
	public ArtisanServiceImpl() {
		super();
		// 初始化模式数据
		artisanList = new ArrayList<Artisan>();
		orgList = new ArrayList<Org>();

		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				sex = "男";
			} else {
				sex = "女";
			}
		artisanList.add(new Artisan(i, "Artisan" + i, "ATSCode" + i, sex, new Org(i, "org" + i)));
		orgList.add(new Org(i, "org" + i));
		
		}
		logger.info("初始化完成");
	}

	@Override
	public List<Artisan> getArtisans() {
		return artisanList;
	}

	@Override
	public List<Org> getAllOrgs() {
		return orgList;
	}

	@Override
	public Artisan addArtisan(Artisan artisan) {
		// 设置ID
		artisan.setId(getNextId());
		artisanList.add(artisan);
		return artisan;
	}

	
	
	private long getNextId() {
		long id = 0L;
        for (Artisan artisan : artisanList) {
            long artisanId = artisan.getId();
            if (artisanId > id) {
                id = artisanId;
            }
        }
        return id + 1;
	}

	@Override
	public Org getOrg(int orgId) {
		for (Org org:orgList) {
			if (orgId == org.getOrgId()) {
				return org;
			}
		}
		return null;
	}

	@Override
	public Artisan updateArtisan(Artisan artisan) {
		artisan.setCode(artisan.getCode());
		artisan.setName(artisan.getName());
		artisan.setOrg(artisan.getOrg());
		
		artisanList.set((int) artisan.getId(), artisan);
		return artisan;
	}

	@Override
	public Artisan getArtisanById(long id) {
		Artisan artisan = artisanList.get((int) id);
		return artisan;
	}


}
