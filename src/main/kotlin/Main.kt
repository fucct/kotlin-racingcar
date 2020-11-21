import domain.CommaCarNamesVerifier
import domain.DefaultRaceCountVerifier
import domain.RaceCountVerifier
import dto.GameResult
import service.RaceGameService
import view.*

fun main(args: Array<String>) {
    while (true) {
        printStart()
        val carNames: String = inputCarName()
        printCount()
        val raceCount: String = inputRaceCount()
        printNewLine()

        val raceGame = RaceGameService(CommaCarNamesVerifier(), DefaultRaceCountVerifier())
        val result: GameResult = raceGame.play(carNames, raceCount)

        printResult(result)
    }
}

