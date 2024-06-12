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
        // Perform calculations using the page object methods
        calculatorPage.enterNumber123()
        calculatorPage.clickAdd()
        calculatorPage.enterNumber456()
        calculatorPage.clickCalc()

        // Verify the result
        calculatorPage.verifyResult("579") // Adjust this expected result as needed

        // Click the AC button and verify the display is cleared
        calculatorPage.clickAc()
        calculatorPage.verifyDisplayIsCleared()
    }
}
