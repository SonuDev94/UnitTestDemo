package com.example.unittestdemo.mockk

import com.example.unittestdemo.mock.LOGIN_STATUS
import com.example.unittestdemo.mock.MailRepository
import com.example.unittestdemo.mock.UserRepository
import com.example.unittestdemo.mock.UserService
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * @Author: Created by Sonu Kumar
 * @Date: 01/05/25 2:09 PM.
 * @Email: sonu02@countrydelight.in
 */

//@ExtendWith(MockExtension::class) is Part of Junit 5. So if we want to use annotation rather than manual , use MockKAnnotations.init(this)
class UserServiceMockkAnotationTest {
    @MockK
    lateinit var userRepository: UserRepository
    @MockK
    lateinit var mailRepository: MailRepository

    lateinit var userService: UserService

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        userService = UserService(userRepository,mailRepository)
    }

//If any function not returning any value then define just runs

    @Test
    fun `login user and return success`() {
        every { userRepository.loginUser(any(), any()) } returns LOGIN_STATUS.SUCCESS
        val result = userService.loginUser("abc@gmai.com", "abcPass")
        assertEquals("Login Successfully", result)
        verify { userRepository.loginUser("abc@gmai.com", "abcPass") }
    }

    @Test
    fun `login invalid user and return invalid user`() {
        every { userRepository.loginUser(any(), any()) } answers { LOGIN_STATUS.INVALID_USER } // in place or returns we can use answers
        val result = userService.loginUser("amb@gmai.com", "abcPass")
        assertEquals("User does not exist", result)
        verify { userRepository.loginUser("amb@gmai.com", "abcPass") }
    }

}