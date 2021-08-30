package com.example.tokyoolympics.util

import android.graphics.Color.rgb

object Constant {
    const val DATA_FILE: String = "tokyo_2021.csv"

    object Index {
        const val RANK = 0
        const val COUNTRY = 1
        const val GOLD = 2
        const val SILVER = 3
        const val BRONZE = 4
        const val TOTAL = 5
        const val ISO3 = 7
    }

    object Color {
        val GOLD by lazy { rgb(255, 224, 169) }
        val SILVER by lazy { rgb(203, 214, 239) }
        val BRONZE by lazy { rgb(255, 176, 141) }
    }
}