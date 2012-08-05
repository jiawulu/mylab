package com.taobao.wireless;

import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class Sirius {

    @OnMethod(clazz = "com.alibaba.citrus.wireless.pullTools.ControlTool",
            method = "getControlParameters",
            location=@Location(Kind.RETURN))
    public static void execute(@Return final Object result,@Self Object controlTool) {
        println("getControlParameters invoked >>> ");
        printFields(result);
        println("starck >>> ");
        jstack();
        println("pields >>> ");
        printFields(get(field("com.alibaba.citrus.wireless.pullTools.ControlTool","controlParameterStack"),controlTool));




    }
}
