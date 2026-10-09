/**
 * @Author: Created by Sonu Kumar
 * @Date: 02/05/25 1:11 PM.
 * @Email: sonu02@countrydelight.in
 */

package com.example.unittestdemo.mockk

import java.util.UUID


/**
 * Class Definition
 *
 */
// Object Level test
object SomeObject {
    fun generateId() = UUID.randomUUID().toString()
}

class SomeOne {
    fun funTest(): String = SomeObject.generateId()
}

// for top level function test
class SomeTwo {
    fun funToTest() = getGeneratedId()
}

fun getGeneratedId() = UUID.randomUUID().toString()

// Extension function test
class SomeThree {
    fun funToTest() = "abc".withCustomCase()
}

fun String.withCustomCase() = this.uppercase()