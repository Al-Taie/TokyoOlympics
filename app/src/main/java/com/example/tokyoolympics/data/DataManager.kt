package com.example.tokyoolympics.data

import com.example.tokyoolympics.data.domain.Match

object DataManager {
    private val matchesList = mutableListOf<Match>()

    fun addMatch(match: Match) = matchesList.add(match)

    val matches: List<Match>
        get() = matchesList
}