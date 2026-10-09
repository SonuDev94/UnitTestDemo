package com.example.unittestdemo.instrumenttest

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.unittestdemo.R
import org.hamcrest.CoreMatchers.allOf
import org.junit.Rule
import org.junit.Test

/**
 * @Author: Created by Sonu Kumar
 * @Date: 22/01/25 2:48 PM.
 * @Email: sonu02@countrydelight.in
 */
class InstrumentTestActivityTest {
    val MSG = "Hello Sonu, I am Android Developer"

    @get:Rule
    val instrmentTestActivity = ActivityScenarioRule(InstrumentTestActivity::class.java)

    @Test
    fun changeText_sameActivity() {
        onView(withId(R.id.editTextUserInput)).perform(typeText(MSG), closeSoftKeyboard())
        onView(withId(R.id.changeTextBt)).perform(click())
        onView(withId(R.id.textToBeChanged)).check(matches(withText(MSG)))
    }

    @Test
    fun changeTest_newActivity() {
        onView(withId(R.id.editTextUserInput)).perform(typeText(MSG), closeSoftKeyboard())
        onView(withId(R.id.activityChangeTextBtn)).perform(click())
        onView(withId(R.id.show_text_view)).check(matches(withText(MSG)))
    }


    @Test
    fun shareButtonClick() {
        Intents.init()
        val expected = allOf(IntentMatchers.hasAction(Intent.ACTION_CHOOSER),
            IntentMatchers.hasExtra(Intent.EXTRA_INTENT, allOf(IntentMatchers.hasAction(Intent.ACTION_SEND)))
        )

        onView(withId(R.id.shareBtn)).perform(click())
        intended(expected)
        Intents.release()
    }
}