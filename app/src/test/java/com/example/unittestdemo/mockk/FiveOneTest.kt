package com.example.unittestdemo.mockk

import io.mockk.every
import io.mockk.spyk
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @Author: Created by Sonu Kumar
 * @Date: 05/05/25 10:14 AM.
 * @Email: sonu02@countrydelight.in
 */
class FiveOneTest {
    //    val fiveOne: FiveOne = mockk(relaxed = true)
    val fiveOne: FiveOne = spyk()
    val five = Five(fiveOne)

    @Test
    fun `should return mockk string`() {
//        every { fiveOne.returningInt() } returns 5
        every { fiveOne.returningString() } answers { "Hello1" }
        val result = five.funToTest()
        assertEquals("Hello1", result)
    }
}