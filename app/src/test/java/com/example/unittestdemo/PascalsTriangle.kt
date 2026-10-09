/**
 * @Author: Created by Sonu Kumar
 * @Date: 14/01/25 3:41 PM.
 * @Email: sonu02@countrydelight.in
 */

package com.example.unittestdemo

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


/**
 * Class Definition
 *
 */
internal class PascalsTriangle {
    fun triangleRow(n: Int): List<Int> {
        if (n<0){
            throw IllegalArgumentException("Negative Number not allowed")
        }
        if (n == 0) {
            return mutableListOf(1)
        }

        val previousRow = triangleRow(n - 1)

        val row = ArrayList<Int>()
        row.add(1)
        for (col in 1 until n) {
            row.add(previousRow[col - 1] + previousRow[col])
        }
        row.add(1)

        return row
    }
}

fun main(){


    var temp=1
    CoroutineScope(Dispatchers.IO).launch {
        temp=temp+1
        println(temp)
    }

    CoroutineScope(Dispatchers.IO).launch {
        temp=temp+1
        println(temp)
    }

    CoroutineScope(Dispatchers.IO).launch {
        temp=temp+1
        println(temp)
    }



}
