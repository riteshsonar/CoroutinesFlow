package com.example.coroutinesexamples.Programs

import java.lang.Math.sqrt

fun Array<Int>.findLargestNumber():Int?{

    if (this.isEmpty())return null

    var max= this[0]

    for (num in this){
        if (num > max){
            max= num
        }
    }
    return max
}
fun main(){
    val numbers = arrayOf(10,5,10,10,12,3,8,5)
    val largestNumber= numbers.findLargestNumber()

    if (largestNumber!=null){

        println("The largest number is the array is: $largestNumber ")
    }else{
        println("The array is empty")
    }

    val intArray = intArrayOf(4, 9, 16, 25) // Example IntArray

    val sqrArray = intArray.map { sqrt(it.toDouble()) }
    val sqrtArray = intArray.map { sqrt(it.toDouble()) }.toDoubleArray()
    val sqr= intArrayOf(4,6,7,3,5)

    println("Square roots of elements in the array:")
    sqrArray.forEach { println(it) }
    println("$sqr")
    println("$sqrArray")

}


