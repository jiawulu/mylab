package com.taobao.wireless;

import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.printFields;
import static com.sun.btrace.BTraceUtils.println;

@BTrace
public class Sirius {

    @OnMethod(clazz = "com.alibaba.citrus.wireless.pullTools.ControlTool",
            method = "getControlParameters",
            location=@Location(Kind.RETURN))
    public static void execute(@Return final Object result) {
        println("getControlParameters invoked >>> ");
        printFields(result);
    }
}
