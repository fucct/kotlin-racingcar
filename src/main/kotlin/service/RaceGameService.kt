package service

import domain.*
import dto.GameResult

class RaceGameService(private val carNamesVerifier: CarNamesVerifier, private val raceCountVerifier: RaceCountVerifier) {
    fun play(carNames: String, raceCount: String): GameResult {
        val verifiedCarNames: CarNames = carNamesVerifier.verify(carNames)
        val verifiedRaceCount: RaceCount = raceCountVerifier.verify(raceCount)

        Cars(verifiedCarNames)

        return GameResult()
    }
}
