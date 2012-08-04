package com.taobao.wuzhong.spring

/**
 * DESC:
 *
 * Copyright: Copyright 2011 m.taobao.com
 * @author wuzhong@taobao.com
 * @time 2011-3-7 ионГ11:29:49
 * @version 1.0
 **/
class GroovyHello implements Hello {

	boolean sayHello(String name){
		
		if ("fang".equals(name)) {
			println "hello....."
			println "wuzhong love ${name}"
			return true;
		}
		
		println "hello ${name}"
		false  
		}
	
}
