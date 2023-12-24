package com.example.coroutinesexamples.KoltinTutorial

import kotlin.math.pow

fun main(){
   // println(sum(2.0,3.0))
    //println(power1(2.0,3.0))
    var fn= :: sum /* asing fun to a variables */
    //println(fn(2.0,4.0 ))
    var lambda1= {x:Int, y:Int -> x+y}
    println(lambda1)
    var multiLineLambda = {
         println("Hello lambda")
        val a: Int = 2+3
        a
    }
    println(multiLineLambda())
    calculator1(1.0,2.0,{a,b -> a+b}) //lambda expression call

}
fun sum(a:Double,b:Double):Double{
    return a+b
}
fun power1(a:Double ,b:Double):Double{
    return a.pow(b)
}

fun calculator1(a: Double,b:Double,gn: (Double,Double) -> Double){ //Higher order function
    val result = gn(a,b)
    println(result)
}