package com.taobao.wireless.performance;

import java.util.StringTokenizer;

import org.junit.Test;

/**
 * DESC: String.split() 和 StringTokenizer的选择
 * 
 * String.split()功能更加强大，支持正则表达式等，但是如果在简单的分隔符分隔中StringTokenizer快非常多，基于它们的实现方法的不同，
 * StringTokenizer是基于char的判定，尽量少用StringTokenizer.countTokens()方法，这个方法比较慢。
 * 
 * Copyright: Copyright 2011 m.taobao.com
 * 
 * @author wuzhong@taobao.com
 * @time 2011-3-31 上午11:49:32
 * @version 1.0
 **/
public class StringTokenTest {

	@Test
	public void test() {

		StringTokenizer token = new StringTokenizer("hello,123,4", ",");

		System.out.println(token.nextToken());
		System.out.println(token.nextToken());

	}

}