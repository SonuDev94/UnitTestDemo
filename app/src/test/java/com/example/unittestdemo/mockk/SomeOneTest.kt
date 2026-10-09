package com.example.unittestdemo.mockk

import io.mockk.every
import io.mockk.mockkObject
import io.mockk.mockkStatic
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @Author: Created by Sonu Kumar
 * @Date: 02/05/25 1:26 PM.
 * @Email: sonu02@countrydelight.in
 */
class SomeOneTest {
    private val one = SomeOne()

    private val two = SomeTwo()

    private val three = SomeThree()

    @Test
    fun `should return mocked ID`() {
        val id = "randomId"
        mockkObject(SomeObject)
        every { SomeObject.generateId() } returns id
        val result = one.funTest()
        assertEquals(id, result)

//        unmockkObject(SomeObject)
//        assertEquals(id,one.funTest())
    }


    @Test
    fun `top level function test, should return generated ID from class SomeTwo`() {
        val id = "randomID"
        mockkStatic(::getGeneratedId)
        every { getGeneratedId() } returns id
        val result = two.funToTest()
        assertEquals(id, result)
    }

    @Test
    fun `extension function test, should return mocked value`() {
        val id = "customId"
        mockkStatic(String::withCustomCase)
        every { "abc".withCustomCase() } returns id
        val result = three.funToTest()

        assertEquals(id, result)
    }
}