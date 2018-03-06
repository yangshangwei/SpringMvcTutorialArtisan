package com.artisan.springmvc.domian;

public class Artisan {

	private long id;
	private String name;
	private String code;
	private String sex;
	private Org org;
	
	
	
	
	/**
	 * 
	 * 创建一个新的实例 Artisan.
	 * 
	 * @param id
	 * @param name
	 * @param code
	 * @param sex
	 * @param org
	 */
	public Artisan(long id, String name, String code, String sex, Org org) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.sex = sex;
		this.org = org;
	}

	/**
	 * 
	* 默认构造函数
	*
	 */
	public Artisan() {
		super();
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

}
