package domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class EngineTest : BehaviorSpec({
    given("Engine이 주어졌을 때") {
        val engine = Engine()
        `when`("RandomGenerator의 값이 4(Criteria) 이상인 경우") {
            val overFourGenerator = object : RandomGenerator {
                override fun generate(): Int {
                    return Engine.MOVE_CRITERIA
                }
            }
            then("Accelerate시 1을 반환한다") {
                engine.accelerate(overFourGenerator) shouldBe 1
            }
        }
        `when`("RandomGenerator의 값이 4(Criteria) 이하인 경우") {
            val underFourGenerator = object : RandomGenerator {
                override fun generate(): Int {
                    return Engine.MOVE_CRITERIA - 1
                }
            }
            then("Accelerate시 0을 반환한다") {
                engine.accelerate(underFourGenerator) shouldBe 0
            }
        }
    }
})
