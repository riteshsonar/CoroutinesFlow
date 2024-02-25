package com.example.coroutinesexamples.Programs

fun main(){
    val arr1= listOf<String>("sam12","ritesh1","manish32","ajay9","shaym143")
    val sorted= arr1.sortedBy { extractNumericValue(it) }
    println("Soretd: $sorted")
}

fun  extractNumericValue(str:String): Int? {

val numericPart = str.filter{it.isDigit()}
    return numericPart.toIntOrNull() ?: 0
}

