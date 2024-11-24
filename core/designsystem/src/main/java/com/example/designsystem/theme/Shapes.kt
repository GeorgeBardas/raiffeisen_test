package com.example.designsystem.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

data class Shapes(
    val small: Shape = RoundedCornerShape(size = 8.dp),
    val large: Shape = RoundedCornerShape(size = 16.dp)
)

val LocalShape = compositionLocalOf { Shapes() }

val MaterialTheme.shapeScheme: Shapes
    @Composable
    @ReadOnlyComposable
    get() = LocalShape.current