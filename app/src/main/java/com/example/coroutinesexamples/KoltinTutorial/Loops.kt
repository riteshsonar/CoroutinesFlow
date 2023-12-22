package com.example.coroutinesexamples.KoltinTutorial

fun main(){
   /* var number = 5
    var index= 1
    while(index <= 10){
        println(number * index)
        index++
    }*/
    /*for(i in 1..5 step 2){
        println(i)
    }*/
   /* for (i in 10 downTo 1){
        println(i)
    }*/
    val number = 2
    for (i in 1..10){

        //println(number.toString()+" * "+ i + " = "+ (number* i))
        //string Templating
        println("$number * $i = ${number * i}")
    }

}