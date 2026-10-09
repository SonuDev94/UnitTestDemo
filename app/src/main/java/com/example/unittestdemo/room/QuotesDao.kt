/**
 * @Author: Created by Sonu Kumar
 * @Date: 23/01/25 2:52 PM.
 * @Email: sonu02@countrydelight.in
 */

package com.example.unittestdemo.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


/**
 * Class Definition
 *
 */
@Dao
interface QuotesDao {
    @Insert
    suspend fun insertQuote(quote: Quote)

    @Update
    suspend fun updateQuote(quote: Quote)

    @Query("DELETE from quote")
    suspend fun delete()

    @Query("SELECT * from quote")
    suspend fun getQuotes(): List<Quote>

    @Query("SELECT * from quote")
    fun getAllQuotes(): LiveData<List<Quote>>

    @Query("SELECT * from quote where id = :quoteId")
    suspend fun getQuoteById(quoteId: Int): Quote
}