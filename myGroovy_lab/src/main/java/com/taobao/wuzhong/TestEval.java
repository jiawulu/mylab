package com.taobao.wuzhong;

//��̬����ű��͸�����,��ΪGroovy�ṩ��һ������evaluate,,��javascript��eval�����: 

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