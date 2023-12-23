package com.example.coroutinesexamples.KoltinTutorial

fun main(){
    var arr= arrayOf("one","two","three")
    val arr1= arrayOf(1,2,3,4,5) //implicit array declaration

    var arr2= arrayOf<Int>(2,4,5,6) // explicit array declaration

    for (i in arr){
        println(i)
    }
    for ((i,e)in arr.withIndex()) //i= index and e = value
    {
        println("$i - $e")
    }
}