/**
 * @Author: Created by Sonu Kumar
 * @Date: 21/01/25 2:45 PM.
 * @Email: sonu02@countrydelight.in
 */

package com.example.unittestdemo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Class Definition
 *
 */
@RunWith(AndroidJUnit4::class)
class DemoActivityInstrumentTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(DemoActivity::class.java)

    @Test
    fun animateDeliveryAndSearchAnimation() {
        onView(withId(R.id.tvSearch)).perform(click())
    }

    fun buttonClickAndMatchValue(){
        onView(withId(R.id.sonuView)).perform(click())
        onView(withId(R.id.sonuView)).perform(click())
        onView(withId(R.id.sonuView)).perform(click())
        activityRule
    }

}
