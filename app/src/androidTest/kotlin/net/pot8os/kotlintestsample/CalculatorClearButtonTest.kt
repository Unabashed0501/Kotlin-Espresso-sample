package net.pot8os.kotlintestsample

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import net.pot8os.kotlintestsample.pages.CalculatorPage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculatorClearButtonTest {

    @Rule
    @JvmField
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    private val calculatorPage = CalculatorPage()

    @Test
    fun testClearButton() {
        calculatorPage.enterNumber123()
        calculatorPage.clickAdd()
        calculatorPage.enterNumber456()
        calculatorPage.clickCalc()

        // Verify the result
        calculatorPage.verifyResult("579")

        calculatorPage.clickAc()
        calculatorPage.verifyDisplayIsCleared()
    }

    @Test
    fun testClearButtonNew() {
        CalculatorPage()
            .clickNumberButtons(1, 2, 3)
            .clickOperatorButton("+")
            .clickNumberButtons(4, 5, 6)
            .clickOperatorButton("=")

            // Verify that the result is displayed
            .verifyResultDisplayed("579")

            // Click the AC button
            .clickACButton()

            // Verify that the display is cleared
            .verifyResultDisplayed("0")
    }
}
