package com.taobao.wuzhong.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DESC:
 * 
 * Copyright: Copyright 2011 m.taobao.com
 * 
 * @author wuzhong@taobao.com
 * @time 2011-4-6 ÏÂÎç03:42:11
 * @version 1.0
 **/
public class LogTest {

	// Logback tries to find a file called logback.groovy in the classpath.
	// If no such file is found, logback tries to find a file called
	// logback-test.xml in the classpath.
	// If no such file is found, it checks for the file logback.xml in the
	// classpath..
	// If neither file is found, logback configures itself automatically using
	// the BasicConfigurator which will cause logging output to be directed to
	// the console.
	@Test
	public void test() {

		Log log = LogFactory.getLog(LogTest.class);
		Logger log2 = LoggerFactory.getLogger(LogTest.class);

		// System.out.println(log == log2);

		log.debug("eeeeee {} {} {}");

		log2.debug("{} {} {}", new String[] { "a", "b", "c" });
	}

}
