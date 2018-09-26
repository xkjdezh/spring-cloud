package com.bichuang.platform.common.util;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * 日期工具类
 * 
 */
public class DateUtil {

    // 默认日期格式
    public static final String DATE_DEFAULT_FORMAT = "yyyy-MM-dd";

    // 默认时间格式
    public static final String DATETIME_DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String TIME_DEFAULT_FORMAT = "HH:mm:ss";
    
    public static final String yyyyMMDDHHDDSS = "yyyyMMddHHmmss";

    // 日期格式化
//    private static DateFormat dateFormat = null;
//
//    // 时间格式化
//    private static DateFormat dateTimeFormat = null;
//
//    private static DateFormat timeFormat = null;

//    private static Calendar gregorianCalendar = null;

//    static {
//        dateFormat = new SimpleDateFormat(DATE_DEFAULT_FORMAT);
//        dateTimeFormat = new SimpleDateFormat(DATETIME_DEFAULT_FORMAT);
//        timeFormat = new SimpleDateFormat(TIME_DEFAULT_FORMAT);
//        gregorianCalendar = new GregorianCalendar();
//    }

    /**
     * 日期格式化yyyy-MM-dd
     * 
     * @param date
     * @return
     */
    public static Date formatDate(String date, String format) {
        try {
            return new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
	 * 日期转换成字符串
	 * 
	 * @param date
	 * @param fmt
	 * @return
	 * @throws Exception
	 */
	public static String date2Str(Date date, String fmt) {
		try {
			if (date == null) {
				return "";
			}
			SimpleDateFormat format = new SimpleDateFormat(fmt);
			return format.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    /**
     * 验证日期的格式 
     * @param date
     * @param formatStr
     * @return true格式正确
     */
    public static Boolean isDate(String date, String formatStr) {
    	SimpleDateFormat format=new SimpleDateFormat(formatStr);
    	boolean dateflag=true;
    	if (date.length()!=formatStr.length()) {
    		dateflag=false;
		}
    	try {
    		format.setLenient(false);
    		format.parse(date);
    	} catch (ParseException e) {
    		e.printStackTrace();
    		dateflag=false;
    	}
    	return dateflag;
    }

    /**
     * 日期格式化yyyy-MM-dd
     * 
     * @param date
     * @return
     */
    public static String getDateFormat(Date date) {
    	DateFormat dateTimeFormat = new SimpleDateFormat(DATE_DEFAULT_FORMAT);
        return dateTimeFormat.format(date);
    }

    /**
     * 日期格式化yyyy-MM-dd HH:mm:ss
     * 
     * @param date
     * @return
     */
    public static String getDateTimeFormat(Date date) {
    	DateFormat dateTimeFormat = new SimpleDateFormat(DATETIME_DEFAULT_FORMAT);
        return dateTimeFormat.format(date);
    }

    /**
     * 时间格式化
     * 
     * @param date
     * @return HH:mm:ss
     */
    public static String getTimeFormat(Date date) {
    	DateFormat timeFormat = new SimpleDateFormat(TIME_DEFAULT_FORMAT);
        return timeFormat.format(date);
    }

    /**
     * 日期格式化
     * 
     * @param date
     * @param 格式类型
     * @return
     */
    public static String getDateFormat(Date date, String formatStr) {
        if (StringUtils.isNotBlank(formatStr)) {
            return new SimpleDateFormat(formatStr).format(date);
        }
        return null;
    }

    /**
     * 日期格式化
     * 
     * @param date
     * @return
     */
    public static Date getDateFormat(String date) {
        try {
        	DateFormat dateFormat = new SimpleDateFormat(DATE_DEFAULT_FORMAT);
            return dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 时间格式化
     * 
     * @param date
     * @return
     */
    public static Date getDateTimeFormat(String date) {
        try {
        	DateFormat dateTimeFormat = new SimpleDateFormat(DATETIME_DEFAULT_FORMAT);
            return dateTimeFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取当前日期(yyyy-MM-dd)
     * 
     * @param date
     * @return
     */
    public static Date getNowDate() {
    	DateFormat dateFormat = new SimpleDateFormat(DATE_DEFAULT_FORMAT);
    	String format = dateFormat.format(new Date());
        return DateUtil.getDateFormat(format);
    }

    /**
     * 获取当前日期星期一日期
     * 
     * @return date
     */
    public static Date getFirstDayOfWeek() {
    	Calendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setFirstDayOfWeek(Calendar.MONDAY);
        gregorianCalendar.setTime(new Date());
        gregorianCalendar.set(Calendar.DAY_OF_WEEK, gregorianCalendar.getFirstDayOfWeek()); // Monday
        return gregorianCalendar.getTime();
    }

    /**
     * 获取当前日期星期日日期
     * 
     * @return date
     */
    public static Date getLastDayOfWeek() {
    	Calendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setFirstDayOfWeek(Calendar.MONDAY);
        gregorianCalendar.setTime(new Date());
        gregorianCalendar.set(Calendar.DAY_OF_WEEK, gregorianCalendar.getFirstDayOfWeek() + 6); // Monday
        return gregorianCalendar.getTime();
    }

    /**
     * 获取日期星期一日期
     * 
     * @param 指定日期
     * @return date
     */
    public static Date getFirstDayOfWeek(Date date) {
        if (date == null) {
            return null;
        }
        Calendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setFirstDayOfWeek(Calendar.MONDAY);
        gregorianCalendar.setTime(date);
        gregorianCalendar.set(Calendar.DAY_OF_WEEK, gregorianCalendar.getFirstDayOfWeek()); // Monday
        return gregorianCalendar.getTime();
    }

    /**
     * 获取日期星期一日期
     * 
     * @param 指定日期
     * @return date
     */
    public static Date getLastDayOfWeek(Date date) {
        if (date == null) {
            return null;
        }
        Calendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setFirstDayOfWeek(Calendar.MONDAY);
        gregorianCalendar.setTime(date);
        gregorianCalendar.set(Calendar.DAY_OF_WEEK, gregorianCalendar.getFirstDayOfWeek() + 6); // Monday
        return gregorianCalendar.getTime();
    }

    /**
     * 获取当前月的第一天
     * 
     * @return date
     */
    public static Date getFirstDayOfMonth() {
    	Calendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(new Date());
        gregorianCalendar.set(Calendar.DAY_OF_MONTH, 1);
        return gregorianCalendar.getTime();
    }

    /**
     * 获取当前月的最后一天
     * 
     * @return
     */
    public static Date getLastDayOfMonth() {
    	Calendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(new Date());
        gregorianCalendar.set(Calendar.DAY_OF_MONTH, 1);
        gregorianCalendar.add(Calendar.MONTH, 1);
        gregorianCalendar.add(Calendar.DAY_OF_MONTH, -1);
        return gregorianCalendar.getTime();
    }

    /**
     * 获取指定月的第一天
     * 
     * @param date
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {
    	Calendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        gregorianCalendar.set(Calendar.DAY_OF_MONTH, 1);
        return gregorianCalendar.getTime();
    }

    /**
     * 获取指定月的最后一天
     * 
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
    	Calendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        gregorianCalendar.set(Calendar.DAY_OF_MONTH, 1);
        gregorianCalendar.add(Calendar.MONTH, 1);
        gregorianCalendar.add(Calendar.DAY_OF_MONTH, -1);
        return gregorianCalendar.getTime();
    }

    /**
     * 获取日期前一天
     * 
     * @param date
     * @return
     */
    public static Date getDayBefore(Date date) {
    	Calendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        int day = gregorianCalendar.get(Calendar.DATE);
        gregorianCalendar.set(Calendar.DATE, day - 1);
        return gregorianCalendar.getTime();
    }

    /**
     * 获取日期后一天
     * 
     * @param date
     * @return
     */
    public static Date getDayAfter(Date date) {
    	Calendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        int day = gregorianCalendar.get(Calendar.DATE);
        gregorianCalendar.set(Calendar.DATE, day + 1);
        return gregorianCalendar.getTime();
    }

    /**
     * 获取当前年
     * 
     * @return
     */
    public static int getNowYear() {
        Calendar d = Calendar.getInstance();
        return d.get(Calendar.YEAR);
    }

    /**
     * 获取当前月份
     * 
     * @return
     */
    public static int getNowMonth() {
        Calendar d = Calendar.getInstance();
        return d.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取当月天数
     * 
     * @return
     */
    public static int getNowMonthDay() {
        Calendar d = Calendar.getInstance();
        return d.getActualMaximum(Calendar.DATE);
    }

    /**
     * 获取时间段的每一天
     * 
     * @param 开始日期
     * @param 结算日期
     * @return 日期列表
     */
    public static List<Date> getEveryDay(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            return null;
        }
        // 格式化日期(yy-MM-dd)
        startDate = DateUtil.getDateFormat(DateUtil.getDateFormat(startDate));
        endDate = DateUtil.getDateFormat(DateUtil.getDateFormat(endDate));
        List<Date> dates = new ArrayList<Date>();
        Calendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(startDate);
        dates.add(gregorianCalendar.getTime());
        while (gregorianCalendar.getTime().compareTo(endDate) < 0) {
            // 加1天
            gregorianCalendar.add(Calendar.DAY_OF_MONTH, 1);
            dates.add(gregorianCalendar.getTime());
        }
        return dates;
    }

    /**
     * 获取提前多少个月
     * 
     * @param monty
     * @return
     */
    public static Date getFirstMonth(int monty) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -monty);
        return c.getTime();
    }
    
    /** 
    * 获得指定日期的前一天 
    * @param specifiedDay 
    * @return 
    * @throws Exception 
    */ 
    public static String getSpecifiedDayBefore(String specifiedDay){ 
    //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
    Calendar c = Calendar.getInstance(); 
    Date date=null; 
    try { 
    date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay); 
    c.setTime(date); 
    } catch (ParseException e) { 
    e.printStackTrace(); 
    } 
    int day=c.get(Calendar.DATE); 
    c.set(Calendar.DATE,day-1); 

    String dayBefore=new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()); 
    return dayBefore; 
    } 
    /** 
    * 获得指定日期的后一天 
    * @param specifiedDay 
    * @return 
    */ 
    public static String getSpecifiedDayAfter(String specifiedDay){ 
    Calendar c = Calendar.getInstance(); 
    Date date=null; 
    try { 
    date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay); 
    c.setTime(date); 
    } catch (ParseException e) { 
    e.printStackTrace(); 
    } 
    int day=c.get(Calendar.DATE); 
    c.set(Calendar.DATE,day+1); 

    String dayAfter=new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()); 
    return dayAfter; 
    }
    /**
     * 获得指定日期的年-月
     * @param specifiedDay
     * @return
     */
    public static String getSpecifiedMonth(String specifiedDay){
    	Calendar c = Calendar.getInstance();
    	Date date=null; 
        try { 
        date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay); 
        c.setTime(date); 
        } catch (ParseException e) { 
        e.printStackTrace(); 
        } 
        int day=c.get(Calendar.DATE); 
        c.set(Calendar.DATE,day+1); 

        String dayAfter=new SimpleDateFormat("yyyy-MM").format(c.getTime()); 
        return dayAfter; 
    }
    
    /**
     * 获得两个date相差多少个月
     * @param specifiedDay
     * @return
     */
    public static int getMonthBetweenNum(Date date1,Date date2){
    	Calendar cal1=Calendar.getInstance();
		Calendar cal2=Calendar.getInstance();
		//判断大小
		if (date1.getTime()>date2.getTime()) {
			cal1.setTime(date1);
			cal2.setTime(date2);
		}else {
			cal1.setTime(date2);
			cal2.setTime(date1);
		}
        
        
        int year1 = cal1.get(Calendar.YEAR);
        int month1 = cal1.get(Calendar.MONTH);
         
        int year2 = cal2.get(Calendar.YEAR);
        int month2 = cal2.get(Calendar.MONTH);
         
        int result;
        if(year1 == year2) {
            result = month1 - month2;
        } else {
            result = 12*(year1 - year2) + month1 - month2;
        }
       return result;
    }
    
    /**
     * 获得两个date相差多少天
     * @param specifiedDay
     * @return
     */
    public static int getDayBetweenNum(Date date1,Date date2){
    	int day = (int)(date1.getTime()- date2.getTime())/(24*60*60*1000);   
       return day;
    }
    
    /**
     * 获取指定时间指定天数后或者前的时间
     * @param date   指定时间
     * @param days   多少天后或者多少天前（负数）
     * @return
     */
    public static Date getApartDays(Date date,int days){
    	Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE,days);//把日期往前减少一天，若想把日期向后推一天则将负数改为正数
		return calendar.getTime();
    }
    
    
    public static void main(String[] args) {
		
    	String dateFormat2 = date2Str(new Date(),yyyyMMDDHHDDSS);
    	System.out.println(dateFormat2);
	}
    
}