package domain

class Engine() {
    companion object {
        const val MOVE_CRITERIA = 4
    }

    fun accelerate(randomGenerator: RandomGenerator): Int {
        val randomNumber = randomGenerator.generate()
        if (randomNumber >= MOVE_CRITERIA) {
            return 1
        }
        return 0
    }
}
