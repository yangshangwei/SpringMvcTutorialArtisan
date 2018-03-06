package com.artisan.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
/**
 * 
* @ClassName: MyConverter  
* @Description: �Զ���Converter,��String���͵�����ת��Ϊָ����ʽ��Date
* @author Mr.Yang  
* @date 2018��2��10��  
*
 */
public class MyConverter implements Converter<String, Date> {

	private String datePattern;
	private Date targetFormateDate;

	/**
	 * 
	 * ����һ���µ�ʵ�� MyConverter. Ĭ�Ϲ��캯��
	 *
	 */
	public MyConverter() {
		super();
	}

	/**
	 * 
	 * ����һ���µ�ʵ�� MyConverter. ʵ����ʱָ�����ڸ�ʽ
	 * 
	 * @param datePattern
	 */
	public MyConverter(String datePattern) {
		super();
		this.datePattern = datePattern;
	}


	/**
	 * ��дconvert����
	 */
	@Override
	public Date convert(String source) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
			// �Ƿ��ϸ��������,����false��ֹSimpleDateFormat���Զ����㹦��
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
 * �������Ϊtrue,��������������ڲ��Ϸ�,�����Ƚ���һ���ļ���.��������кϷ���ֵ,���Լ�����ֵΪ������ֵ.
 * 
 * ����˵����ʹ�õ�ʱ����2012-02-31,2012-14-03��������ȥformat,
 * ���setLenient(true).��ô���ͻ��Զ�����Ϊ2012-03-02��2013-02-03����������.
 * ���setLenient(false),2012-14-03�ͻ���ֽ����쳣,��Ϊȥ���˼���,���������������ǲ��Ϸ���
 * 
 */
