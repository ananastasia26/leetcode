class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
//        val sb = StringBuilder()
//        val minWordLength = strs.map { it.length }.min()
//      ~O(n^2)
//        for(i in 0 until minWordLength) {
//            val letter = strs[0][i]
//            val hasCommonIndexedLetter = strs.all { it[i] == letter }
//            if (hasCommonIndexedLetter) {
//                sb.append(letter)
//            } else {
//                break
//            }
//        }
//        return sb.toString()
        
        val sb = StringBuilder()
        val minLex = strs.min()
        val maxLex = strs.max()

        for (i in minLex.indices) {
            if (minLex[i] == maxLex[i]) {
                sb.append(minLex[i])
            } else {
                break
            }
        }

        return sb.toString()
    }
}

fun main() {
    val solution = Solution()
    val commonPrefix1 = solution.longestCommonPrefix(arrayOf("flower", "flow", "flight"))
    val commonPrefix2 = solution.longestCommonPrefix(arrayOf("dog","racecar","car"))
    println(commonPrefix1)
    println(commonPrefix2)
}