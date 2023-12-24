package com.example.coroutinesexamples.KoltinTutorial

fun main(){
val day = Day.SUNDAY
    day.printFormattedDay()
    println(day)
    println(day.number)

    for (i in Day.values()){
        println(i)
    }
}
 enum class Day(val number: Int){
     SUNDAY(1),
     MONDAY(2),
     TUESDAY(3),
     WEDNESDAY(4),
     THURSDAY(5),
     FRIDAY(6),
     SATURDAY(7);

     fun printFormattedDay(){
         println("Day is $this")
     }
 }

//Sealed class  class is a special type of class that allows you to restrict the inheritance hierarchy of a class hierarchy.
// It's useful when you want to define a restricted type hierarchy where all the subclasses are known
// and limited within the same file or module.
sealed class Tile
class Red(val  type:String,val point:Int):Tile()
class Blue(val  point: Int):Tile()