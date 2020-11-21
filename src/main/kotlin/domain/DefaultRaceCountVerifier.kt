package domain

class DefaultRaceCountVerifier : RaceCountVerifier {
    override fun verify(raceCount: String?): RaceCount {
        return RaceCount(raceCount?.toLongOrNull()
                ?:
        throw IllegalArgumentException("Race Count는 숫자만 가능합니다"))
    }
}
