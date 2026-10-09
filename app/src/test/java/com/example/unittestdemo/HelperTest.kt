/**
 * @Author: Created by Sonu Kumar
 * @Date: 20/01/25 2:38 PM.
 * @Email: sonu02@countrydelight.in
 */

package com.example.unittestdemo

import com.example.unittestdemo.unittest.Helper
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


/**
 * Class Definition
 *
 */
class HelperTest {
    private lateinit var helper: Helper

    @Before
    fun setUp() {
        //Arrange
        helper = Helper()
        println("Before Every Test")
    }

    @After
    fun onLast() {
        println("Last Every Test")
    }

    @Test
    fun isPallindromExpectedFalse() {
        println("isPallindromExpectedFalse")

        //Act
        val result = helper.isPallindrome("hello")

        //Assert
        assertEquals(false, result)
    }

    @Test
    fun isPallindromExpectedTrue() {
        println("isPallindromExpectedTrue")

        //Act
        val result = helper.isPallindrome("LEVEL")

        //Assert
        assertEquals(true, result)
    }

    @Test
    fun passwordNullOrEmptyTest() {
        val msg = helper.isPasswordValid(null)
        assertEquals("Password is required", msg)
    }

    @Test
    fun passwordLengthFailedDueToLessThan5CharTest() {
        val msg = helper.isPasswordValid("askjd")
        assertEquals("Length of password greater than 5 character", msg)
    }

    @Test
    fun passwordLengthFailedDueToGreaterThan5CharTest() {
        val msg = helper.isPasswordValid("askjd2394872398492387jh")
        assertEquals("Length of password less than 15 character", msg)
    }

    @Test
    fun passwordValidTest() {
        val msg = helper.isPasswordValid("askjd2jdh")
        assertEquals("Valid", msg)
    }

    @Test(expected = NullPointerException::class)
    fun reverseString_nullEmptyInput_expectedException(){
        helper.reverseString(null)
    }

    @Test
    fun reverseString_asInput(){
       val res= helper.reverseString("Prayagraj")
        assertEquals("jargayarP",res)
    }

    @Test
    fun reverseString_singleInput(){
        val res= helper.reverseString("a")
        assertEquals("a",res)
    }
}