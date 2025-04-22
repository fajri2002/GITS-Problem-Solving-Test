
data class PlayResult(var score: Int, var rank: Int)

fun calculateRank(scores: IntArray): List<PlayResult> {
    val result = mutableListOf<PlayResult>()
    var currentRanking = 1

    val sortedScores = scores.sortedDescending()

    for (i in sortedScores.indices) {
        result.add(PlayResult(sortedScores[i], currentRanking))
        if (i < sortedScores.size - 1 && sortedScores[i] > sortedScores[i + 1]) {
            currentRanking++
        }
    }
    return result
}

fun calculateCurrentScore(playerScores: List<PlayResult>, currentPlayerScore: IntArray): List<PlayResult> {
    val result = mutableListOf<PlayResult>()
    val playerScoresSize = playerScores.size

    for (currentPlayerScore in currentPlayerScore) {
        if (playerScores.isEmpty()) {
            result.add(PlayResult(currentPlayerScore, 1))
            continue
        }

        if (currentPlayerScore >= playerScores[0].score) {
            result.add(PlayResult(currentPlayerScore, 1))
            continue
        }


        if (currentPlayerScore < playerScores.last().score) {
            result.add(PlayResult(currentPlayerScore, playerScores.last().rank + 1))
            continue
        }

        for (j in 0 until playerScoresSize - 1) {
            if (currentPlayerScore >= playerScores[j + 1].score && currentPlayerScore < playerScores[j].score && playerScores[j + 1].score != playerScores[j].score) {
                result.add(PlayResult(currentPlayerScore, playerScores[j + 1].rank))
                break
            }
        }
    }
    return result
}