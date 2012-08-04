package com.taobao.wuzhong;

class Foo implements IFoo { 
	
	def x = 0
	
	public Object run(Object foo) {
		
	println "hello world"
	x = 100
	return foo; 
	
	} 
} 
