package com.taobao.wuzhong;

//动态载入脚本就更简单了,因为Groovy提供了一个方法evaluate,,和javascript的eval很像吧: 

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

public class TestEval {

	public Object doit() {
		Binding bb = new Binding();
		bb.setVariable("test", "hello world!");
		GroovyShell gs = new GroovyShell(bb);
		return gs.evaluate("println test");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestEval te = new TestEval();
		te.doit();

	}

}