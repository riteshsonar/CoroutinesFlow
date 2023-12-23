package com.example.coroutinesexamples.KoltinTutorial

fun main(){
   /* val circle:Circle = Circle(4.0)
    val square: Square = Square(4.0)
    println(circle.area())
    println(square.area())*/

    //parent can hold reference to it's child
    // parent can call methods of child class (which are common)
    val circle:Shape = Circle(4.0)
    val square: Shape = Square(4.0)
    println(circle.area())
    println(square.area())

    val shapes= arrayOf(Circle(3.0),Circle(4.0),Square(3.4))
    calculateAreas(shapes)

}

fun calculateAreas(shape: Array<Shape>){
    for (shape in shape){
        println(shape.area())
    }
}
open class Shape{
    open fun area():Double{
        return 0.0
    }
}
class Circle(val radius: Double): Shape() {
    override fun area(): Double {
        return Math.PI * radius * radius
    }
}

class Square(val side:Double):Shape(){
    override fun area(): Double {
        return side * side
    }
}