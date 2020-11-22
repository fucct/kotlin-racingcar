package service

import domain.*
import dto.GameResult

class RaceGameService(
    private val carNamesVerifier: CarNamesVerifier,
    private val raceCountVerifier: RaceCountVerifier,
    private val engine: Engine,
    private val randomGenerator: RandomGenerator

) {
    fun play(carNames: String, raceCount: String): GameResult {
        val verifiedCarNames: CarNames = carNamesVerifier.verify(carNames)
        val verifiedRaceCount: RaceCount = raceCountVerifier.verify(raceCount)
        val cars = Cars(verifiedCarNames)
        val raceGame = RaceGame(cars, verifiedRaceCount, engine, randomGenerator)

        return raceGame.play()
    }
}
