package com.test.service;

import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

//����excel�ļ�����
@Service
public interface ExcelExportService {
	public void makeWorkBook(Map<String, Object> model,Workbook workbook);
}
