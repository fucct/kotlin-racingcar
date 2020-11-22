package domain

class Cars(val cars: List<Car>) : Iterable<Car> {
    constructor(carNames: CarNames) : this(carNames.carNames.map { Car(it) })

    override fun iterator(): Iterator<Car> {
        return cars.iterator()
    }

    fun decideWinner(): Cars {
        val groupByPosition = cars.groupBy { it.position }.toSortedMap()
        return Cars(groupByPosition.getValue(groupByPosition.lastKey()))
    }
}
