package domain

class Cars(val cars: List<Car>) {
    constructor(carNames: CarNames): this(carNames.carNames.map { Car(it) })
}
