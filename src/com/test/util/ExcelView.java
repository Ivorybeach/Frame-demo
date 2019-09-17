package com.test.util;

import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.test.service.ExcelExportService;

//Excel��ͼ��
public class ExcelView extends AbstractXlsView{

	//excel�ļ���
	private String fileName;
	
	//��װexcel��ͼ�����ɹ���
	private ExcelExportService excelExportService;
	
	//�˹��췽����������excel��ͼ��������excelExportService�з�װ��excel��ͼ�����ɹ���
	public ExcelView(ExcelExportService excelExportService) {
		this.excelExportService=excelExportService;
	}
	
	public ExcelView(String fileName,ExcelExportService excelExportService) {
		this.fileName=fileName;
		this.excelExportService=excelExportService;
	}
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (excelExportService==null) {
			throw new RuntimeException("��������ӿڲ���Ϊnull");
		}
		//�ļ�������Ϊ�գ�Ϊ����ʹ������·���е��ַ���Ϊ��
		if (!StringUtils.isEmpty(fileName)) {
			System.out.println("�ļ���Ϊ��");
		}
		
		excelExportService.makeWorkBook(model, workbook);
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ExcelExportService getExcelExportService() {
		return excelExportService;
	}

	public void setExcelExportService(ExcelExportService excelExportService) {
		this.excelExportService = excelExportService;
	}
	
	
}
