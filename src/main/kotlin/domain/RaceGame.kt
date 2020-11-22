package domain

import dto.CarsDto
import dto.GameResult

class RaceGame(
    private val cars: Cars,
    private val raceCount: RaceCount,
    private val engine: Engine,
    private val randomGenerator: RandomGenerator
) {
    fun play(): GameResult {
        val snapShot: MutableList<CarsDto> = mutableListOf()
        for (i in 0 until raceCount.count) {
            for (car in cars) {
                car.move(engine, randomGenerator)
            }
            snapShot.add(CarsDto(cars))
        }

        val winners = CarsDto(cars.decideWinner())
        return GameResult(snapShot, winners)
    }
}
