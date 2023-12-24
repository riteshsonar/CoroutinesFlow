package com.example.coroutinesexamples.KoltinTutorial

fun main(){
    val nums= listOf(1,2,3,4,5)

    /*val list= nums.filter(fun (a:Int):Boolean{
        return a%2 !=0
    })
    println(list)*/
    val list=  nums.filter{ it % 2 !=0}
    println(list)

    val squareList= nums.map { it * it }
    println(squareList)

    for (i in nums){
        println(i)
    }
    //replce with forEach
    nums.forEach{ println(it)}
}
