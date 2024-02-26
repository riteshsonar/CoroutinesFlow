package com.example.coroutinesexamples.Programs

class Helper{
    fun isPallindrome(input :String):Boolean{
        var i=0
        var j= input.length-1
        var result= true

        while (i<j){
            if (input[i] != input[j]){
                result = false
            }
            i++
            j--
        }
        return result
    }
}