package com.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.test.pojo.Role;
import com.test.pojo.Validation;
import com.test.service.RoleService;

/**
 * @ClassName: RoleController
 * @Description: �ض���ת�����ԡ�validation����
 * @author ����ң
 * @date 2018��7��16�� ����10:32:47
 */
@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;

	// �����ض���,RedirectAttributes���Դ��ݲ���������pojo
	@RequestMapping("/testRedirect")
	public String testRedirect(String roleName, String note, RedirectAttributes ra) {
		roleName = "wangxiaoyao";
		note = "duanchangren";
		// addFlashAttribute()�ǽ��������浽session���ض�����ȡȻ�����
		ra.addFlashAttribute("note", note);
		ra.addFlashAttribute("roleName", roleName);
		// ���ߣ�mv.setViewName("redirect:./showResult");
		return "redirect:./showResult";
	}

	// չʾ�ض�����
	@RequestMapping("/showResult")
	@ResponseBody
	public ModelAndView showResult(String roleName, String note, Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}

	// ת�����ԣ�ת���ƺ����ܴ��ݲ���
	// ���ǿ��Խ����Ա�����request��session�У�ת��֮��ȡ������
	@RequestMapping("/testForward")
	public String testForward(HttpServletRequest request) {
		request.setAttribute("hehe", "haha");
		return "forward:./showForwardResult";
	}

	// չʾת�����
	@RequestMapping("/showForwardResult")
	@ResponseBody
	public ModelAndView showForwardResult(@RequestAttribute("hehe") String hehe, String roleName, String note,
			Model model) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("hehe", hehe);
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}

	// ����id��ȡrole
	@RequestMapping("/test02")
	public ModelAndView test02(@RequestParam(value = "id", defaultValue = "1") Long id) {

		Role role = roleService.getRoleById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("role", role);
		// modelAndView.setViewName("test02");
		// ������ͼ����Ϊjson����Ҫjackson2��
		modelAndView.setView(new MappingJackson2JsonView());
		return modelAndView;
	}

	// ���role
	@RequestMapping("/test03")
	public ModelAndView test03() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("test03");
		return modelAndView;
	}

	// ���ύ
	@RequestMapping("/testSubmit03")
	public ModelAndView testSubmit03(Role role) {
		ModelAndView mv = new ModelAndView();
		roleService.addRole(role);
		mv.setViewName("testSubmit");
		return mv;
	}

	// ҳ����ת,ֻ��Ӧget����
	@RequestMapping(value = "/{page}", method = RequestMethod.GET)
	public String getPage(@PathVariable String page) {
		return page;
	}

	//����һ�����󷽷�����ȫ��������ȫ���쳣������
	@RequestMapping(value = "/roleErrorSubmit", method = RequestMethod.POST)
	public void roleErrorSubmit() {
		Role role = roleService.getRoleById(111L);
		if (role == null) {
			throw new RuntimeException();
		}
	}
}
