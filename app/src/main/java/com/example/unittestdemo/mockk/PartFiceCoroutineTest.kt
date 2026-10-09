/**
 * @Author: Created by Sonu Kumar
 * @Date: 05/05/25 10:37 AM.
 * @Email: sonu02@countrydelight.in
 */

package com.example.unittestdemo.mockk


/**
 * Class Definition
 *
 */

class EightOne {
    suspend fun returnInt() = 10
}

class EightTwo {
    suspend fun returnString() = "SomeString"
}

class Eight(
    private val one: EightOne,
    private val two: EightTwo
) {
    suspend fun funToTest(): String {
        return "${one.returnInt()} ${two.returnString()}"
    }
}