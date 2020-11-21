package domain

data class RaceCount(val count: Long) {
    init {
        if (count <= 0) {
            throw IllegalArgumentException("Race Count는 0 이하일 수 없습니다.")
        }
    }
}
