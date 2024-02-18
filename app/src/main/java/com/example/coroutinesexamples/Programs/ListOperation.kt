package com.example.coroutinesexamples.Programs

import com.example.coroutinesexamples.Student

fun main() {

    val list1 = listOf(Student("1", "name1"), Student("2", "name2"))
    val list2 = listOf(Student("1", "name1"), Student("2", "name2"), Student("3", "name2"))

    val difference = list2.toSet().minus(list1.toSet())
    println(difference)

}

