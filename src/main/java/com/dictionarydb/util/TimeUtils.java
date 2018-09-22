package com.dictionarydb.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
	private final static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSSSSS");

	public static String getCurrentDateAsString() {
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public static Timestamp getCurrentTimestamp() {
		return new Timestamp(new Date().getTime());
	}
}
