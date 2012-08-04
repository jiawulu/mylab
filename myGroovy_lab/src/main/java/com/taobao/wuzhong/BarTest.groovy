package com.taobao.wuzhong;

import static org.junit.Assert.*;


/**
 * DESC:
 *
 * Copyright: Copyright 2011 m.taobao.com
 * @author wuzhong@taobao.com
 * @time 2011-3-3 обнГ01:55:26
 * @version 1.0
 **/
class BarTest extends GroovyTestCase {
	
	def hello(){
		println("hello");
		}
	
	void testA(){
		hello()
		def a = 2;
		
		assertEquals 4, a*2		
		}
	
	void testB(){
		println "test b"
		}
	
	void c(){
		println "test c..."
		}

}
