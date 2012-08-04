package com.taobao.wireless.performance;

import org.junit.Assert;
import org.junit.Test;

/**
 * DESC:
 *
 * Copyright: Copyright 2011 m.taobao.com
 * @author wuzhong@taobao.com
 * @time 2011-3-31 ÉÏÎç11:41:02
 * @version 1.0
 **/
public class InterTest {
	
	
	@Test
	public void test(){
		
		
		Assert.assertTrue(Integer.valueOf(5) == Integer.valueOf(5));
		Assert.assertTrue(Integer.valueOf(6) == Integer.valueOf(6));
		// -128 ¡« 127
		Assert.assertTrue(Integer.valueOf(1005) != Integer.valueOf(1005));
		
		
	}

}
