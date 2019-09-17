package com.test.controller;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.pojo.Role;
import com.test.service.ExcelExportService;
import com.test.service.RoleService;
import com.test.util.ExcelView;

//����Excel��ͼ
@Controller
public class ExcelViewController {

	@Autowired
	RoleService roleService;

	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public ModelAndView export(Model model) {
		ModelAndView mv = new ModelAndView();
		ExcelView ev = new ExcelView(exportService());
		ev.setFileName("AllRoles.xlsx");
		List<Role> roleList = roleService.findAll();
		mv.addObject("roleList", roleList);
		mv.setView(ev);
		return mv;
	}

	//lambda���ʽ���������ڲ���
	@SuppressWarnings("unchecked")
	private ExcelExportService exportService() {
		//lambda�﷨��(parameters) -> expression��parameters��ʾ���ܵĲ���
		//�˴����ص�Ӧ��һ��new ExcelExportService
		return (Map<String, Object> model,Workbook workbook) -> {
			List<Role> roleList = (List<Role>) model.get("roleList");
			//����sheet
			Sheet sheet = workbook.createSheet("���н�ɫ");
			//������һ�б����У��±�Ϊ0
			Row title = sheet.createRow(0);
			//����ÿһ�б�����������ܹ����У�cell��Ŵ�0��ʼ
			title.createCell(0).setCellValue("���");
			title.createCell(1).setCellValue("����");
			title.createCell(2).setCellValue("��ע");
			//�����У�Ϊÿһ�з�������
			for (int i = 0; i < roleList.size(); i++) {
				Role role = roleList.get(i);
				int rowIdx = i + 1;
				//������rowIdx��
				Row row = sheet.createRow(rowIdx);
				row.createCell(0).setCellValue(role.getId());
				row.createCell(1).setCellValue(role.getRoleName());
				row.createCell(2).setCellValue(role.getNote());
			}
		};
	}

	//ʹ�������ڲ���
//	@SuppressWarnings("unchecked")
//	private ExcelExportService exportService() {
//		return (new ExcelExportService() {
//			@Override
//			public void makeWorkBook(Map<String, Object> model, Workbook workbook) {
//				List<Role> roleList = (List<Role>) model.get("roleList");
//				//����sheet
//				Sheet sheet = workbook.createSheet("���н�ɫ");
//				//���ر���
//				Row title = sheet.createRow(0);
//				title.createCell(0).setCellValue("���");
//				title.createCell(1).setCellValue("����");
//				title.createCell(2).setCellValue("��ע");
//				//
//				for (int i = 0; i < roleList.size(); i++) {
//					Role role = roleList.get(i);
//					int rowIdx = i + 1;
//					Row row = sheet.createRow(rowIdx);
//					row.createCell(0).setCellValue(role.getId());
//					row.createCell(1).setCellValue(role.getRoleName());
//					row.createCell(2).setCellValue(role.getNote());
//			}
//		}
//	});
//	}
}
