package com.example.coroutinesexamples.KoltinTutorial

fun main(){
     val p1= Personal(1,"John")
     val p2= Personal(1,"John")

    println(p1)
    println(p2)
    println(p1.hashCode())
    println(p1==p2)// flase if we are using data class then it's true

    val p3= Personal1(1,"John")
    val p4= p3.copy(id = 4)
    println(p4)
    val (id,name) = p3
    println(id)
    println(name)
}

class Personal(val id:Int , val name:String){

}
data class Personal1(val id: Int,val name: String){

}