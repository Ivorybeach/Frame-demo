package com.test.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import com.test.service.RoleService;

/** 
* @ClassName: TestController 
* @Description:@ControllerAdvice�����ע�����
* @author ����ң
* @date 2018��7��16�� ����9:48:58 
*/
@ControllerAdvice(basePackages= {"com.test.controller"})
public class ControllerAdviceTest {
	
	//1.@InitBinder����HTTP����������ת����
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class,new CustomDateEditor(simpleDateFormat, false));
	}
	
	//2.ȫ���쳣������������RuntimeExcetpion�쳣��������RuntimeExcetpion�쳣ʱ����תָ��ҳ��defaultException�������쳣�򲻻�
	//RuntimeException��ȫ���쳣������GlobalExceptionResolver.java�д������ｫ��������ע��
//	@ExceptionHandler(RuntimeException.class)
//	public String exception(RuntimeException exception,Model model) {
//		return "defaultError";
//	}
	
	//3.@ModelAttribute����@ModelAttributeע�͵ķ������ڴ�controllerÿ������ִ��ǰ��ִ��
		//@ModelAttributeע��ķ����з���ֵ������ֵ�ᱻ����������ģ���У�
		//����ͨ��mv.getModelMap().get(key)��model.asMap().get(key)��ȡvalue
		//����������������controller���õ����ݣ�������ǰ��ҪԤ���ص�����

	
	
	
}
