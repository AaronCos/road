package com.sswh.utils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateToolBag {
    public static String getMonth(Date date) {
        if (date == null) {
            return "0000-00-00";
        }
        String month = "";
        SimpleDateFormat sd = new SimpleDateFormat("MM-dd");
        try {
            month = sd.format(date);
        } catch (Exception e) {
            month = "";
        }
        return month;
    }

    /**
     * Date--->String(YYYY-mm-dd)
     *
     * @param date
     * @return
     */
    public static String getCharDate(Date date) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (date == null) {
            return "0000-00-00";
        }
        String format = sd.format(date);
        return format.toString().substring(0, 10);
    }

    /**
     * Date--->String(yyyy-MM-dd HH:mm:ss)
     *
     * @param date
     * @return
     */
    public static String getCharDates(Date date) {
        if (date == null) {
            return "0000-00-00";
        }
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sd.format(date);
        return format.toString();
    }

    /**
     * @Description List<Date>--->List<String> date(yyyy-mm-dd)日期列表转为字符串列表
     * @param dateList
     * @return
     */
    public static List<String> changeDatesListToStringList(List<Date> dateList){
        List<String> dateStringList = new ArrayList<>();
        if (dateList != null && dateList.size()>0) {
            for (int i = 0; i < dateList.size(); i++) {
                dateStringList.add(getCharDate(dateList.get(i)));
            }
            return dateStringList;
        }else {
            return null;
        }
    }

    public static String getYearAfter(Integer year) {
        if (year == null) {
            year = 1;
        }
        Calendar cal = Calendar.getInstance();
        Date time = cal.getTime();
        cal.add(Calendar.YEAR, year);
        return getCharDate(cal.getTime());
    }


    public static Date getParseDate(String ymd) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date tempDate = null;
        try {
            tempDate = sd.parse(ymd);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tempDate;


    }

    /**
     * 计算2个日期之间相差的  相差多少年月日
     * 比如：2011-02-02 到  2017-03-02 相差 6年，1个月，0天
     *
     * @param fromDate
     * @param toDate
     * @return
     */
    public static DayCompareEntity dayComparePrecise(Date fromDate, Date toDate) {
        Calendar from = Calendar.getInstance();
        from.setTime(fromDate);
        Calendar to = Calendar.getInstance();
        to.setTime(toDate);

        int fromYear = from.get(Calendar.YEAR);
        int fromMonth = from.get(Calendar.MONTH);
        int fromDay = from.get(Calendar.DAY_OF_MONTH);

        int toYear = to.get(Calendar.YEAR);
        int toMonth = to.get(Calendar.MONTH);
        int toDay = to.get(Calendar.DAY_OF_MONTH);
        int year = toYear - fromYear;
        int month = toMonth - fromMonth;
        int day = toDay - fromDay;
        DayCompareEntity dayCompare = new DayCompareEntity();
        dayCompare.setDay(day);
        dayCompare.setMonth(month);
        dayCompare.setYear(year);
        return dayCompare;
    }

    /**
     * 计算2个日期之间相差的  以年、月、日为单位，各自计算结果是多少
     * 比如：2011-02-02 到  2017-03-02
     * 以年为单位相差为：6年
     * 以月为单位相差为：73个月
     * 以日为单位相差为：2220天
     *
     * @param fromDate
     * @param toDate
     * @return
     */
    public static DayCompareEntity dayCompare(Date fromDate, Date toDate) {
        Calendar from = Calendar.getInstance();
        from.setTime(fromDate);
        Calendar to = Calendar.getInstance();
        to.setTime(toDate);
        //只要年月
        int fromYear = from.get(Calendar.YEAR);
        int fromMonth = from.get(Calendar.MONTH);

        int toYear = to.get(Calendar.YEAR);
        int toMonth = to.get(Calendar.MONTH);

        int year = toYear - fromYear;
        int month = toYear * 12 + toMonth - (fromYear * 12 + fromMonth);
        int day = (int) ((to.getTimeInMillis() - from.getTimeInMillis()) / (24 * 3600 * 1000));
        DayCompareEntity dayCompare = new DayCompareEntity();
        dayCompare.setDay(day);
        dayCompare.setMonth(month);
        dayCompare.setYear(year);
        return dayCompare;
    }

    /**
     * 计算2个日期相差多少年
     * 列：2011-02-02  ~  2017-03-02 大约相差 6.1 年
     *
     * @param fromDate
     * @param toDate
     * @return
     */
    public static String yearCompare(Date fromDate, Date toDate) {
        DayCompareEntity result = dayComparePrecise(fromDate, toDate);
        double month = result.getMonth();
        double year = result.getYear();
        //返回2位小数，并且四舍五入
        DecimalFormat df = new DecimalFormat("######0.0");
        return df.format(year + month / 12);
    }

}
