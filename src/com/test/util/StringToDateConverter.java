package com.test.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

//��������ת����,Converter�ӿ���spring-core��Ŀ�ṩ��
public class StringToDateConverter implements Converter<String,Date>{

	/*�����Ѿ�ʹ��@InitBinder��@ControllerAdvice����HTTP�����������ת����ע�͵�
	 */
	@Override
	public Date convert(String source) {
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		try {
//			//parse(String str)����strת���ɾ�����ʽ��date
//			Date date = simpleDateFormat.parse(source);
//			return date;
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		return null;
	}

}
