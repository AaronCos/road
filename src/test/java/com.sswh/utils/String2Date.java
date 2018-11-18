package com.sswh.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class String2Date {
	public static Date getDate(String year,String month,String day) throws Exception{
		String mm=fillMonth(month);
		String dd=fillDay(day);
		StringBuilder date=new StringBuilder();
		date.append(year);
		date.append("-");
		date.append(mm);
		date.append("-");
		date.append(dd);
		return new SimpleDateFormat("yyyy-MM-dd").parse(date.toString());
	}

	private static String fillMonth(String month) {
		if(month.length()<2){
			return "0"+month;
		}
		return month;
	}
	private static String fillDay(String day) {
		if(day.length()<2){
			return "0"+day;
		}
		return day;
	}
}
