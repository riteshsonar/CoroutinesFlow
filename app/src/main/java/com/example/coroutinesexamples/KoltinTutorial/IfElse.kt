package com.example.coroutinesexamples.KoltinTutorial

fun main(){
    val x = 10
    val y= 11
    if (x > y){
        println(" X is greater then Y")
    }else if(x < y){
        println(" X is less then Y")
    }else{
        println(" X is equal to Y")
    }
    val number = 21
    val result = if (number %2 ==0) "Even" else "Odd"
    println(result)
}