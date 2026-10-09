/**
 * @Author: Created by Sonu Kumar
 * @Date: 24/01/25 12:33 PM.
 * @Email: sonu02@countrydelight.in
 */

package com.example.unittestdemo.mock


/**
 * Class Definition
 *
 */
data class User(
    val id: Int,
    val name: String,
    val email: String,
    val password: String
)

enum class LOGIN_STATUS {
    INVALID_USER,
    INVALID_PASSWORD,
    UNKNOWN_ERROR,
    SUCCESS
}