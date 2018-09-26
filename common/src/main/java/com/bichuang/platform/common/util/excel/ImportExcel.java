package com.bichuang.platform.common.util.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bichuang.platform.common.util.excel.annotation.ExcelField;

/**
 * 导入Excel文件（支持“XLS”和“XLSX”格式）
 *
 * @author hlej
 * @version 2013-03-10
 */
public class ImportExcel {
	private static Logger log = LoggerFactory.getLogger(ImportExcel.class);
	/**
	 * 工作薄对象
	 */
	private Workbook wb;
	/**
	 * 工作表对象
	 */
	private Sheet sheet;
	/**
	 * 标题行号
	 */
	private int headerNum;
	private Map<String, Integer> fieldsIndex = new HashMap<>();

	/**
	 * 构造函数
	 *
	 * @param path      导入文件，读取第一个工作表
	 * @param headerNum 标题行号，数据行号=标题行号+1
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public ImportExcel(String fileName, int headerNum) throws InvalidFormatException, IOException {
		this(new File(fileName), headerNum);
	}

	/**
	 * 构造函数
	 *
	 * @param path      导入文件对象，读取第一个工作表
	 * @param headerNum 标题行号，数据行号=标题行号+1
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public ImportExcel(File file, int headerNum) throws InvalidFormatException, IOException {
		this(file, headerNum, 0);
	}

	/**
	 * 构造函数
	 *
	 * @param path       导入文件
	 * @param headerNum  标题行号，数据行号=标题行号+1
	 * @param sheetIndex 工作表编号
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public ImportExcel(String fileName, int headerNum, int sheetIndex) throws InvalidFormatException, IOException {
		this(new File(fileName), headerNum, sheetIndex);
	}

	/**
	 * 构造函数
	 *
	 * @param path       导入文件对象
	 * @param headerNum  标题行号，数据行号=标题行号+1
	 * @param sheetIndex 工作表编号
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public ImportExcel(File file, int headerNum, int sheetIndex) throws InvalidFormatException, IOException {
		this(file.getName(), new FileInputStream(file), headerNum, sheetIndex);
	}

	/**
	 * 构造函数
	 *
	 * @param file       导入文件对象
	 * @param headerNum  标题行号，数据行号=标题行号+1
	 * @param sheetIndex 工作表编号
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	/*public ImportExcel(MultipartFile multipartFile, int headerNum, int sheetIndex) throws InvalidFormatException, IOException {
		this(multipartFile.getOriginalFilename(), multipartFile.getInputStream(), headerNum, sheetIndex);
	}*/

	/**
	 * 构造函数
	 *
	 * @param path       导入文件对象
	 * @param headerNum  标题行号，数据行号=标题行号+1
	 * @param sheetIndex 工作表编号
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public ImportExcel(String fileName, InputStream is, int headerNum, int sheetIndex) throws InvalidFormatException, IOException {
		if (StringUtils.isBlank(fileName)) {
			throw new RuntimeException("导入文档为空!");
		} else if (fileName.toLowerCase().endsWith("xls")) {
			this.wb = new HSSFWorkbook(is);
		} else if (fileName.toLowerCase().endsWith("xlsx")) {
			this.wb = new XSSFWorkbook(is);
		} else {
			throw new RuntimeException("文档格式不正确!");
		}
		if (this.wb.getNumberOfSheets() < sheetIndex) {
			throw new RuntimeException("文档中没有工作表!");
		}
		this.sheet = this.wb.getSheetAt(sheetIndex);
		this.headerNum = headerNum;
		log.debug("Initialize success.");
	}

	/**
	 * 获取行对象
	 *
	 * @param rownum
	 * @return
	 */
	public Row getRow(int rownum) {
		return this.sheet.getRow(rownum);
	}

	/**
	 * 获取数据行号
	 *
	 * @return
	 */
	public int getDataRowNum() {
		return headerNum + 1;
	}

	/**
	 * 获取最后一个数据行号
	 *
	 * @return
	 */
	public int getLastDataRowNum() {
		return this.sheet.getLastRowNum() + headerNum;
	}

	/**
	 * 获取最后一个列号
	 *
	 * @return
	 */
	public int getLastCellNum() {
		return this.getRow(headerNum).getLastCellNum();
	}

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 获取单元格值
	 *
	 * @param row    获取的行
	 * @param column 获取单元格列号
	 * @return 单元格值
	 */
	public Object getCellValue(Row row, int column) {
		Object val = "";
		try {
			Cell cell = row.getCell(column);
			if (cell != null) {
				if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
					if (HSSFDateUtil.isCellDateFormatted(cell)) {
						val = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
					} else {
						val = cell.getNumericCellValue();
						if(Math.ceil(Double.parseDouble(val+"")) == Double.parseDouble(val+"")){
							DecimalFormat df = new DecimalFormat("0");//转换成整型
							val = new BigDecimal(df.format(cell.getNumericCellValue()));
						}else{
							DecimalFormat df = new DecimalFormat("0.00");
							val = new BigDecimal(df.format(cell.getNumericCellValue()));
						}
						
					}
				} else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					val = cell.getStringCellValue();
					if (StringUtils.isEmpty(val.toString())) {
						val = null;
					}
				} else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
					val = cell.getCellFormula();
				} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
					val = cell.getBooleanCellValue();
				} else if (cell.getCellType() == Cell.CELL_TYPE_ERROR) {
					val = cell.getErrorCellValue();
				}
			}
		} catch (Exception e) {
			return val;
		}
		return val;
	}

	/**
	 * 解析excel与对象属性的对应关系
	 * @param f
	 * @param ef
	 * @throws Exception 
	 */
	private void parseFiledIndex(Field f, ExcelField ef) throws Exception {
		Row row = this.getRow(this.headerNum);
		if(row == null){
			throw new Exception("未找到标题行,请检查或更换表格");
		}
		int len = row.getLastCellNum();
		for (int i = 0; i < len; i++) {
			String fieldName = f.getName();
			if (fieldsIndex.containsKey(fieldName)) {
				continue;
			}
			String efTitleName = ef.title();
			Object cellValue = this.getCellValue(row, i);
			if (cellValue == null) {
				continue;
			}
			if (efTitleName.equals(cellValue.toString().trim())) {
				fieldsIndex.put(fieldName, i);
				break;
			}
		}
	}

	/**
	 * 获取导入数据列表
	 *
	 * @param cls    导入对象类型
	 * @param groups 导入分组
	 */
	public <E> List<E> getDataList(Class<E> cls, int... groups) throws InstantiationException, IllegalAccessException,Exception {
		List<Object[]> annotationList = new ArrayList<>();
		// Get annotation field
		Field indexFiled = null;
		Field[] fs = cls.getDeclaredFields();
		for (Field f : fs) {
			if ("index".equals(f.getName())) {
				indexFiled = f;
			}
			ExcelField ef = f.getAnnotation(ExcelField.class);
			if (ef != null && (ef.type() == 0 || ef.type() == 2)) {
				if (groups != null && groups.length > 0) {
					boolean inGroup = false;
					for (int g : groups) {
						if (inGroup) {
							break;
						}
						for (int efg : ef.groups()) {
							if (g == efg) {
								inGroup = true;
								parseFiledIndex(f, ef);
								annotationList.add(new Object[] { ef, f });
								break;
							}
						}
					}
				} else {
					parseFiledIndex(f, ef);
					annotationList.add(new Object[] { ef, f });
				}
			}
		}
		// Get annotation method
		Method[] ms = cls.getDeclaredMethods();
		for (Method m : ms) {
			ExcelField ef = m.getAnnotation(ExcelField.class);
			if (ef != null && (ef.type() == 0 || ef.type() == 2)) {
				if (groups != null && groups.length > 0) {
					boolean inGroup = false;
					for (int g : groups) {
						if (inGroup) {
							break;
						}
						for (int efg : ef.groups()) {
							if (g == efg) {
								inGroup = true;
								annotationList.add(new Object[] { ef, m });
								break;
							}
						}
					}
				} else {
					annotationList.add(new Object[] { ef, m });
				}
			}
		}
		// Field sorting
		Collections.sort(annotationList, new Comparator<Object[]>() {
			public int compare(Object[] o1, Object[] o2) {
				return new Integer(((ExcelField) o1[0]).sort()).compareTo(new Integer(((ExcelField) o2[0]).sort()));
			};
		});
		//log.debug("Import column count:"+annotationList.size());
		// Get excel data
		List<E> dataList = new ArrayList<>();
		for (int i = this.getDataRowNum(); i <= this.getLastDataRowNum(); i++) {
			E e = (E) cls.newInstance();
			int column = 0;
			Row row = this.getRow(i-1);
			StringBuilder sb = new StringBuilder();
			if (indexFiled != null) {
				Reflections.invokeSetter(e, indexFiled.getName(), i + 1);
			}
			for (Object[] os : annotationList) {
				int index = column++;
				
				Object obj = os[1];
				ExcelField ef = (ExcelField) os[0];
				Object val = null;
				if (obj instanceof Field && ef.sort() == 0) {
					Field f = (Field) obj;
					String fieldName = f.getName();
					Integer tempIndex = fieldsIndex.get(fieldName);
					if (tempIndex != null) {
						index = tempIndex;
						val = this.getCellValue(row, index);
					}
				} else {
					val = this.getCellValue(row, index);
				}
				if (val != null) {
					// Get param type and type cast
					Class<?> valType = Class.class;
					if (os[1] instanceof Field) {
						valType = ((Field) os[1]).getType();
					} else if (os[1] instanceof Method) {
						Method method = ((Method) os[1]);
						if ("get".equals(method.getName().substring(0, 3))) {
							valType = method.getReturnType();
						} else if ("set".equals(method.getName().substring(0, 3))) {
							valType = ((Method) os[1]).getParameterTypes()[0];
						}
					}
					//log.debug("Import value type: ["+i+","+column+"] " + valType);
					try {
						if (val == null || "".equals(val)) {
							continue;
						}
						if (valType == String.class) {
							String s = String.valueOf(val.toString());
							if (StringUtils.endsWith(s, ".0")) {
								val = StringUtils.substringBefore(s, ".0");
							} else {
								val = String.valueOf(val.toString());
							}
						} else if (valType == Integer.class) {
							val = Double.valueOf(val.toString()).intValue();
						} else if (valType == Long.class) {
							val = Double.valueOf(val.toString()).longValue();
						} else if (valType == Double.class) {
							val = Double.valueOf(val.toString());
						} else if (valType == Float.class) {
							val = Float.valueOf(val.toString());
						} else if (valType == Date.class) {
							if (val instanceof Date) {} else {
								val = DateUtil.getJavaDate((Double) val);
							}
						} else if (valType == BigDecimal.class) {
							val = new BigDecimal(val.toString());
						} else {
							if (ef.fieldType() != Class.class) {
								val = ef.fieldType().getMethod("getValue", String.class).invoke(null, val.toString());
							} else {
								val = Class.forName(this.getClass().getName().replaceAll(this.getClass().getSimpleName(), "fieldtype." + valType.getSimpleName() + "Type")).getMethod("getValue", String.class).invoke(null, val.toString());
							}
						}
					} catch (Exception ex) {
						log.info("Get cell value [" + i + "," + column + "] error: " + ex.toString());
						val = null;
					}
					// set entity value
					if (os[1] instanceof Field) {
						Reflections.invokeSetter(e, ((Field) os[1]).getName(), val);
					} else if (os[1] instanceof Method) {
						String mthodName = ((Method) os[1]).getName();
						if ("get".equals(mthodName.substring(0, 3))) {
							mthodName = "set" + StringUtils.substringAfter(mthodName, "get");
						}
						Reflections.invokeMethod(e, mthodName, new Class[] { valType }, new Object[] { val });
					}
				}
				sb.append(val + ", ");
			}
			dataList.add(e);
			log.debug("Read success: [" + i + "] " + sb.toString());
		}
		return dataList;
	}
	
	/**
	 * 获取标题行数据
	 * @return
	 */
	public List<String> getHeaderRow(){
		List<String> headerList = new ArrayList<>();
		// 获得标题行，默认为第一行
		Row row = getRow(0);
		// 列数
		int cellNum = 0;
		if(null != row){
			cellNum = row.getPhysicalNumberOfCells();
		}
		for (int i = 0; i < cellNum; i++) {
			Object val = this.getCellValue(row, i);
			if(val != null){
				headerList.add(String.valueOf(val).trim());
			}else{
				headerList.add("");
			}
			
		}		
		return headerList;
	}
	//	/**
	//	 * 导入测试
	//	 */
	//	public static void main(String[] args) throws Throwable {
	//
	//		ImportExcel ei = new ImportExcel("target/export.xlsx", 1);
	//
	//		for (int i = ei.getDataRowNum(); i < ei.getLastDataRowNum(); i++) {
	//			Row row = ei.getRow(i);
	//			for (int j = 0; j < ei.getLastCellNum(); j++) {
	//				Object val = ei.getCellValue(row, j);
	//				System.out.print(val+", ");
	//			}
	//			System.out.print("\n");
	//		}
	//
	//	}
}
