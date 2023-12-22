package com.example.coroutinesexamples.KoltinTutorial

fun main(){
   /* val result = add(4,5)
    println(result)
    val result2 = add(8,3)
    println(result2)
    evenOrOdd(12)
    evenOrOdd(13)*/
    printMessage(3) //argument
    printMessage()
}
fun printMessage(count :Int =2){ //count parameter it is val type
    for(i in 1..count){
        println("Hello $i")
    }
}
fun add(num1: Int, num2:Int): Int{
    val sum= num1 + num2
    return sum
}
//inLine Function
fun addLine(num1: Int,num2: Int)= num1+num2
fun evenOrOdd(num1: Int){
    val result= if (num1 %2 ==0)"Even" else "Odd"
    println(result)
}