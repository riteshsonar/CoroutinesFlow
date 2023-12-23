package com.example.coroutinesexamples.KoltinTutorial

fun main(){
    val mustang= Car("mustang","petrol",120)
    println(mustang.name)
    mustang.driveCar()
}
class Car(val name:String,val type:String,var  kmRun:Int)//Properties
{
    fun driveCar(){ //methods
        println("Car is driving")
    }
    fun applyBrakes(){
        println("Applied Brakes")
    }
}