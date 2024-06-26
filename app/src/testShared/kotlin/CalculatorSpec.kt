package net.pot8os.kotlintestsample

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.junit.Before
import org.junit.Test
import java.text.DecimalFormat

/**
 * @author So Nakamura, 2020-Feb-15
 */
abstract class CalculatorSpec {

    @Before
    fun setup() {
        launchFragmentInContainer<CalculatorFragment>(themeResId = R.style.Theme_MyApp)
    }

    @Test
    fun testSum() {
        onView(withId(R.id.button_1)).perform(click())
        onView(withId(R.id.button_2)).perform(click())
        onView(withId(R.id.button_3)).perform(click())
        onView(withId(R.id.button_sum)).perform(click())
        onView(withId(R.id.button_3)).perform(click())
        onView(withId(R.id.button_2)).perform(click())
        onView(withId(R.id.button_1)).perform(click())
        onView(withId(R.id.button_calc)).perform(click())
        onView(withId(R.id.field)).check(matches(withText("${123 + 321}")))
    }

    @Test
    fun testSub() {
        onView(withId(R.id.button_9)).perform(click())
        onView(withId(R.id.button_9)).perform(click())
        onView(withId(R.id.button_9)).perform(click())
        onView(withId(R.id.button_sub)).perform(click())
        onView(withId(R.id.button_3)).perform(click())
        onView(withId(R.id.button_3)).perform(click())
        onView(withId(R.id.button_3)).perform(click())
        onView(withId(R.id.button_calc)).perform(click())
        onView(withId(R.id.field)).check(matches(withText("${999 - 333}")))
    }

    @Test
    fun testMul() {
        onView(withId(R.id.button_1)).perform(click())
        onView(withId(R.id.button_0)).perform(click())
        onView(withId(R.id.button_0)).perform(click())
        onView(withId(R.id.button_mul)).perform(click())
        onView(withId(R.id.button_2)).perform(click())
        onView(withId(R.id.button_0)).perform(click())
        onView(withId(R.id.button_0)).perform(click())
        onView(withId(R.id.button_calc)).perform(click())
        val formatter = DecimalFormat("#,###")
        onView(withId(R.id.field)).check(matches(withText(formatter.format(100 * 200))))
    }

    @Test
    fun testDiv() {
        onView(withId(R.id.button_3)).perform(click())
        onView(withId(R.id.button_3)).perform(click())
        onView(withId(R.id.button_3)).perform(click())
        onView(withId(R.id.button_div)).perform(click())
        onView(withId(R.id.button_1)).perform(click())
        onView(withId(R.id.button_0)).perform(click())
        onView(withId(R.id.button_0)).perform(click())
        onView(withId(R.id.button_calc)).perform(click())
        onView(withId(R.id.field)).check(matches(withText("${333 / 100.0}")))
    }

    @Test
    fun testClearButton() {
        // Input some numbers and perform a calculation
        onView(withId(R.id.button_1)).perform(click())
        onView(withId(R.id.button_2)).perform(click())
        onView(withId(R.id.button_3)).perform(click())
        onView(withId(R.id.button_sum)).perform(click())
        onView(withId(R.id.button_4)).perform(click())
        onView(withId(R.id.button_5)).perform(click())
        onView(withId(R.id.button_6)).perform(click())
        onView(withId(R.id.button_calc)).perform(click())

        // Verify that the result is displayed
        onView(withId(R.id.field)).check(matches(withText("579"))) // Adjust this expected result as needed

        // Click the AC button
        onView(withId(R.id.button_all_clear)).perform(click())

        // Verify that the display is cleared (assuming it should be reset to "0")
        onView(withId(R.id.field)).check(matches(withText("0")))
    }
}
