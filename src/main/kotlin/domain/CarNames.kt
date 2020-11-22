package domain

class CarNames (vararg names: String) {
    val carNames: List<CarName> = names.map(::CarName)

    constructor(nameList: List<String>) : this(*nameList.toTypedArray())

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
