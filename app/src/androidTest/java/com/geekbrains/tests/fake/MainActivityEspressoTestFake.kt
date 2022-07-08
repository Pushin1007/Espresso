package com.geekbrains.tests.fake

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.geekbrains.tests.R
import com.geekbrains.tests.view.search.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityEspressoTestFake {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun activitySearch_IsWorking() {
        Espresso.onView(ViewMatchers.withId(R.id.searchEditText)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.searchEditText))
            .perform(ViewActions.replaceText("algol"), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.searchEditText))
            .perform(ViewActions.pressImeActionButton())
        Espresso.onView(ViewMatchers.withId(R.id.totalCountTextView))
            .check(ViewAssertions.matches(ViewMatchers.withText("Number of results: 42")))
    }

    @Test
    fun searchEditText_Visible() {
        Espresso.onView(ViewMatchers.withId(R.id.searchEditText))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }

    @Test
    fun countTextView_Invisible() {
        Espresso.onView(ViewMatchers.withId(R.id.totalCountTextView))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)))
    }

    @Test
    fun countTextView_Visible() {
        Espresso.onView(ViewMatchers.withId(R.id.searchEditText)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.searchEditText))
            .perform(ViewActions.replaceText("algol"), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.searchEditText))
            .perform(ViewActions.pressImeActionButton())
        Espresso.onView(ViewMatchers.withId(R.id.searchEditText))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }

    @Test
    fun toDetailsActivityButton_Text() {
        Espresso.onView(ViewMatchers.withId(R.id.toDetailsActivityButton))
            .check(ViewAssertions.matches(ViewMatchers.withText("to details")))
    }

    @Test
    fun searchEditText_Hint() {
        Espresso.onView(ViewMatchers.withId(R.id.searchEditText))
            .check(ViewAssertions.matches(ViewMatchers.withHint("Enter keyword e.g. android")))
    }

    @After
    fun close() {
        scenario.close()
    }
}
