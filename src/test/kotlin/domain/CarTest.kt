package domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarTest : BehaviorSpec({
    given("Car가 move를 수행할 때") {
        val car = Car(CarName("pobi"))
        `when`("4를 기준으로 갖는 Engine과 4이상을 반환하는 RandomGenerator가 주어진 경우") {
            val engine = Engine()
            val overCriteriaGenerator = object : RandomGenerator {
                override fun generate(): Int {
                    return Engine.MOVE_CRITERIA
                }
            }
            then("Car는 한 칸 전진한다") {
                car.move(engine, overCriteriaGenerator)
                car.position shouldBe 1
            }
        }

        `when`("4를 기준으로 갖는 engine과 4미만을 반환하는 RandomGenerator가 주어진 경우") {
            val engine = Engine()
            val underCriteriaGenerator = object : RandomGenerator {
                override fun generate(): Int {
                    return Engine.MOVE_CRITERIA - 1
                }
            }
            then("Car는 전진하지 않는다") {
                car.move(engine, underCriteriaGenerator)
                car.position shouldBe 1
            }
        }
    }
})
