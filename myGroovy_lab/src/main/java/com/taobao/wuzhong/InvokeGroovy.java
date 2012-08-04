package com.taobao.wuzhong;

import groovy.lang.GroovyClassLoader;
import java.io.File;

/**
 * 动态载入Groovy类，创建接口实例，调用接口中定义的方法 
 */
public class InvokeGroovy {
	public static void main(String[] args) {
		ClassLoader cl = new InvokeGroovy().getClass().getClassLoader();
		GroovyClassLoader groovyCl = new GroovyClassLoader(cl);
		try {
			Class groovyClass = groovyCl.parseClass(new File("src/main/java/com/taobao/wuzhong/Foo.groovy"));
			IFoo foo = (IFoo) groovyClass.newInstance();
			System.out.println(foo.run(new Integer(2)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}