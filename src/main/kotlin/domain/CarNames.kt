package domain

class CarNames (vararg names: CarName) {
    val carNames: List<CarName> = names.toList()

    constructor(nameList: List<CarName>) : this(*nameList.toTypedArray())

    constructor(vararg names: String) : this(names.map { CarName(it) })

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
