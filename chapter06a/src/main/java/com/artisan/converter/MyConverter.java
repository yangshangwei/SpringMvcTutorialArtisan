package com.artisan.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
/**
 * 
* @ClassName: MyConverter  
* @Description: 自定义Converter,将String类型的数据转换为指定格式的Date
* @author Mr.Yang  
* @date 2018年2月10日  
*
 */
public class MyConverter implements Converter<String, Date> {

	private String datePattern;
	private Date targetFormateDate;

	/**
	 * 
	 * 创建一个新的实例 MyConverter. 默认构造函数
	 *
	 */
	public MyConverter() {
		super();
	}

	/**
	 * 
	 * 创建一个新的实例 MyConverter. 实例化时指定日期格式
	 * 
	 * @param datePattern
	 */
	public MyConverter(String datePattern) {
		super();
		this.datePattern = datePattern;
	}


	/**
	 * 重写convert方法
	 */
	@Override
	public Date convert(String source) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
			// 是否严格解析日期,设置false禁止SimpleDateFormat的自动计算功能
			sdf.setLenient(false);
			targetFormateDate = sdf.parse(source);
		} catch (ParseException e) {
			// the error message will be displayed when using <form:errors>
			e.printStackTrace();
			throw new IllegalArgumentException("invalid date format. Please use this pattern\"" + datePattern + "\"");
		}
		return targetFormateDate;
	}

}

/**
 * 如果设置为true,假设你输入的日期不合法,它会先进行一定的计算.计算出能有合法的值,就以计算后的值为真正的值.
 * 
 * 比如说当你使用的时候有2012-02-31,2012-14-03这样数据去format,
 * 如果setLenient(true).那么它就会自动解析为2012-03-02和2013-02-03这样的日期.
 * 如果setLenient(false),2012-14-03就会出现解析异常,因为去掉了计算,而这样的数据又是不合法的
 * 
 */
