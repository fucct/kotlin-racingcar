package domain

import java.lang.IllegalArgumentException

class CommaCarNamesVerifier : CarNamesVerifier {
    override fun verify(carNames: String) : CarNames {
        val splitCarNames: List<String> = carNames.split(",")

        if (splitCarNames.any { it.isEmpty() }) {
            throw IllegalArgumentException("Car Name은 null일 수 없습니다.")
        }

        if (splitCarNames.distinct().size != splitCarNames.size) {
            throw IllegalArgumentException("Car Name은 중복될 수 없습니다.")
        }

        return CarNames(splitCarNames.map { CarName(it) })
    }
}
