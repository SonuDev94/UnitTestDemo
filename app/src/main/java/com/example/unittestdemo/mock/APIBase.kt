/**
 * @Author: Created by Sonu Kumar
 * @Date: 05/02/25 4:24 PM.
 * @Email: sonu02@countrydelight.in
 */

package com.example.unittestdemo.mock


/**
 * Class Definition
 *
 */
abstract class APIBase {
    abstract fun getUsers(): String?
    abstract fun updateUsers(user: String)
}