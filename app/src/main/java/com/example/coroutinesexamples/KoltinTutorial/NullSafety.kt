package com.example.coroutinesexamples.KoltinTutorial

fun main(){
    var gender:String= "Male"
    var  gender2: String? = null

    gender2?.toUpperCase()

    gender2?.let {
        println("Line 1 $gender2")
    }
    var selectedValue= gender2 ?: "NA"
    var value = gender2!! .toUpperCase() //not null asserted operator
}