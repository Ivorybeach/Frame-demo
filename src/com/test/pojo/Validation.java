package com.test.pojo;


import java.util.Date;


import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


/** 
* @ClassName: Validation 
* @Description: ����JSR303ע����֤pojo
* @author ����ң
* @date 2018��8��1�� ����8:25:48 
*/

public class Validation {
	@NotNull(message="��Ų���Ϊ�գ�")
	private Long id;
	
	
	@Future	//ֻ���ǽ�������
	//Ҫ��ǰ̨�����ڸ�ʽ������"yyyy-MM-dd"��ʽ�����ܽ�ǰ̨��string����ת��Ϊjava��Date����
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	//@DateTimeFormat(iso = ISO.DATE)
	private Date date;
	
	@NotNull(message="�۸񲻿�Ϊ�գ�")
	private Double price;
	
	@Pattern(regexp="^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$",message="�����ʽ����")
	private String email;

	@NotNull(message="��������Ϊ�գ�")
	private Integer quantity;
	
	@DecimalMin(value="0.1")//��С0.1
	@DecimalMax(value="2000.0")//���2000
	private Double amount;
	
	@NotNull
	@Size(min=1,max=3)
	private String note;
	
	@NotNull(message="���벻��Ϊ�գ�")
	@Pattern(regexp="^[1][3,4,5,7,8][0-9]{9}$",message="�ֻ������ʽ����")
	private String phone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

	
}
