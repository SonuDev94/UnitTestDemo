/**
 * @Author: Created by Sonu Kumar
 * @Date: 23/01/25 3:42 PM.
 * @Email: sonu02@countrydelight.in
 */

package com.example.unittestdemo.room

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.unittestdemo.instrumenttest.getOrAwaitValue
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test


/**
 * Class Definition
 *
 */
class QuotesDaoTest {
    lateinit var quoteDatabase: QuoteDatabase
    lateinit var quotesDao: QuotesDao

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        quoteDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(), QuoteDatabase::class.java
        ).allowMainThreadQueries().build()
        quotesDao = quoteDatabase.quoteDao()
        println("Setup")
    }

    @Test
    fun insertQuote_expectedSingleQuote() = runBlocking {
        println("insertQuote_expectedSingleQuote")
        val quote = Quote(1, "this is test code", "Sonu Kumar")
        quotesDao.insertQuote(quote)
        val result = quotesDao.getQuotes()
        Assert.assertEquals(1, result.size)
        Assert.assertEquals("Sonu Kumar",result[0].author)
    }

    @Test
    fun deleteQuote_expected0Quote() = runBlocking {
        println("deleteQuote_expected0Quote")
        val quote = Quote(1, "this is test code", "Menka Davi")
        quotesDao.insertQuote(quote)
        val result = quotesDao.getAllQuotes().getOrAwaitValue()
        Assert.assertEquals(1, result.size)
        quotesDao.delete()
        val result2 = quotesDao.getQuotes()
        Assert.assertEquals(0, result2.size)
    }

    @After
    fun tearDown() {
        quoteDatabase.close()
    }

}
object Operators {
   fun add(m: Int, n: Int): Int = m + n
   fun subtract(n: Int, m: Int): Int = n - m
   fun multiply(c: Int, a: Int): Int = c * a
   fun divide(l: Int, d: Int): Int = l / d
}

class GfGCalculator(private val operators: Operators) {
    fun addTwoNumbers(ab: Int, ba: Int): Int = operators.add(ab, ba)
    fun subtractTwoNumbers(ac: Int, bc: Int): Int = operators.subtract(ac, bc)
    fun multiplyTwoNumbers(ad: Int, bd: Int): Int = operators.multiply(ad, bd)
    fun divideTwoNumbers(aa: Int, ba: Int): Int = operators.divide(aa, ba)
}