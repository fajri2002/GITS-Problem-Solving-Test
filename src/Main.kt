import java.util.*

const val EXIT = -1
const val SLOANES_SEQUENCE = 1
const val DENSE_RANKING = 2
const val BALANCED_BRACKET = 3

fun main() {
    val scanner = Scanner(System.`in`)
    println("Pilih Soal:\n1. Sloane's Problem\n2. Dense Ranking Problem\n3. Balanced Bracket Problem\n4. Exit (enter -1)")
    print("Pilihan: ")
    var choose = scanner.nextInt()

    while (choose != EXIT) {
        if (choose == SLOANES_SEQUENCE) {
            print("Masukkan jumlah anggota dalam deret: ")
            val input = scanner.nextInt()
            getOutputSloSequence(input)
        } else if (choose == DENSE_RANKING) {
            print("Masukkan banyak pemain: ")
            val playerCount = scanner.nextInt()
            val playersScore = IntArray(playerCount)
            println("Masukkan Skor: ")
            for (i in 0 until playerCount) {
                print("Skor pemain ${i + 1}: ")
                playersScore[i] = scanner.nextInt()
            }

            print("Masukkan banyak poin GITS: ")
            val gitsCount = scanner.nextInt()
            val gitsScore = IntArray(gitsCount)
            println("Masukkan Skor GITS: ")
            for (i in 0 until gitsCount) {
                print("Skor pemain ${i + 1}: ")
                gitsScore[i] = scanner.nextInt()
            }

            val playersPlayResult = calculateRank(playersScore)
            val gitsPlayResult = calculateCurrentScore(playersPlayResult, gitsScore)
            val formattedOutput = gitsPlayResult.joinToString(prefix = "[", postfix = "]") { "{${it.score} ${it.rank}}" }
            println(formattedOutput)
        } else if (choose == BALANCED_BRACKET) {
            print("Input brackets: ")
            val bracket = readLine() ?: ""
            println("Kurung seimbang? ${bracketBal(bracket)}")
        }

        print("Pilihan: ")
        choose = scanner.nextInt()
    }
}