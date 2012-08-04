package com.taobao.wuzhong

int a = 10
//a = "hello"
println(a)

def b = 10
b = "hello"
println b

def num = [1,2,3,4]
println num.getClass().getName() //java.util.ArrayList
num.each{i -> println i*2}  //依靠groovy的动态类型实现的

def rng = 1..10
println rng.getClass().getName() //groovy.lang.IntRange  GDK
