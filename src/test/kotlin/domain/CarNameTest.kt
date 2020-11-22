package domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
import io.kotest.matchers.types.shouldBeTypeOf

class CarNameTest : BehaviorSpec({
    given("CarName 생성 시"){
        `when`("2~5글자의 CarName을 입력하면"){
            then("정상적으로 CarName을 생성한다"){
                val carName = CarName("pobi")
                carName.shouldBeTypeOf<CarName>()
                carName.name shouldBe "pobi"
            }
        }

        `when`("2~5글자가 아닌 CarName을 입력하면"){
            then("예외를 반환한다"){
                val exception = shouldThrow<IllegalArgumentException> { CarName("d") }
                exception.message should startWith("자동차 이름은 2~5자를 입력하셔야 합니다.")
            }
        }

        `when`("공백(NULL) CarName을 입력하면"){
            then("예외를 반환한다"){
                val exception = shouldThrow<IllegalArgumentException> { CarName(null) }
                exception.message should startWith("자동차 이름은 2~5자를 입력하셔야 합니다.")
            }
        }
    }
})
