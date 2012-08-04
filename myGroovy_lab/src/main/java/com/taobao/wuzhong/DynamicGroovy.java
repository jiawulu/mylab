package com.taobao.wuzhong;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import java.io.File;


public class DynamicGroovy {
	private GroovyObject groovyObject;

	public Object getProperty(String name) {
		return groovyObject.getProperty(name);
	}

	public Object invokeScriptMethod(String scriptName, String methodName, Object[] args) {
		ClassLoader parent = getClass().getClassLoader();
		GroovyClassLoader loader = new GroovyClassLoader(parent);
		try {
			Class groovyClass = loader.parseClass(new File(scriptName));
			groovyObject = (GroovyObject) groovyClass.newInstance();
			return groovyObject.invokeMethod(methodName, args);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		DynamicGroovy dynamicGroovy = new DynamicGroovy();
		Object[] params = { new Integer(2) };
		Object result = dynamicGroovy.invokeScriptMethod("src/main/java/com/taobao/wuzhong/Foo.groovy", "run", params);
		System.out.println(result);
		System.out.println(dynamicGroovy.getProperty("x"));
	}
}