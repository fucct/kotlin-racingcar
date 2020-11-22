package dto

import domain.Cars

class CarsDto(cars: Cars) {
    val cars: List<CarDto> = cars.map { CarDto.of(it) }
}
