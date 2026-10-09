/**
 * @Author: Created by Sonu Kumar
 * @Date: 20/01/25 12:37 PM.
 * @Email: sonu02@countrydelight.in
 */

package com.example.unittestdemo.unittest


/**
 * Class Definition
 *
 */
class Calculator {
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    fun subtract(a: Int, b: Int): Int {
        return a - b
    }

    fun divide(a: Int, b: Int): Int {
        if (b == 0) throw IllegalArgumentException("Cannot divide by zero")
        return a / b
    }
}