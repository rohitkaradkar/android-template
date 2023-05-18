package com.rohitkaradkar.sample

import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColorInt
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ExampleRobolectricTest {
  @Test
  fun `color is white`() {
    // Checks if android.graphics.Color is accessible
    assertEquals(Color.White, Color("#FFFFFF".toColorInt()))
  }
}
