package domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
import io.kotest.matchers.types.shouldBeTypeOf

class RaceCountVerifierTest : BehaviorSpec({
    given("Race Count를 검증하는 상황에서"){
        val raceCountVerifier = DefaultRaceCountVerifier()
        `when`("사용자가 1 이상을 입력하면"){
            val raceCountInput = "3"
            then("정상적인 Race Count를 생성한다"){
                val raceCount = raceCountVerifier.verify(raceCountInput)
                raceCount.shouldBeTypeOf<RaceCount>()
                raceCount.count shouldBe 3
            }
        }

        `when`("사용자가 숫자가 아닌 값을 입력하면"){
            val raceCountInput = "DD"
            then("Race Count 생성 실패 예외를 반환한다"){
                val exception = shouldThrow<IllegalArgumentException> {
                    raceCountVerifier.verify(raceCountInput)
                }
                exception.message should startWith("Race Count는 숫자만 가능합니다")
            }
        }
    }
})
