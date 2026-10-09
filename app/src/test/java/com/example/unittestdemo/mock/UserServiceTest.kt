package com.example.unittestdemo.mock

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


/**
 * @Author: Created by Sonu Kumar
 * @Date: 24/01/25 12:48 PM.
 * @Email: sonu02@countrydelight.in
 */
@RunWith(MockitoJUnitRunner::class)
class UserServiceTest {
    @Mock
    lateinit var userRepository: UserRepository

    @Mock
    lateinit var mailRepository: MailRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Mockito.`when`(userRepository.loginUser(anyString(), anyString())).thenReturn(LOGIN_STATUS.INVALID_USER)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun loginUser() {
        val userService = UserService(userRepository,mailRepository)
        val response = userService.loginUser("abc@gmail.com", "abcPass")
        println("Response->$response")
        Assert.assertEquals("User does not exist", response)
//        verify(userRepository).loginUser("abc@gmail.com", "abcPass")

    }
}