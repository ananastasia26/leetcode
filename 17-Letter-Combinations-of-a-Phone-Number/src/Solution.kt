class Solution {

    private val digitToLetters = hashMapOf(
        Pair("2", listOf("a", "b", "c")),
        Pair("3", listOf("d", "e", "f")),
        Pair("4", listOf("g", "h", "i")),
        Pair("5", listOf("j", "k", "l")),
        Pair("6", listOf("m", "n", "o")),
        Pair("7", listOf("p", "q", "r", "s")),
        Pair("8", listOf("t", "u", "v")),
        Pair("9", listOf("w", "x", "y", "z"))
    )

    fun letterCombinations(digits: String): List<String> {
        if(digits.isEmpty()) {
            return listOf()
        }

        val currentNumber = digits[0].toString()
        var previousCombinations= letterCombinations(digits.substring(1))

        if(previousCombinations.isEmpty()) {
            previousCombinations = arrayListOf("")
        }

        val newCombinations = arrayListOf<String>()

        digitToLetters[currentNumber]!!.forEach { char ->
            previousCombinations.forEach { previousCombination ->
                newCombinations.add("$char$previousCombination")
            }
        }

        return newCombinations
    }
}

fun main() {
    val solution = Solution()
    println(solution.letterCombinations("23"))
    println(solution.letterCombinations(""))
    println(solution.letterCombinations("2"))
}