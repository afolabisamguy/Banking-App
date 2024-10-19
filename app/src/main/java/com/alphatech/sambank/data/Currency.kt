package com.alphatech.sambank.data

import androidx.compose.ui.graphics.vector.ImageVector

data class Currency(
    val buy: Float,
    val name: String,
    val sell: Float,
    val icon: ImageVector
)
