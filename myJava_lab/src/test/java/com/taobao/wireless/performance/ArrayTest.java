package com.taobao.wireless.performance;

import java.util.Arrays;
import java.util.List;

/**
 * DESC:
 *
 * Copyright: Copyright 2011 m.taobao.com
 * @author wuzhong@taobao.com
 * @time 2011-3-31 ионГ11:11:21
 * @version 1.0
 **/
public class ArrayTest {
	
	public void test(){
		
		int[] arr = {1,2,3};
		
		List lst = Arrays.asList(arr);
		
		lst.toArray(new Object[lst.size()]);
		
		//System.arraycopy(src, srcPos, dest, destPos, length)
	}

}
