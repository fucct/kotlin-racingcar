package view

import dto.CarsDto
import dto.GameResult


fun printStart() {
    printNewLine()
    println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
}

fun printCount() {
    printNewLine()
    println("시도할 회수는 몇회인가요?")
}

fun printNewLine() {
    println()
}

fun printResult(gameResult: GameResult) {
    val carsDtoList = gameResult.snapShot

    for (carsDto in carsDtoList) {
        printCarsStatus(carsDto)
    }
    printWinners(gameResult)
}

private fun printWinners(gameResult: GameResult) {
    println(gameResult.winners.cars.joinToString { it.name } + "가 최종 우승했습니다.")
}

private fun printCarsStatus(carsDto: CarsDto): Unit {
    val sb = StringBuilder()
    for (car in carsDto.cars) {
        sb.append(car.name)
        sb.append(" : ")
        sb.append("-".repeat(car.position))
        sb.append(System.lineSeparator())
    }
    sb.append(System.lineSeparator())
    println(sb.toString())
}

