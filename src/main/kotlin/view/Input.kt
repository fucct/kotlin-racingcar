package view

import java.lang.IllegalArgumentException

fun inputCarName() : String = readLine() ?: throw IllegalArgumentException()

fun inputRaceCount() : String = readLine() ?: throw IllegalArgumentException()
