class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val numberToInfo = hashMapOf<Int, NumberInfo>()

        nums.forEach { number ->
            numberToInfo.putIfAbsent(number, NumberInfo())
            numberToInfo[number]!!.increase()
        }

        val sortedDistinctNumbers = numberToInfo.keys.sorted()

        var leftPointer = 0

        val result: ArrayList<List<Int>> = arrayListOf()

        while (leftPointer < sortedDistinctNumbers.size && sortedDistinctNumbers[leftPointer] <= 0) {
            val leftNumber = sortedDistinctNumbers[leftPointer]
            numberToInfo[leftNumber]!!.takeNumberInUsage()

            var rightPointer = sortedDistinctNumbers.size - 1

            while (rightPointer >= 0 && sortedDistinctNumbers[rightPointer] >= ((leftNumber * -0.5))) {
                val rightNumber = sortedDistinctNumbers[rightPointer]
                numberToInfo[rightNumber]!!.takeNumberInUsage()

                val complementaryNumber = -1 * (leftNumber + rightNumber)
                if (leftNumber <= -0.5 * rightNumber) {
                    numberToInfo[complementaryNumber]?.let {
                        if (it.quantity > 0) {
                            result.add(
                                listOf(
                                    leftNumber,
                                    complementaryNumber,
                                    rightNumber
                                )
                            )
                        }
                    }
                }

                numberToInfo[rightNumber]!!.freeNumberFromUsage()
                rightPointer--
            }
            numberToInfo[leftNumber]!!.freeNumberFromUsage()
            leftPointer++
        }

        return result
    }

    inner class NumberInfo {
        var quantity = 0

        fun increase() {
            quantity++
        }

        fun takeNumberInUsage() {
            quantity--
        }

        fun freeNumberFromUsage() {
            quantity++
        }
    }
}

fun main() {
    val solution = Solution()
    println(solution.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
    println(solution.threeSum(intArrayOf(0, 1, 1)))
    println(solution.threeSum(intArrayOf(0, 0, 0)))
    println(solution.threeSum(intArrayOf(1, 1, -2)))
    println(solution.threeSum(intArrayOf(-2, 0, 1, 1, 2)))
    println(solution.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4)))
}