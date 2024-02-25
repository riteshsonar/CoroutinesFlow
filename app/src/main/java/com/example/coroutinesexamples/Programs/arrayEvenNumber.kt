package com.example.coroutinesexamples.Programs

fun main(){
//https://javaconceptoftheday.com/java-array-interview-programs/
    //array program to solve
    //first Program using List and Filter
    val nums = listOf<Int>(1,2,3,4,56,7,8,9)
    val list = nums.filter { it % 2== 0 }
    println("even number is $list")




}