/**
 * @Author: Created by Sonu Kumar
 * @Date: 01/05/25 12:29 PM.
 * @Email: sonu02@countrydelight.in
 */

package com.example.unittestdemo.mock


/**
 * Class Definition
 *
 */
class MailRepository {
    fun sendEmail(to:String, subject: String, body : String){
        println("Mail has sent to $to ,$subject, $body ")
    }
}