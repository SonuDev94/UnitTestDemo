package com.example.unittestdemo.mockk

import io.mockk.mockk

/**
 * @Author: Created by Sonu Kumar
 * @Date: 05/05/25 10:42 AM.
 * @Email: sonu02@countrydelight.in
 */
class EightTest {
    private val one: EightOne = mockk()
    private val two: EightTwo = mockk()
    private val eight = Eight(one, two)

//    @Test
//    fun `should return 10 SomeString`() = runTest {
//        coEvery { one.returnInt() } returns 10
//        coEvery { two.returnString() } returns "SomeString"
//        val result = eight.funToTest()
//        assertEquals("10 SomeString", result)
//        coVerify { one.returnInt() }
//    }
}