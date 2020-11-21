package domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf
import org.junit.jupiter.api.Assertions.*

internal class CarTest : BehaviorSpec({
    given("Car를 생성할 떄"){
        `when`("정상적인 이름을 입력 시"){
            then("정상적으로 Car를 생성한다"){
                val car = Car(CarName("DD"))
                car.shouldBeTypeOf<Car>()
                car.name shouldBe "DD"
                car.position shouldBe 0
            }
        }
    }
})
