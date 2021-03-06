package io.a2kaido.mikan

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onChildAt
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun navigateToDetail() {
        composeTestRule.setContent {
            MaterialTheme {
                AppNavigation()
            }
        }
        composeTestRule.onRoot().printToLog("TAG")
        composeTestRule.onNode(hasTestTag("list"))
            .onChildAt(0)
            .performClick()
    }
}
