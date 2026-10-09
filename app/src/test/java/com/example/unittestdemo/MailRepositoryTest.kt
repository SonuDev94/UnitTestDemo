/**
 * @Author: Created by Sonu Kumar
 * @Date: 20/01/25 12:36 PM.
 * @Email: sonu02@countrydelight.in
 */

package com.example.unittestdemo

import com.example.unittestdemo.unittest.Calculator
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`


/**
 * Class Definition
 *
 */
class MailRepositoryTest {
    private lateinit var calculator: Calculator

    @Before
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun addition_of_two_numbers_returns_correct_result() {
        val result = calculator.add(5, 3)
        assertEquals(8, result)
    }

    @Test
    fun `subtraction of two numbers returns correct result`() {
        val result = calculator.subtract(10, 4)
        assertEquals(6, result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `division by zero throws exception`() {
        val result = calculator.divide(5, 0)
    }


    @Test
    fun `mocking a dependency example`() {
        val mockList: MutableList<String> = mock(MutableList::class.java) as MutableList<String>
        `when`(mockList.size).thenReturn(15)

        assertEquals(15, mockList.size)
    }
}