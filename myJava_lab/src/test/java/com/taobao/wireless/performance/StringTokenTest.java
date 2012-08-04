package com.taobao.wireless.performance;

import java.util.StringTokenizer;

import org.junit.Test;

/**
 * DESC: String.split() �� StringTokenizer��ѡ��
 * 
 * String.split()���ܸ���ǿ��֧��������ʽ�ȣ���������ڼ򵥵ķָ����ָ���StringTokenizer��ǳ��࣬�������ǵ�ʵ�ַ����Ĳ�ͬ��
 * StringTokenizer�ǻ���char���ж�����������StringTokenizer.countTokens()��������������Ƚ�����
 * 
 * Copyright: Copyright 2011 m.taobao.com
 * 
 * @author wuzhong@taobao.com
 * @time 2011-3-31 ����11:49:32
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