package com.example.tokyoolympics.ui

import android.view.LayoutInflater
import android.widget.Toast
import com.blongho.country_data.World
import com.example.tokyoolympics.R
import com.example.tokyoolympics.data.DataManager
import com.example.tokyoolympics.data.domain.Match
import com.example.tokyoolympics.databinding.ActivityMainBinding
import com.example.tokyoolympics.interfaces.MatchInteractionListener
import com.example.tokyoolympics.ui.base.BaseActivity
import com.example.tokyoolympics.util.Constant
import com.example.tokyoolympics.util.CsvParser
import com.example.tokyoolympics.util.MatchAdapter

class MainActivity : BaseActivity<ActivityMainBinding>(), MatchInteractionListener {
    override fun setup() {
        openFile()
        callback()
    }

    override fun callback() {
        World.init(applicationContext)
        binding.recyclerMatch.adapter = MatchAdapter(DataManager.matches, this)
    }

    override val theme = R.style.Theme_TokyoOlympics

    override val inflate: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    private fun openFile() {
        val inputStream = assets.open(Constant.DATA_FILE)
        CsvParser.parseDataFile(inputStream = inputStream)
    }

    override fun onClickFlag(name: String) {
        Toast.makeText(applicationContext, name, Toast.LENGTH_SHORT).show()
    }

    override fun onClickItem(match: Match) {}
}
