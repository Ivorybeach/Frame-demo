package com.test.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.test.pojo.Role;
import com.test.pojo.RoleParam;
import com.test.service.RoleService;

/** 
* @ClassName: ParamController 
* @Description: ��ϰ���ݸ�����ʽ�Ĳ���
* @author ����ң
* @date 2018��7��21�� ����10:20:24 
*/
@Controller
@RequestMapping("/param")
public class ParamController {

	@Autowired
	private RoleService roleService;
	
	//����ͨ�Ĵ��η�ʽ���ǵö������mapperҪ��@paramע��
	//�˴�û���õ�mybatis��ܣ�ʡ��@param����
	@RequestMapping("/commonParam")
	public ModelAndView commonParam(String roleName,String note) {
		ModelAndView mv = new ModelAndView();
		System.out.println("roleName::::"+roleName);
		System.out.println("note::::"+note);
		mv.setViewName("role");
		return mv;
	}
	
	//pojo����,����HTTP��pojo������һ��
	@RequestMapping("/pojoParam")
	public ModelAndView pojoParam(RoleParam roleParam) {
		ModelAndView mv = new ModelAndView();
		System.out.println("roleName::::"+roleParam.getRoleName());
		System.out.println("note::::" + roleParam.getNote());
		mv.setViewName("role");
		return mv;
	}
	
	//@RequestParamע�⣬��request���л�ȡ��������HTTP��pojo,��������һ��ʱʹ��
	@RequestMapping("/requestParam")
	public ModelAndView requestParam(@RequestParam(value="role_name",defaultValue="xixi")String roleName,String note) {
		ModelAndView mv = new ModelAndView();
		System.out.println("roleName::::"+roleName);
		System.out.println("note::::"+note);
		mv.setViewName("role2");
		return mv;
	}
	
	//@pathVariable��url��ַ�л�ò�����RESTful���
	//ע��˴�urlΪ/getRole/id	,��Ҫ������������
	@RequestMapping("/getRole/{id}")
	public ModelAndView getRole(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		Role role = roleService.getRoleById(id);
		mv.addObject("role", role);
		mv.setViewName("test02");
		return mv;
	}
	
	
	//json���ݲ�����δ�ɹ�	 role3.jsp
	@RequestMapping("/findRole")
	public ModelAndView findRole(@RequestBody(required=false) RoleParam roleParam){
		ModelAndView mv = new ModelAndView();
		List<Role> roleList = roleService.findRoles(roleParam);
		mv.addObject("roleList", roleList);
		mv.setView(new MappingJackson2JsonView());
		//mv.setViewName("roleList");
		return mv;
	}
	
	//json��������
	
	
	//�����л����ݲ��� ,δ�ɹ�  role4.jsp
	@RequestMapping("/commonParamPojo2")
	public ModelAndView commonParamPojo2(String roleName,String note) {
		ModelAndView mv= new ModelAndView();
		System.out.println(roleName);
		System.out.println(note);
		mv.setViewName("role4");
		return mv;
		
	}
	
	//ҳ����ת,ֻ��Ӧget����
	@RequestMapping(value="/{page}",method=RequestMethod.GET)
	public String getPage(@PathVariable String page) {
		return page;
	}

}
