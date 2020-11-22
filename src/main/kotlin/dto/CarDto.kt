package dto

import domain.Car

class CarDto private constructor(val name: String, val position: Int) {
    companion object {
        fun of(car: Car): CarDto {
            return CarDto(car.name.name!!, car.position)
        }
    }
}
