package domain

class DefaultRandomGenerator : RandomGenerator {
    override fun generate(): Int = (Math.random() * 10).toInt()
}
