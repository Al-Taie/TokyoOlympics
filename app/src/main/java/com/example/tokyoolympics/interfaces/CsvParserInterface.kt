package com.example.tokyoolympics.interfaces

import com.example.tokyoolympics.data.domain.Match
import java.io.InputStream

interface CsvParserInterface {
    fun parseDataFile(inputStream: InputStream)
    fun parse(line: String): Match
}