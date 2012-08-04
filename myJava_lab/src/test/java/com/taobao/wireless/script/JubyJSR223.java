package com.taobao.wireless.script;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Test;

/**
 * DESC:
 * 
 * Copyright: Copyright 2011 m.taobao.com
 * 
 * @author wuzhong@taobao.com
 * @time 2011-2-24 ÏÂÎç07:03:35
 * @version 1.0
 **/
public class JubyJSR223 {

	@Test
	public void test() throws ScriptException {

		ScriptEngineManager m = new ScriptEngineManager();
		ScriptEngine engine = m.getEngineByName("jruby");

		engine.getContext().setAttribute("a", new Integer(11), ScriptContext.ENGINE_SCOPE);

		engine.eval("puts 2 + $a");

	}

}
