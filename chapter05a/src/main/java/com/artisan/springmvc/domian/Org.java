package com.artisan.springmvc.domian;

public class Org {

	private int orgId;
	private String orgName;
	
	/**
	 * 
	 * 创建一个新的实例 Org. 默认的构造函数需要有，否则 org.apache.jasper.JasperException:
	 * org.springframework.beans.NullValueInNestedPathException: Invalid
	 * property 'org' of bean class [com.artisan.springmvc.domian.Artisan]:
	 * Could not instantiate property type [com.artisan.springmvc.domian.Org] to
	 * auto-grow nested property path; nested exception is
	 * org.springframework.beans.BeanInstantiationException: Failed to
	 * instantiate [com.artisan.springmvc.domian.Org]: Is it an abstract class?;
	 * nested exception is java.lang.InstantiationException:
	 * com.artisan.springmvc.domian.Org
	 *
	 * 
	 */
	public Org() {
		super();
	}

	/**
	 * 
	 * 创建一个新的实例 Org.
	 * 
	 * @param orgId
	 * @param orgName
	 */
	public Org(int orgId, String orgName) {
		super();
		this.orgId = orgId;
		this.orgName = orgName;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

}
