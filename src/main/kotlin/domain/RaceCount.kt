package domain

data class RaceCount(val count: Long) {
    companion object {
        const val MAX_COUNT: Int = 200
        const val MIN_COUNT: Int = 0
    }

    init {
        if (count <= MIN_COUNT || count > MAX_COUNT) {
            throw IllegalArgumentException("Race Count는 0 이하일 수 없습니다.")
        }
    }
}
