package domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.containAll
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.sequences.containAll
import io.kotest.matchers.sequences.containExactly
import io.kotest.matchers.should
import io.kotest.matchers.types.shouldBeTypeOf

class CarsTest : BehaviorSpec({
    given("Cars를 생성할 때"){
        `when`("Car 리스트가 주어지면"){
            val car1 = Car(CarName("pobi"))
            val car2 = Car(CarName("crong"))
            val car3 = Car(CarName("honux"))
            val carList = listOf(car1, car2, car3)
            then("정상적으로 Cars를 생성한다"){
                val cars = Cars(carList)
                cars.shouldBeTypeOf<Cars>()
                cars.cars shouldContainExactly carList
            }
        }
    }
})
