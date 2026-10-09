/**
 * @Author: Created by Sonu Kumar
 * @Date: 01/05/25 12:31 PM.
 * @Email: sonu02@countrydelight.in
 */

package com.example.unittestdemo.mockk

import android.util.Log
import com.example.unittestdemo.mock.LOGIN_STATUS
import com.example.unittestdemo.mock.MailRepository
import com.example.unittestdemo.mock.UserRepository
import com.example.unittestdemo.mock.UserService
import io.mockk.every
import io.mockk.just
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.runs
import io.mockk.slot
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Test


/**
 * Class Definition
 *
 */
class UserServiceMockkTest {
    private val userRepository: UserRepository = mockk()
    private val mailRepository = mockk<MailRepository>()
    private var userService: UserService = UserService(userRepository, mailRepository)


    @Test
    fun `login user and return success`() {
        every { userRepository.loginUser(any(), any()) } returns LOGIN_STATUS.SUCCESS

        every {
            mailRepository.sendEmail(
                "abc@gmai.com",
                "Test",
                "Welcome Test Mail Message."
            )
        } just runs //If any function not returning any value then define just runs
        every { mailRepository.sendEmail("abc@gmai.com", "Test", "Welcome Test Mail Message.") } returns Unit // If any function not returning any value then
        // define can use return Units
        every {
            mailRepository.sendEmail(
                "abc@gmai.com",
                "Test",
                "Welcome Test Mail Message."
            )
        } answers {} //If any function not returning any value then define answers {}
        justRun {
            mailRepository.sendEmail(
                "abc@gmai.com",
                "Test",
                "Welcome Test Mail Message."
            )
        } //If any function not returning any value use justRun{} method
        val result = userService.loginUser("abc@gmai.com", "abcPass")
        userService.sendEmail("abc@gmai.com", "Test", "Welcome Test Mail Message.")
        assertEquals("Login Successfully", result)
        verify { userRepository.loginUser("abc@gmai.com", "abcPass") }
        every { mailRepository.sendEmail("abc@gmai.com", "Test", "Welcome Test Mail Message.") }
    }

    @Test
    fun `login invalid user and return invalid user`() {
        every { userRepository.loginUser(any(), any()) } returns LOGIN_STATUS.INVALID_USER
        val result = userService.loginUser("amb@gmai.com", "abcPass")
        assertEquals("User does not exist", result)
        verify { userRepository.loginUser("amb@gmai.com", "abcPass") }
    }






    class TestDemo{

        fun logMessage(message: String){
            Log.d("TestDemo",message)
        }
    }

    @Test
    fun slotExample() {
        val testMockk = mockk<TestDemo>()
        val capturedArg = slot<String>()

        // our test code using the mock object and captured arguments
        every { testMockk.logMessage(capture(capturedArg)) } just runs

        testMockk.logMessage("abc@gmai.com")

        verify { testMockk.logMessage("abc@gmai.com") }

        // You can now use capturedArg.captured if needed (last captured value)
        println("Captured argument: ${capturedArg.captured}")

    }
}

