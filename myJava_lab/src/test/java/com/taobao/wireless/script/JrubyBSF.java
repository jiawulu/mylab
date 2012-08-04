package com.taobao.wireless.script;

import org.apache.bsf.BSFException;
import org.apache.bsf.BSFManager;
import org.junit.Test;

/**
 * DESC:
 *
 * Copyright: Copyright 2011 m.taobao.com
 * @author wuzhong@taobao.com
 * @time 2011-2-25 ионГ10:58:32
 * @version 1.0
 **/
public class JrubyBSF {
	
	@Test
	public void test() throws BSFException{
		
		BSFManager.registerScriptingEngine("ruby", "org.jruby.javasupport.bsf.JRubyEngine", new String[]{"rb"});
		
		BSFManager m = new BSFManager();
		
		m.declareBean("a", "hello world", String.class);
		
		m.exec("ruby", "(java)", 1, 1, "puts $a");
		
		
	}

}
