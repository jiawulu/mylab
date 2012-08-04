
/**
 * DESC:
 *
 * Copyright: Copyright 2011 m.taobao.com
 * @author wuzhong@taobao.com
 * @time 2011-3-1 下午02:20:37
 * @version 1.0
 **/
def greet = "helloworld"

println greet

println greet[1]
println greet[-1]
//包含边界
println greet[1..3]
//不包含边界
println greet[1..<3]

def name = """hello"""
def name2 = """hello000
				0000
				000"""
println name
println name2

//和java一样，字符串都不可变化
def a = "hello"
println(a+"world")
println(a.plus("world"))
println(a - "ll")
println(a*3)