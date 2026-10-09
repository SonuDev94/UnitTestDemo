/**
 * @Author: Created by Sonu Kumar
 * @Date: 24/01/25 12:43 PM.
 * @Email: sonu02@countrydelight.in
 */

package com.example.unittestdemo.mock


/**
 * Class Definition
 *
 */
class UserService(private val userRepository: UserRepository, private val mailRepository: MailRepository) {
    fun loginUser(email: String, password: String): String {
        val status = userRepository.loginUser(email, password)
        return when (status) {
            LOGIN_STATUS.INVALID_USER -> "User does not exist"
            LOGIN_STATUS.INVALID_PASSWORD -> "Password is wrong"
            LOGIN_STATUS.UNKNOWN_ERROR -> "Unknown error occurred"
            LOGIN_STATUS.SUCCESS -> "Login Successfully"
        }
    }

    fun sendEmail(to: String, subject: String, body: String) {
        mailRepository.sendEmail(to, subject, body)
    }
}