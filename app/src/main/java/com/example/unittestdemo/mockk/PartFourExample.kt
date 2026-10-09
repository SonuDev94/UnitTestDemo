/**
 * @Author: Created by Sonu Kumar
 * @Date: 05/05/25 10:11 AM.
 * @Email: sonu02@countrydelight.in
 */

package com.example.unittestdemo.mockk


/**
 * Class Definition
 *
 */
class Five(val one: FiveOne) {
    fun funToTest(): String {
        one.returningInt()
        return one.returningString()
    }
}

class FiveOne {
    fun returningInt() = 10
    fun returningString() = "Hello"
}