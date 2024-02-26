package com.example.coroutinesexamples.Programs.StringProgram




/*1) How to find the maximum occurring character in a given String?
// program to return the maximum occurring character in the input string,
e.g., if the input string is "Java" then the function should return 'a'.*/

fun main(args: Array<String>) {
    val str = "Hello world"
    val charCountMap = HashMap<Char, Int>()

    for (c in str) {
        if (charCountMap.containsKey(c)) {
            charCountMap[c] = charCountMap[c]!! + 1
        } else {
            charCountMap[c] = 1
        }
    }

    var maxCount = 0
    var maxChar = ' '

    for (entry in charCountMap.entries) {
        if (entry.value > maxCount) {
            maxCount = entry.value
            maxChar = entry.key
        }
    }

    println("Maximum occurring character is '$maxChar' with count of $maxCount")
}