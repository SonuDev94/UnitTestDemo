package com.example.unittestdemo.unittest

import com.example.unittestdemo.mock.UserApi
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner

/**
 * @Author: Created by Sonu Kumar
 * @Date: 05/02/25 4:14 PM.
 * @Email: sonu02@countrydelight.in
 */
@RunWith(MockitoJUnitRunner::class)
class APIBaseTest {
//    @Mock creates a fake object and does not execute real methods. If you must use @Mock, then you need to stub methods manually.
//    @Spy creates a partial mock that calls real methods unless explicitly stubbed.

    @Spy
    lateinit var spyUserApi: UserApi

    @Mock
    lateinit var mockUserApi: UserApi

    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun testSpyUser_updateRealMethod() {
        val user = spyUserApi.getUsers()
        Assert.assertEquals(null, user)
        spyUserApi.updateUsers("Sonu")
        val newUser = spyUserApi.getUsers()
        Assert.assertEquals("Sonu", newUser)
    }

    @Test
    fun testMockUser_stubMethod() {
        Mockito.`when`(mockUserApi.getUsers()).thenReturn(null)
        val user = mockUserApi.getUsers()
        Assert.assertEquals(null, user)

        Mockito.doAnswer { invocation ->
            val arg = invocation.arguments[0] as String
            Mockito.`when`(mockUserApi.getUsers()).thenReturn(arg)
            null
        }.`when`(mockUserApi).updateUsers(anyString())
//        Mockito.`when`(mockUserApi.updateUsers(anyString())).thenReturn("Sonu")
        mockUserApi.updateUsers("Sonu")
        val newUser = mockUserApi.getUsers()
        Assert.assertEquals("Sonu", newUser)
    }


}