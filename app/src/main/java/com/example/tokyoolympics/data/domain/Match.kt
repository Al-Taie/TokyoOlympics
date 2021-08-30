package com.example.tokyoolympics.data.domain

data class Match(
    val rankValue: Int,
    val countryName: String,
    val goldMedal: Int,
    val silverMedal: Int,
    val bronzeMedal: Int,
    val totalValue: Int,
    val iso3: String
)
