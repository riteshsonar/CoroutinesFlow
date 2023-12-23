package com.example.coroutinesexamples.KoltinTutorial

fun main(){
    val oneplus= OnePlus("SmartPhone")
    oneplus.display()

}
open class  Mobile(val type:String){
    open val name : String=""
    open val size:Int = 5
    fun makeCall()= println("Calling from mobile")
    fun powerOff()= println("shutting Down")
    open fun display()= println("Simple Mobile Display")
}

//Any :- Any is a root class of Parent class
class OnePlus(typeParam:String) : Mobile(typeParam){
    override val name: String
        get() = "One Plus"
    override fun display()
    { super.display()
        println( "One Plus Display")
    }

    override fun toString(): String {
        return "OnePlus(name='$name')"
    }


}