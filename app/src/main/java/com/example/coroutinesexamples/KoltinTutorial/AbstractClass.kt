package com.example.coroutinesexamples.KoltinTutorial

fun main(){
    val shape= Circled(4.0)
    println(shape.area())
    shape.display()

}
abstract class Shaped{
    var name :String= ""
   abstract fun area():Double
    fun display() = println("Shape is getting displayed")
}
class Circled(val radius:Double) : Shaped(){
    override fun area():Double = Math.PI * radius * radius
}