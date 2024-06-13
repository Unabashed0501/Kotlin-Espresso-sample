package net.pot8os.kotlintestsample.pages

import android.view.View
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

open class BasePage {
    fun clickOnView(viewInteraction: ViewInteraction) {
        viewInteraction.perform(ViewActions.click())
    }

    fun checkText(viewInteraction: ViewInteraction, text: String) {
        viewInteraction.check(ViewAssertions.matches(ViewMatchers.withText(text)))
    }
}
