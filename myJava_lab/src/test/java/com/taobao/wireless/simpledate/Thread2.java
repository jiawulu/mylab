package com.taobao.wireless.simpledate;

import java.text.SimpleDateFormat;
import java.util.Date;

class Thread2 implements Runnable {
	private SimpleDateFormat sdf;
	private Date date;

	public Thread2(SimpleDateFormat sdf, Date date) {
		this.sdf = sdf;
		this.date = date;
	}

	public void run() {
		for (;;) {
			String strDate = sdf.format(date);
			if (!TestDateFormat.TODAY_STR.equals(strDate)) {
				System.err.println("Error: date1=" + strDate + "  expect:"
						+ TestDateFormat.TODAY_STR);
				//System.exit(0);
			} else {
				System.out.print(".");
			}
		}
	}
}
