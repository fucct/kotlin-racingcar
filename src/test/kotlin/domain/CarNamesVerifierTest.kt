package domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
import java.lang.IllegalArgumentException

class CarNamesVerifierTest() : BehaviorSpec({
    given("자동차 이름 입력 검증 시"){
        val carNamesVerifier = CommaCarNamesVerifier()
        `when`("정상적인 입력이 들어온 경우"){
            then("정상적으로 CarNames를 반환한다."){
                val verifiedNames : CarNames = carNamesVerifier.verify("pobi,crong,honux")
                verifiedNames shouldBe CarNames("pobi", "crong", "honux")
            }
        }

        `when`("콤마가 연속으로 2개 이상 들어온 경우"){
            then("예외를 반환한다."){
                val exception = shouldThrow<IllegalArgumentException> {
                    carNamesVerifier.verify("pobi,,honux")
                }
                exception.message should startWith("Car Name은 null일 수 없습니다.")
            }
        }

        `when`("중복된 이름이 2개 이상 들어온 경우"){
            then("예외를 반환한다."){
                val exception = shouldThrow<IllegalArgumentException> {
                    carNamesVerifier.verify("pobi,pobi,honux")
                }
                exception.message should startWith("Car Name은 중복될 수 없습니다.")
            }
        }
    }
})
