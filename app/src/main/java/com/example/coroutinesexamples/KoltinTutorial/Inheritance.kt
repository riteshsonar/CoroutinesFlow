package com.example.coroutinesexamples.KoltinTutorial

fun main(){
    val objChild= Child()
    objChild.myMethod()
    objChild.myMethod2()
}
open class Parent{
    val name:String = ""
    init {
        println("Parent constructor call ")
    }
    fun myMethod(){
        println("I am in Parent")
    }
}

class Child :Parent(){
    val name2: String = ""

    init {
        println("child class constructor call")
    }
    fun myMethod2(){
        println("I am in child")
    }
}