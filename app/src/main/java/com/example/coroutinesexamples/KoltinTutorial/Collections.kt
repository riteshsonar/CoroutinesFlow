package com.example.coroutinesexamples.KoltinTutorial

fun mainList(){
    val nums = listOf(1,2,3)
    println(nums.indexOf(2))
    println(nums.contains(4))
    //nums.add //immutable list can't be changed
    val num2= mutableListOf(1,2,3)
    num2.add(5) //mutable list can be add element
    num2.remove(1)
    println(num2)
}
fun main(){
    val students= mutableMapOf<Int,String>() //mutable Map
    students.put(1,"Ritesh")
    println(students.get(1))

    for ((key,value ) in students){
        println("$key = $value")
    }

    val map= mapOf<Int,String>(1 to "Hello", 2 to "world")
    println(map)
}