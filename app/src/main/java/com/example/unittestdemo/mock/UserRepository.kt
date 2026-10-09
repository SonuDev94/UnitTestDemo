/**
 * @Author: Created by Sonu Kumar
 * @Date: 24/01/25 12:35 PM.
 * @Email: sonu02@countrydelight.in
 */

package com.example.unittestdemo.mock


/**
 * Class Definition
 *
 */
class UserRepository {
    val users = listOf<User>(
        User(1, "abc", "abc@gmai.com", "abcPass"),
        User(2, "mno", "mno@gmai.com", "mnoPass"),
        User(3, "efg", "efg@gmai.com", "efgPass"),
        User(4, "xyz", "xyz@gmai.com", "xyzPass")
    )

    fun loginUser(email: String, password: String): LOGIN_STATUS {
        val users = users.filter { user: User -> user.email == email }
        return if (users.size > 0) {
            if (users[0].password == password) {
                LOGIN_STATUS.SUCCESS
            } else {
                LOGIN_STATUS.INVALID_PASSWORD
            }
        } else {
            LOGIN_STATUS.INVALID_USER
        }

    }
}