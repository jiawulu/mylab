package com.taobao.wireless;

import com.sun.btrace.AnyType;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;
import static com.sun.btrace.BTraceUtils.*;

/**
 * DESC:
 *
 * Copyright: Copyright 2011 m.taobao.com
 * @author wuzhong@taobao.com
 * @time 2011-1-25 下午07:07:28
 * @version 1.0
 **/
@BTrace
public class MyTaobao {
	
	@OnMethod(
			clazz = "com.taobao.web.home.module.screen.MyTaobao",
			method = "execute"
	)		       
	public static void execute(AnyType[] args) { // all calls to methods
        // contents of args array:
        // [0] - this for the method call
        // [1] - textual representation of the method
        // [2]..[n] - original method call arguments
        printArray(args);
        //打印调用的堆栈
        jstack();
		println("it works");	
	}

}
