package view

import dto.GameResult


fun printStart() {
    println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
}

fun printCount() {
    println("시도할 회수는 몇회인가요?")
}

fun printNewLine() {
    println()
}

fun printResult(result: GameResult){
    println(result)
}
