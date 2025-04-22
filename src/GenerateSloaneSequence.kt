fun generateSloSequence(n: Int): List<Int> {
    val sequence = mutableListOf<Int>()
    for (i in 0 until n) {
        val value = (i * i + i + 2) / 2
        sequence.add(value)
    }
    return sequence
}

fun getOutputSloSequence(n: Int) {
    val result = generateSloSequence(n)
    println("Output: " + result.joinToString("-"))
}