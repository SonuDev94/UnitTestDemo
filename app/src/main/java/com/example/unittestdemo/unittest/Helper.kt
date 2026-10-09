/**
 * @Author: Created by Sonu Kumar
 * @Date: 20/01/25 2:27 PM.
 * @Email: sonu02@countrydelight.in
 */

package com.example.unittestdemo.unittest

import kotlin.reflect.KClass


/**
 * Class Definition
 *
 */
class Helper {

    fun isPallindrome(input: String): Boolean {
        var i = 0
        var j = input.length - 1
        var result = true
        while (i < j) {
            if (input[i] != input[j]) {
                result = false
                break
            }
            i++
            j--
        }
        return result
    }

    fun isPasswordValid(password: String?): String {
        if (password.isNullOrEmpty()) {
            return "Password is required"
        } else if (password.length < 6) {
            return "Length of password greater than 5 character"
        } else if (password.length > 15) {
            return "Length of password less than 15 character"
        }
        return "Valid"
    }



     fun reverseString(string: String?): String {
        if (string==null){
            throw NullPointerException("Input should not null")
        }
        val chars = string.toCharArray()
        var i = 0
        var j = chars.size - 1
        while (i < j) {
            val temp = chars[i]
            chars[i] = chars[j]
            chars[j] = temp
            i++
            j--
        }
        return chars.joinToString("")
    }
}

class Test {
    fun mTest(test: JaVaTest) {
        println("Hello MTest")
    }

    fun mTest2(test: Test) {
        println("mTest2")
    }

    fun greeting(message: String) {
        println(message)
    }

    fun javaTest2(java: Class<*>) {
    }

    fun javaTest2(kClass: KClass<*>) {
    }

    fun mainTest() {
        javaTest2(JaVaTest::class)
        javaTest2(JaVaTest::class.java)


        val jaVaTest = JaVaTest()
        jaVaTest.javaTest2(JaVaTest::class)
        jaVaTest.javaTest2(Test::class)

        val jTest = JaVaTest::class.java
        jTest.declaredMethods.forEach {
            println(it.name)
        }


    }

    fun reflectionTest() {
        val test = Test::class.java
//        test.declaredMethods.forEach {
//            println(it.name)
//        }

        val testInstance = test.getConstructor().newInstance()
        val testMethod = test.getMethod("mTest2", Test::class.java)
        testMethod.invoke(testInstance, testInstance)

        val greetingMethod = test.getMethod("greeting", String::class.java)
        greetingMethod.invoke(testInstance, "Hello Reflection")
    }
}

fun main() {
    Test().reflectionTest()
}

interface TesA
