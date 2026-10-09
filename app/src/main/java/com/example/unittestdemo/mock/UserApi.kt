/**
 * @Author: Created by Sonu Kumar
 * @Date: 05/02/25 4:01 PM.
 * @Email: sonu02@countrydelight.in
 */

package com.example.unittestdemo.mock


class UserApi : APIBase() {
    var user: String ?= null
    override fun getUsers(): String? {
        return user
    }

    override fun updateUsers(user: String) {
        this.user = user
    }
}


