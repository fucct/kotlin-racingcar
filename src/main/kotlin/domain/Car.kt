package domain

class Car(val name: CarName, var position: Int = 0) {
    fun move(engine: Engine, randomGenerator: RandomGenerator) {
        this.position += engine.accelerate(randomGenerator)
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Car) {
            return false
        }
        return name == other.name
    }

    override fun hashCode(): Int {
        return this.name.hashCode()
    }
}
