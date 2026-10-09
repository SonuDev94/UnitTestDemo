/**
 * @Author: Created by Sonu Kumar
 * @Date: 02/05/25 11:53 AM.
 * @Email: sonu02@countrydelight.in
 */

package com.example.unittestdemo.mockk

import io.mockk.checkUnnecessaryStub
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.mockk.verifyAll
import io.mockk.verifyCount
import io.mockk.verifyOrder
import io.mockk.verifySequence
import org.junit.Assert.assertEquals
import org.junit.Test


/**
 * Class Definition
 *
 */
class ATest {
    private val b: B = mockk()
    private val c: C = mockk()
    private val a: A = A(b, c)

    @Test
    fun `should return 5`() {
        every { b.funFromB() } returns 1
        every { c.funFromC() } returns ""
        val result = a.funToTest()

        assertEquals(5, result)
        verify { b.funFromB() }
        verify(atLeast = 8) { b.funFromB() }
        verify(atMost = 10) { b.funFromB() }
        verify(exactly = 5) { c.funFromC() }

        verifyAll {
            b.funFromB()
            c.funFromC()
        }

        verifyOrder {
            b.funFromB()
            c.funFromC()
        }

        verifySequence {
            repeat(10) { b.funFromB() }
//            repeat(5) { c.funFromC() }
        }
        verifyCount {
            10 * {
                b.funFromB()
            }
            (1..9) * { c.funFromC() }
        }
        confirmVerified(b, c)
        checkUnnecessaryStub(b, c)

    }
}