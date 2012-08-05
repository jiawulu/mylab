package com.taobao.wireless;

import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class LinkedList {

    @OnMethod(clazz = "java.util.LinkedList",
            method = "getFirst",
            location=@Location(Kind.RETURN))
    public static void execute(@Return final Object result,@Self Object list) {
        println("getFirst invoked >>> ");
        printFields(result);
        println("starck >>> ");
        jstack();
        println("pields >>> ");
        printFields(get(field("java.util.LinkedList", "first"), list));
    }
}
