package com.taobao.wuzhong.spring;

import java.io.IOException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * DESC:
 * 
 * Copyright: Copyright 2011 m.taobao.com
 * 
 * @author wuzhong@taobao.com
 * @time 2011-3-7 ����11:38:39
 * @version 1.0
 **/
public class GroovySpringTest {

	@Test
	public void test() throws IOException {
		
		ApplicationContext context =  new FileSystemXmlApplicationContext("classpath:groovyContext.xml");
		Hello hello = (Hello) context.getBean("hello");
		System.out.println(hello.sayHello("fang"));
		
//		StackTraceElement[] s = Thread.currentThread().getStackTrace();
//		for (StackTraceElement tmp : s) {
//			System.out.println(tmp.getClassName() + "." + tmp.getMethodName());
//		}
		
	}
	
	
//	@Test
//	public void test2() throws IOException {
//		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:groovyContext.xml");
//
//		Hello hello = (Hello) context.getBean("jhello");
//		System.in.read();
//		System.out.println(hello.sayHello("fang"));
//	}
	
	

}
