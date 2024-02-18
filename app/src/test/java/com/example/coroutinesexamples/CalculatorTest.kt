package com.example.coroutinesexamples

import com.example.coroutinesexamples.Programs.Calculator
import org.junit.Assert
import org.junit.Test


class CalculatorTest {
    @Test
    fun testAdd() {
        val calculator = Calculator()
        val result = calculator.add(2, 3)
        Assert.assertEquals(5, result.toLong())
    }

    @Test
    fun testSubtract() {
        val calculator = Calculator()
        val result = calculator.subtract(5, 2)
        Assert.assertEquals(3, result.toLong())
    }
}
