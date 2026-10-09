/**
 * @Author: Created by Sonu Kumar
 * @Date: 20/01/25 2:56 PM.
 * @Email: sonu02@countrydelight.in
 */

package com.example.unittestdemo

import com.example.unittestdemo.unittest.Helper
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters


/**
 * Class Definition
 *
 */
@RunWith(value = Parameterized::class)
class HelperParameterizedTest(val inputString: String, val expected: Boolean) {

    companion object {
        @JvmStatic
        @Parameters(name = "{index} : {0} is Pallindrom {1}")
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("akj", false),
                arrayOf("AjajA", true),
                arrayOf("Spnu", false),
                arrayOf("", true),
                arrayOf("a", true)
            )
        }
    }

    @Test
    fun testHelperPallindrom() {
        val helper = Helper()
        val result = helper.isPallindrome(inputString)
        assertEquals(expected, result)
    }
}