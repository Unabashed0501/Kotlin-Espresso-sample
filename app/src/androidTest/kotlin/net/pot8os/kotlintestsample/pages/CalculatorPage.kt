package net.pot8os.kotlintestsample.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import net.pot8os.kotlintestsample.R

class CalculatorPage : BasePage() {
    private val button1 = onView(withId(R.id.button_1))
    private val button2 = onView(withId(R.id.button_2))
    private val button3 = onView(withId(R.id.button_3))
    private val button4 = onView(withId(R.id.button_4))
    private val button5 = onView(withId(R.id.button_5))
    private val button6 = onView(withId(R.id.button_6))
    private val buttonAdd = onView(withId(R.id.button_sum))
    private val buttonCalc = onView(withId(R.id.button_calc))
    private val buttonAc = onView(withId(R.id.button_all_clear))
    private val field = onView(withId(R.id.field))

    fun enterNumber123() {
        clickOnView(button1)
        clickOnView(button2)
        clickOnView(button3)
    }

    fun enterNumber456() {
        clickOnView(button4)
        clickOnView(button5)
        clickOnView(button6)
    }

    fun clickAdd() {
        clickOnView(buttonAdd)
    }

    fun clickCalc() {
        clickOnView(buttonCalc)
    }

    fun clickAc() {
        clickOnView(buttonAc)
    }

    fun verifyDisplayIsCleared() {
        checkText(field, "0")
    }

    fun verifyResult(expectedResult: String) {
        checkText(field, expectedResult)
    }
}
