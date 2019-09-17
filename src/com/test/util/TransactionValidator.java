package com.test.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.test.pojo.Validation;

//ValidatorΪspring�ṩ����֤�����������ڸ����߼�У��
public class TransactionValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		//Ҫ��֤����
		return Validation.class.equals(clazz);

	}
 
	//��֤�߼�
	@Override
	public void validate(Object obj, Errors errors) {
		Validation va = (Validation) obj;
		System.out.println(va.getAmount());
		System.out.println(va.getPrice());
		System.out.println(va.getQuantity());
		//dis = amount-price*quantity
		double dis = va.getAmount() - va.getPrice() * va.getQuantity();
		//�����ֵdis����0.01������Ϊ����
		if (Math.abs(dis) > 0.01) {
			//���������Ϣ
			//rejectValue("field","errorCode","message")��field��Χ�ڼ���rejectValue;field��������֤��Validation�е��ֶ�
			errors.rejectValue("amount", "303","���׽��͹���������۸�ƥ��");
		}
	}

}
