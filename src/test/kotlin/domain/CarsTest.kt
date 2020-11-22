package domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.types.shouldBeTypeOf

class CarsTest : BehaviorSpec({
    val carName1 = CarName("pobi")
    val carName2 = CarName("crong")
    val carName3 = CarName("honux")
    given("Cars를 생성할 때") {
        val car1 = Car(carName1)
        val car2 = Car(carName2)
        val car3 = Car(carName3)
        `when`("Car 리스트가 주어지면") {
            val carList = listOf(car1, car2, car3)
            then("정상적으로 Cars를 생성한다") {
                val cars = Cars(carList)
                cars.shouldBeTypeOf<Cars>()
                cars.cars shouldContainExactly carList
            }
        }

        `when`("CarNames가 주어지면") {
            val carNames = CarNames(carName1, carName2, carName3)
            then("정상적으로 Cars를 생성한다") {
                val cars = Cars(carNames)
                cars.shouldBeTypeOf<Cars>()
                cars.cars shouldContainExactly listOf(car1, car2, car3)
            }
        }
    }
    given("Car들의 위치가 다를 때") {
        val car1 = Car(carName1, 2)
        val car2 = Car(carName2, 4)
        val car3 = Car(carName3, 6)
        `when`("우승자를 결정하면") {
            val cars = Cars(listOf(car1, car2, car3))
            then("가장 position이 큰 Car를 우승자로 반환한다") {
                val decideWinner = cars.decideWinner()
                decideWinner.cars shouldContainExactly listOf(car3)
            }
        }
    }

    given("Car들의 위치가 같을 때") {
        val car1 = Car(carName1, 3)
        val car2 = Car(carName2, 3)
        val car3 = Car(carName3, 3)
        `when`("우승자를 결정하면") {
            val cars = Cars(listOf(car1, car2, car3))
            then("모든 Car를 우승자로 반환한다") {
                val decideWinner = cars.decideWinner()
                decideWinner.cars shouldContainExactly listOf(car1, car2, car3)
            }
        }
    }
})
