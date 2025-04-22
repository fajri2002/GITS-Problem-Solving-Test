import java.util.ArrayDeque

fun bracketBal(s: String): String {
    val stack = ArrayDeque<Char>()
    val mapping = mapOf(')' to '(', '}' to '{', ']' to '[')

    for (char in s) {
        when (char) {
            '(', '{', '[' -> stack.push(char)
            ')', '}', ']' -> {
                if (stack.isEmpty() || stack.pop() != mapping[char]) {
                    return "NO"
                }
            }

        }
    }
    return if (stack.isEmpty()) "YES" else "NO"
}