package com.taobao.wireless.simpledate;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateFormat {
	public static String TODAY_STR = "";
	public static String TOMORROW_STR = "";
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		Date tomorrow = new Date(today.getTime() + 1000 * 60 * 60 * 24);
		TODAY_STR = sdf.format(today);
		TOMORROW_STR = sdf.format(tomorrow);

		Thread thread1 = new Thread(new Thread1(sdf, today));
		thread1.start();
		Thread thread2 = new Thread(new Thread2(sdf, tomorrow));
		thread2.start();
	}

}
