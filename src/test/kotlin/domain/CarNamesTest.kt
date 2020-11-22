package domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.types.shouldBeTypeOf

internal class CarNamesTest: BehaviorSpec({
    given("CarNames를 생성할 때"){
        `when`("2~5글자 이름을 가변인자로 입력 하면"){
            val carNames = CarNames("pobi", "crong", "honux")
            then("정상적으로 CarNames를 생성한다"){
                carNames.shouldBeTypeOf<CarNames>()
                carNames.carNames shouldContainAll listOf(CarName("pobi"), CarName("crong"), CarName("honux"))
            }
        }
        `when`("2~5글자 이름을 리스트로 입력 하면"){
            val carNames = CarNames(listOf("pobi", "crong", "honux"))
            then("정상적으로 CarNames를 생성한다"){
                carNames.shouldBeTypeOf<CarNames>()
                carNames.carNames shouldContainAll listOf(CarName("pobi"), CarName("crong"), CarName("honux"))
            }
        }
    }
})
