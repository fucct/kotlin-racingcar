package domain

import org.w3c.dom.NameList

class CarNames public constructor(vararg names: String) {
    var carNames: List<CarName> = names.map(::CarName)

    constructor(nameList: List<String>) : this() {
        carNames = nameList.map(::CarName)
    }

    override fun equals(other: Any?): Boolean {
        return if (other is CarNames) {
            return this.carNames.filterIndexed() { index, carName -> other.carNames[index] != carName }.isEmpty()
        } else {
            false
        }
    }

    override fun hashCode(): Int {
        return carNames.map { it.hashCode() }.sum()
    }
}
