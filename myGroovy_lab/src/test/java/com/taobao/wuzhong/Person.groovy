package com.taobao.wuzhong

/**
 * DESC:
 *
 * Copyright: Copyright 2011 m.taobao.com
 * @author wuzhong@taobao.com
 * @time 2011-3-17 обнГ05:09:48
 * @version 1.0
 **/
class Person {
	
	private String name;
	private int age;
	
	def hello(){
		System.out.println(name);
		}
	
	public void age(){
		System.out.println(age);
		}

	
	def name(){
		name
		}
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
}
