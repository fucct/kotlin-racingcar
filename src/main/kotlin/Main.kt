import domain.CommaCarNamesVerifier
import domain.DefaultRaceCountVerifier
import domain.DefaultRandomGenerator
import domain.Engine
import dto.GameResult
import service.RaceGameService
import view.*

fun main(args: Array<String>) {
    printStart()
    val carNames: String = inputCarName()
    printCount()
    val raceCount: String = inputRaceCount()
    printNewLine()

    val raceGame =
        RaceGameService(CommaCarNamesVerifier(), DefaultRaceCountVerifier(), Engine(), DefaultRandomGenerator())
    val result: GameResult = raceGame.play(carNames, raceCount)

    printResult(result)
}

