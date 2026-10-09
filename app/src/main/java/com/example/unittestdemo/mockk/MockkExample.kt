/**
 * @Author: Created by Sonu Kumar
 * @Date: 02/05/25 11:49 AM.
 * @Email: sonu02@countrydelight.in
 */

package com.example.unittestdemo.mockk


/**
 * Class Definition
 *
 */
class A(private val b: B, private val c: C) {
    fun funToTest() : Int {
        repeat(10) {
            b.funFromB()
        }

        repeat(5) {
            c.funFromC()
        }
        return 5
    }
}

class B {
    fun funFromB(): Int = 10
}

class C {
    fun funFromC(): String = "Hi"
}