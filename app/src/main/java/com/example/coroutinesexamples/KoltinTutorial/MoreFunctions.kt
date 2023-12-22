package com.example.coroutinesexamples.KoltinTutorial

import kotlin.math.pow

fun main(){
    /*println(addition(1,2))
    println(addition(a = 1,b = 2))//named argument
    println(addition(1.0,2.0))*/
    var fn= ::addition
    println(fn(1.0,2.0))
    fn= ::power
    println(fn(2.0,3.0))
}

fun addition(a:Double , b:Double):Double{
    return a + b
}
fun power(a:Double,b:Double):Double{
    return a.pow(b)
}