/**
 * @Author: Created by Sonu Kumar
 * @Date: 23/01/25 2:33 PM.
 * @Email: sonu02@countrydelight.in
 */

package com.example.unittestdemo.room

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Class Definition
 *
 */
@Entity
data class Quote(@PrimaryKey val id: Int, val text: String, val author: String)