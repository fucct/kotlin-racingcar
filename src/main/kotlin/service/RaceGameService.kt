package service

import domain.CarNames
import domain.CarNamesVerifier
import domain.RaceCountVerifier
import dto.GameResult

class RaceGameService(private val carNamesVerifier: CarNamesVerifier, private val raceCountVerifier: RaceCountVerifier) {
    fun play(carNames: String, raceCount: String): GameResult {
        val verifiedCarNames: CarNames = carNamesVerifier.verify(carNames)
        val verifiedRaceCount: Long = raceCountVerifier.verify(raceCount)

        return GameResult()
    }

}
