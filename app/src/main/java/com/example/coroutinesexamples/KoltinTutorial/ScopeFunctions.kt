package com.example.coroutinesexamples.KoltinTutorial

import kotlin.math.sqrt

fun main() {
    val numbers = intArrayOf(2, 5, 8, 11, 14, 17) // Example integer array

    val evenNumbers = mutableListOf<Int>()
    val oddNumbers = mutableListOf<Int>()

    for (number in numbers) {
        if (number % 2 == 0) {
            evenNumbers.add(number)
        } else {
            oddNumbers.add(number)
        }
    }
    val num= arrayOf(1,3,4,56,7,9,8,10,40,55)
    for(numbers in num){
        if (numbers % 2==0){
            println("Even number is $numbers")
        }
    }
    val listInt= listOf<Int>(1,2,3,4,5,7,8,9,13)
    val rr = num.filter { it % 2==0 }
    val result= listInt.filter { it % 2==0 }
    println(rr)

    val sqrtEven = evenNumbers.map { sqrt(it.toDouble()) }.toDoubleArray()
    val sqrtOdd = oddNumbers.map { sqrt(it.toDouble()) }.toDoubleArray()

    //println("Even numbers: ${evenNumbers.joinToString()}")
    //println("Square roots of even numbers: ${sqrtEven.joinToString()}")

    //println("Odd numbers: ${oddNumbers.joinToString()}")
    //println("Square roots of odd numbers: ${sqrtOdd.joinToString()}")

    val str = "Hello, World! This is a Kotlin program." // Example string

    val reversedByWords = str.split(" ").reversed().joinToString(" ")

    println("Original string: $str")
    println("String reversed by words: $reversedByWords")

}