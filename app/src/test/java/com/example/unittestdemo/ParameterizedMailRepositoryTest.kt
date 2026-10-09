/**
 * @Author: Created by Sonu Kumar
 * @Date: 20/01/25 1:20 PM.
 * @Email: sonu02@countrydelight.in
 */

package com.example.unittestdemo

import com.example.unittestdemo.unittest.Calculator
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters


/**
 * Class Definition
 *
 */
@RunWith(Parameterized::class)
class ParameterizedMailRepositoryTest(val inputA : Int, val inputB: Int, val expected: Int) {
    private lateinit var calculator: Calculator


    companion object{
        @JvmStatic
        @Parameters
        fun data()  =
            listOf(arrayOf(1,1,2),arrayOf(5,3,8),arrayOf(6,14,20))
    }

    @Before
    fun setUp(){
        calculator=Calculator()
    }


    @Test
    fun `test addition with parameters`() {
        assertEquals(expected, calculator.add(inputA, inputB))
    }
}