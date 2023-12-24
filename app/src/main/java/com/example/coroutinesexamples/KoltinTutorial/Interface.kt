package com.example.coroutinesexamples.KoltinTutorial

import java.util.Objects

fun main(){
    dragObjects(arrayOf(Circlee(4.0),Squared(4.0),Triangle(2.0,3.0),Player("Smiley ")))
}
fun dragObjects(objects: Array<Draggable>){
    for (obj in objects){
        obj.drag()
    }
}
interface  Draggable{
    fun drag()
}
abstract class Sha: Draggable{
   abstract fun area():Double
}
class Circlee(val radius:Double):Sha(){
    override fun area(): Double = Math.PI * radius * radius
    override fun drag() = println("Circle is dragging")
}
class Squared(val side:Double):Sha(){
    override fun area(): Double = side * side
    override fun drag() = println("Square is dragging")
}
class Triangle(val base:Double, val height:Double):Sha(){
    override fun area(): Double = 0.5 * base * height
    override fun drag() = println("Triangle is dragging")
}
class Player(val name:String): Draggable{
   override fun drag()= println("$name is dragging")
}