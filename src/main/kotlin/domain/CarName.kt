package domain

data class CarName(val name: String?){
    init{
        val carName = name?.trim()
        if (carName == null || carName.length !in 2..5) {
            throw IllegalArgumentException("자동차 이름은 2~5자를 입력하셔야 합니다.")
        }
    }
}
