package com.example.coroutinesexamples.KoltinTutorial

fun main(){
    SharingWidget.incrementTwitterLikes()
    SharingWidget.incrementTwitterLikes()
    SharingWidget.incrementTwitterLikes()
    SharingWidget.incrementFBLikes()
    SharingWidget.display()

    //Annominus object
    var testObj= object {
        val  x:Int = 10
    }
    println(testObj.x)

    var obj= object :Cloneable{
        override fun clone() {
            println("I an clone")
        }

    }
}

interface Cloneable{
    fun clone()
}
object SharingWidget{
    private var twitterLikes= 0
    private var fbLikes = 0

    fun incrementTwitterLikes() = twitterLikes++
    fun incrementFBLikes() = fbLikes++
    fun display() = println("Facebook - $fbLikes -- Twitter - $twitterLikes")
}