package com.example.coroutinesexamples.KoltinTutorial

fun main(){
    var i= 13
    var j= 2

   /* println(i > j) //13 > 2 true
    println(i< j)  //13 < 2 false
    println(i>= j)  //13 >= 2 true
    println(i <= j) //13 <= 2 false
    println(i == j) //13 == 2 false
    println(i != j ) //13 != 2 true*/

    //post or pre increment
    //var r= 10
    // ++i // pre Increment
    // i++ // post Increment
    //println(i++) //10 post
    //println(i)  //11
    //println(++i)

    //short circuting
    var result= i == 11 || j++ == 11 //if first condition false code not execute
    println(i)
    println(j)

}