package domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.types.shouldBeTypeOf

class CarsTest : BehaviorSpec({
    given("Cars를 생성할 때"){
        val carName1 = CarName("pobi")
        val carName2 = CarName("crong")
        val carName3 = CarName("honux")
        val car1 = Car(carName1)
        val car2 = Car(carName2)
        val car3 = Car(carName3)
        `when`("Car 리스트가 주어지면"){
            val carList = listOf(car1, car2, car3)
            then("정상적으로 Cars를 생성한다"){
                val cars = Cars(carList)
                cars.shouldBeTypeOf<Cars>()
                cars.cars shouldContainExactly carList
            }
        }

        `when`("CarNames가 주어지면"){
            val carNames = CarNames(carName1, carName2, carName3)
            then("정상적으로 Cars를 생성한다"){
                val cars = Cars(carNames)
                cars.shouldBeTypeOf<Cars>()
                cars.cars shouldContainExactly listOf(car1, car2, car3)
            }
       }
    }
})
