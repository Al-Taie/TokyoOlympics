package com.example.tokyoolympics.util

import com.example.tokyoolympics.data.DataManager
import com.example.tokyoolympics.data.domain.Match
import com.example.tokyoolympics.interfaces.CsvParserInterface
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

object CsvParser : CsvParserInterface {
    override fun parseDataFile(inputStream: InputStream) {
        BufferedReader(InputStreamReader(inputStream)).forEachLine {
            DataManager.addMatch(match = parse(it))
        }

    }

    override fun parse(line: String): Match {
        val dataList = line.split(',')
        return Match(
            rankValue = dataList[Constant.Index.RANK].toInt(),
            countryName = dataList[Constant.Index.COUNTRY],
            goldMedal = dataList[Constant.Index.GOLD].toInt(),
            silverMedal = dataList[Constant.Index.SILVER].toInt(),
            bronzeMedal = dataList[Constant.Index.BRONZE].toInt(),
            totalValue = dataList[Constant.Index.TOTAL].toInt(),
            iso3 = dataList[Constant.Index.ISO3]
        )
    }
}