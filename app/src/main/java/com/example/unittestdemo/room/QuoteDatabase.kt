/**
 * @Author: Created by Sonu Kumar
 * @Date: 23/01/25 3:32 PM.
 * @Email: sonu02@countrydelight.in
 */

package com.example.unittestdemo.room

import androidx.room.Database
import androidx.room.RoomDatabase


/**
 * Class Definition
 *
 */
@Database(entities = [Quote::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {
    abstract fun quoteDao(): QuotesDao
}