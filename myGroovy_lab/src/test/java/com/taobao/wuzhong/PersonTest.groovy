package com.taobao.wuzhong;

import static org.junit.Assert.*;

/**
 * DESC:
 *
 * Copyright: Copyright 2011 m.taobao.com
 * @author wuzhong@taobao.com
 * @time 2011-3-17 обнГ05:11:38
 * @version 1.0
 **/
class PersonTest extends GroovyTestCase{
	
	void test(){
		
		def p = new Person("wuzhong",26);
		
		System.out.println(p);
		System.out.println(p.name());
		System.out.println(p.age);
		p.hello()
		}
	

}
