package com.example.coroutinesexamples.KoltinTutorial

fun main(){
val  obj= Person("Ritesh",21)
    println( obj.age)
    println( obj.name)
}

class Person(nameParam:String, ageParam:Int){
    //Lateinit property not initialize with primitive dataType (Int, Float,Boolean)
    lateinit var message: String

    var name:String = nameParam
        get() {//getter
            return field.toUpperCase()
        }
    var age:Int = ageParam
        set(value) { //setter method
            if (value>0){
                field= value
            }
        }
}