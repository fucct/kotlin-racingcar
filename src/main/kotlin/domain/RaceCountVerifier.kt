package domain

import java.lang.IllegalArgumentException

interface RaceCountVerifier {
    fun verify(raceCount: String?): RaceCount
}
