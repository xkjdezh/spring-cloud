package com.bichuang.platform.common.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * EXCEL工具类
 * 
 * @author ChenWangWu
 * @createTime 2018年1月5日下午3:17:14
 */

public class ExcelUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(ExcelUtils.class);
	
	/**
	 * 导出2003EXCEL通用方法
	 * 
	 * @author ChenWangWu
	 * @createTime 2018年1月5日下午3:17:32
	 * @param sheetName
	 *            页名称
	 * @param list
	 *            数据
	 * @param titles
	 *            列名
	 * @param fieldNames
	 *            对应属性名称
	 * @return
	 */
	public static HSSFWorkbook generateExcelFor2003(String sheetName, List<Map<String, Object>> list, String[] titles,
			String[] fieldNames) {
		if (list == null || list.size() == 0) {
			return null;
		}
		HSSFWorkbook workbook = new HSSFWorkbook();

		int excelRow = 0;
		try {
			if (sheetName == null) {
				sheetName = "sheet1";
			}
			HSSFSheet sheet = workbook.createSheet(sheetName);

			for (int i = 0; i < list.size(); i++) {
				if (i == 0) {
					// 添加标题
					int column = 0;
					HSSFRow row = sheet.createRow(excelRow);
					for (String title : titles) {
						row.createCell(column).setCellValue(title);
						column++;
					}
					excelRow++;
				}
				Map<String, Object> map = list.get(i);
				HSSFRow row = sheet.createRow(excelRow);
				for (int ii = 0; ii < fieldNames.length; ii++) {
					String value = map.get(fieldNames[ii]) == null ? "" : map.get(fieldNames[ii]).toString();
					row.createCell(ii).setCellValue(value);
				}
				excelRow++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workbook;
	}

	/**
	 * 导出2007EXCEL通用方法
	 * 
	 * @author ChenWangWu
	 * @createTime 2018年1月5日下午3:17:32
	 * @param sheetName
	 *            页名称
	 * @param list
	 *            数据
	 * @param titles
	 *            列名
	 * @param fieldNames
	 *            对应属性名称
	 * @return
	 */
	public static XSSFWorkbook generateExcelFor2007(String sheetName, List<Map<String, Object>> list, String[] titles,
			String[] fieldNames) {
		if (list == null || list.size() == 0) {
			return null;
		}
		XSSFWorkbook workbook = new XSSFWorkbook();

		int excelRow = 0;
		try {
			if (sheetName == null) {
				sheetName = "sheet1";
			}
			XSSFSheet sheet = workbook.createSheet(sheetName);

			for (int i = 0; i < list.size(); i++) {
				if (i == 0) {
					// 添加标题
					int column = 0;
					XSSFRow row = sheet.createRow(excelRow);
					for (String title : titles) {
						row.createCell(column).setCellValue(title);
						column++;
					}
					excelRow++;
				}
				Map<String, Object> map = list.get(i);
				XSSFRow row = sheet.createRow(excelRow);
				for (int ii = 0; ii < fieldNames.length; ii++) {
					String value = map.get(fieldNames[ii]) == null ? "" : map.get(fieldNames[ii]).toString();
					row.createCell(ii).setCellValue(value);
				}
				excelRow++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workbook;
	}

	/**
	 * 导出文件
	 * 
	 * @author ChenWangWu
	 * @createTime 2018年1月12日下午3:38:59
	 * @description
	 * @param wb
	 * @param fileName
	 * @param response
	 */
	public static void export(Workbook wb, String fileName, HttpServletResponse response) {
		try { // 设置response的编码方式
				// response.setContentType("application/x-msdownload");
			if (!fileName.endsWith(".xls") && !fileName.endsWith(".xlsx")) {
				fileName += ".xlsx";
			}
			// 设置附加文件名
			response.setHeader("Content-Disposition",
					"attachment; filename=" + new String(fileName.getBytes("gb2312"), "ISO8859-1"));
			OutputStream output = response.getOutputStream();
			wb.write(output);
			output.flush();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据excel表格路径获取表格的内容
	 * @author ChenWangWu
	 * @createTime 2018年1月12日下午6:54:48
	 * @description 
	 * @param xlsPath
	 * @return
	 * @throws IOException
	 */
	public static List<List<String>> getInfoByXlsPath(String xlsPath) throws IOException {
		logger.info("根据excel文件路径获取文件内容---开始,xlsPath="+xlsPath);
		FileInputStream fileIn = null;
		List<List<String>> lis = new ArrayList<>();
		try {
			fileIn = new FileInputStream(xlsPath);
			Workbook wb0 = null ;
			if (xlsPath.endsWith(".xls") ) {
				wb0 = new HSSFWorkbook(fileIn);
			}else{
				wb0 = new XSSFWorkbook(fileIn);
			}
			Sheet sht0 = wb0.getSheetAt(0);
			for (Row r : sht0) {
				// 如果当前行的行号（从0开始）未达到2（第三行）则从新循环
				if (r.getRowNum() < 1) {
					continue;
				}
				List<String> list = new ArrayList<>();
				// 取出当前行第1个单元格数据，并封装在info实体stuName属性上
				for (Cell cell : r) {
					if (0 == cell.getCellType() ) {
						//判断是否为日期类型
						if(HSSFDateUtil.isCellDateFormatted(cell)){
							//用于转化为日期格式
							Date d = cell.getDateCellValue();
							DateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
							String timeStr = formater.format(d);
							list.add(timeStr);
						}else{
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String stringCellValue = cell.getStringCellValue();
							list.add(stringCellValue);
						}
					}else{
						String stringCellValue = cell.getStringCellValue();
						list.add(stringCellValue);
					}
				}
				/*for (Cell cell : r) {
					
					cell.setCellType(Cell.CELL_TYPE_STRING);
					String stringCellValue = cell.getStringCellValue();
					list.add(stringCellValue);
				}*/
				lis.add(list);
				logger.info("根据excel文件路径获取文件内容---结束,xlsPath="+xlsPath);
			}
		} catch (Exception e) {
			logger.error("根据excel文件路径获取文件内容出错，异常信息："+e.getMessage(),e);
		} finally {
			if (fileIn!=null) {
				fileIn.close();
			}
		}
		return lis;
	}
}
