/**
 * @Author: Created by Sonu Kumar
 * @Date: 26/12/24 12:13 PM.
 * @Email: sonu02@countrydelight.in
 */

package com.example.unittestdemo.ui.theme

import java.math.BigDecimal
import java.math.RoundingMode
import java.text.NumberFormat


/**
 * format price for display,the [price] should be in cent
 *
 */

fun main() {
    println(Currency.INR.toString(100))
//    formatNumDemo()
}

fun formatPrice(price: Long): String {
    if (price < 0) {
        throw IllegalArgumentException("Price must not be negative")
    }
    return NumberFormat.getInstance().format(BigDecimal(price).movePointLeft(2))
}

enum class Currency(val code: String, val symbol: String) {
    USD("USD", "$"),
    EUR("EUR", "€"),
    GBP("GBP", "£"),
    INR("INR", "₹"),

    // ... add more currencies here
    JPY("JPY", "¥"),
    CAD("CAD", "$") // Canadian Dollar
    // ...
}

fun Currency.toString(price: Long): String {
    return when (this){
        Currency.USD -> "$" + formatPrice(price)
        Currency.EUR -> "€" + formatPrice(price)
        Currency.GBP -> "£" + formatPrice(price)
        Currency.INR -> "₹" + formatPrice(price)
        Currency.JPY -> "¥" + formatPrice(price)
        Currency.CAD -> "$" + formatPrice(price)

    }
}


fun formatNumDemo() {
    val numInstance = NumberFormat.getInstance()
    numInstance.minimumFractionDigits = 2
    numInstance.maximumFractionDigits = 2
    numInstance.roundingMode = RoundingMode.DOWN
    val value = numInstance.format(12349.60777)
    println("Number: $value")
//    println ("Number Format: ${NumberFormat.getNumberInstance().format(1234878980000000009)}")
//    println ("Currency Format: ${NumberFormat.getCurrencyInstance(Locale.US).format(1234878980000000009)}")
//    val fraction = 0.86
//    println ("Percentage Format: ${NumberFormat.getNumberInstance(Locale.US).format(fraction)}")
//    println ("Local Number Format: ${NumberFormat.getNumberInstance(Locale.UK).format(1234878980000000009)}")
}
