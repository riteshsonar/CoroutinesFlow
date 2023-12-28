package com.example.coroutinesexamples.Programs

fun main(){
    val num = listOf<Int>(1,2,3,4,5,6,7,8,9)
    val list = num.filter { it % 2 == 0 }
    println("Even num is $list")

    //Example 2
    val userList = listOf<User>(User(1 , "A"),User(2 , "B"),
        User(3 , "C"),User(4 , "D"),User(5 , "E"))

    println(userList.filter { it.id ==2 })// you can filter by name as well Power if Higher Oder function:-
                                            // Just pass the filter function

    //Map :- one form of data convert into another form
    val list1 = num.map { it * it }
    println("another form is $list1")
    val paidUserList = userList.map { PaidUser(it.id,it.name,"Paid") }
    println("User class convert into PaidUser class:- $paidUserList")

    // forEach :- add loop on a list
    num.forEach { println(it) }
}

data class User(val id:Int , val name : String)
data class PaidUser(val id:Int , val name : String,val type: String)