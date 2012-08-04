package com.taobao.wireless.performance;

import org.junit.Test;

/**
 * DESC:
 *
 * Copyright: Copyright 2011 m.taobao.com
 * @author wuzhong@taobao.com
 * @time 2011-3-31 ионГ11:44:16
 * @version 1.0
 **/
public class EmptyTest {
	
	private boolean empty(String str){
		return str == null && str.length() == 0;
	}
	
	@Test
	public void test2(){		
		for (int i = 0; i < 100000; i++) {		
			empty(String.valueOf(i));			
		}
	}
	
	@Test
	public void test(){		
		for (int i = 0; i < 100000; i++) {		
			"".equals(String.valueOf(i));			
		}
	}
	

}
