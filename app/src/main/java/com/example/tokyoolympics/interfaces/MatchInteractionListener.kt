package com.example.tokyoolympics.interfaces

import com.example.tokyoolympics.data.domain.Match

interface MatchInteractionListener {
    fun onClickFlag(name: String)
    fun onClickItem(match: Match)
}