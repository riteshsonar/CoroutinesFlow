package com.example.coroutinesexamples.Programs

/*fun main(){
    val str1= "This is my first class"
    val result = str1.split(" ").reversed().joinToString(" ")
    println("Reverse is : $result")
}*/

inline fun performOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

fun main() {
    val result = performOperation(5, 3) { x, y -> x + y }
    println("Result: $result")
}
