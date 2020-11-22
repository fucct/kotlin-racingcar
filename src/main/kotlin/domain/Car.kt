package domain

class Car(val name: CarName, val position: Int = 0) {
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
