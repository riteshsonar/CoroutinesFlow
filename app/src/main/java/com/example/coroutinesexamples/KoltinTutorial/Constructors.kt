package com.example.coroutinesexamples.KoltinTutorial

fun main(){
    var car = Automobile("car",4,6,true)
    var car2 = Automobile("car2")
}

//Primary constructor:-
class Automobile(val name:String, val tyres:Int, val  maxSetting:Int, hasAirBags: Boolean){ //2 property one parameter
    //if you are use val or val in function then it create it's property other wise it create only parameter
    val hasAir=hasAirBags

    /*Secondary constructor:- secondary constructor is created by using the keyword constructor. It is used to initialize
    a group of values. in kotlin a single class can have more then one secondary constructor*/
    constructor(nameParam:String):this(nameParam,4,5,true)//when we want to pass different value in first constructor
    fun drive(){}
    fun applyBrakes(){}
}