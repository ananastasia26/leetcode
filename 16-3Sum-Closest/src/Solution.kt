import java.lang.Math.abs
import java.lang.Math.min

class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        val numberToInfo = hashMapOf<Int, NumberInfo>()

        nums.forEach { number ->
            numberToInfo.putIfAbsent(number, NumberInfo())
            numberToInfo[number]!!.increase()
        }

        val sortedDistinctNumbers = numberToInfo.keys.sorted()

        var closestSum = nums[0] + nums[1] + nums[2]
        var minDif = abs(target - closestSum)

        var leftPointer = 0
        while (leftPointer < sortedDistinctNumbers.size ) {
            val leftNumber = sortedDistinctNumbers[leftPointer]
            numberToInfo[leftNumber]!!.takeNumberInUsage()

            val numberToStop = (leftNumber - target) * -0.5
            var rightPointer = sortedDistinctNumbers.size - 1
            while (rightPointer > 0 && (sortedDistinctNumbers[rightPointer] >= numberToStop || rightPointer == sortedDistinctNumbers.size - 1)) {
                val rightNumber = sortedDistinctNumbers[rightPointer]
                if (numberToInfo[rightNumber]!!.quantity <= 0) {
                    rightPointer--
                    continue
                }
                numberToInfo[rightNumber]!!.takeNumberInUsage()

                val complementaryNumber = -1 * (leftNumber + rightNumber - target)
                numberToInfo[complementaryNumber]?.let {
                    if (it.quantity > 0) {
                        return target
                    }
                }

                val closestNumber = findClosestNumber(sortedDistinctNumbers, numberToInfo,complementaryNumber)
                val currentDif = abs(target - (closestNumber + leftNumber + rightNumber))
                if (minDif > currentDif) {
                    minDif = currentDif
                    closestSum = closestNumber + leftNumber + rightNumber
                }
                numberToInfo[rightNumber]!!.freeNumberFromUsage()
                rightPointer--
            }
            numberToInfo[leftNumber]!!.freeNumberFromUsage()
            leftPointer++
        }

        return closestSum
    }

    private fun findClosestNumber(sortedNums: List<Int>, info: HashMap<Int, NumberInfo>,target: Int) : Int {
        var leftPointer = 0
        var rightPointer = sortedNums.size -1

        while (leftPointer != rightPointer && leftPointer + 1 != rightPointer) {
            val middlePointer = (leftPointer + rightPointer) / 2
            val middleNumber = sortedNums[middlePointer]
            if (target < middleNumber) {
                rightPointer = middlePointer
            } else {
                leftPointer = middlePointer
            }
        }
        if (leftPointer == rightPointer) {
            return sortedNums[leftPointer]
        }
        while (leftPointer > 0 && info[sortedNums[leftPointer]]!!.quantity <= 0) {
            leftPointer--
        }
        while (rightPointer < sortedNums.size - 1 && info[sortedNums[rightPointer]]!!.quantity <= 0) {
            rightPointer++
        }

        if (info[sortedNums[leftPointer]]!!.quantity <= 0) {
            return sortedNums[rightPointer]
        } else if (info[sortedNums[rightPointer]]!!.quantity <= 0) {
            return sortedNums[leftPointer]
        }

        if (abs(target - sortedNums[leftPointer]) < abs(target - sortedNums[rightPointer])) {
            return sortedNums[leftPointer]
        } else {
            return sortedNums[rightPointer]
        }
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
    println(solution.threeSumClosest(intArrayOf(1,1,1,5,5,5,5,5,5), 14)) //2
    println(solution.threeSumClosest(intArrayOf(-1,2,1,-4), 1)) //2
    println(solution.threeSumClosest(intArrayOf(0, 0, 0), 1)) //0
    println(solution.threeSumClosest(intArrayOf(0, 1, 2), 3)) //3
    println(solution.threeSumClosest(intArrayOf(0, 1, 2), 0)) //3
    println(solution.threeSumClosest(intArrayOf(-100,-98,-2,-1), -101)) //-101
    println(solution.threeSumClosest(intArrayOf(-43,57,-71,47,3,30,-85,6,60,-59,0,-46,-40,-73,53,68,-82,-54,88,73,20,-89,-22,39,55,-26,95,-87,-57,-86,28,-37,43,-27,-24,-88,-35,82,-3,39,-85,-46,37,45,-24,35,-49,-27,-96,89,87,-62,85,-44,64,78,14,59,-55,-10,0,98,50,-75,11,97,-72,85,-68,-76,44,-12,76,76,8,-75,-64,-57,29,-24,27,-3,-45,-87,48,10,-13,17,94,-85,11,-42,-98,89,97,-66,66,88,-89,90,-68,-62,-21,2,37,-15,-13,-24,-23,3,-58,-9,-71,0,37,-28,22,52,-34,24,-8,-20,29,-98,55,4,36,-3,-9,98,-26,17,82,23,56,54,53,51,-50,0,-15,-50,84,-90,90,72,-46,-96,-56,-76,-32,-8,-69,-32,-41,-56,69,-40,-25,-44,49,-62,36,-55,41,36,-60,90,37,13,87,66,-40,40,-35,-11,31,-45,-62,92,96,8,-4,-50,87,-17,-64,95,-89,68,-51,-40,-85,15,50,-15,0,-67,-55,45,11,-80,-45,-10,-8,90,-23,-41,80,19,29,7), 255)) //255
    println(solution.threeSumClosest(intArrayOf(-323,160,628,336,392,-216,-711,-406,12,-905,422,-705,-248,-924,558,527,-954,-516,549,332,-122,371,-730,-799,695,-983,-199,-158,734,-45,649,728,573,-303,197,52,-939,512,282,83,807,940,-925,-882,-812,-96,452,-814,-719,-161,28,473,-941,322,656,597,766,553,624,-637,-236,-106,-809,-372,531,-649,-180,-115,741,447,614,-873,-170,-81,181,-182,38,900,-761,654,-584,-277,-746,358,270,-505,-205,239,-532,-30,-142,985,556,928,-36,-284,491,-453,-371,-55,266,-860,-507,6,-961,-833,243,115,412,720,537,186,971,-354,154,-172,147,-716,528,-123,183,9,-269,-457,860,18,-460,297,631,742,-948,81,872,817,692,-311,-673,306,-918,-262,185,-953,64,-538,411,1000,423,-137,593,955,-589,-943,-751,-919,517,587,-34,-624,-479,572,151,249,-43,827,112,163,-362,655,-684,174,963,-274,179,-109,98,835,-949,389,-420,579,209,8,961,-396,-6,972,-897,-341,903,819,700,663,899,-3,-463,626,-923,-830,-459,798,-380,-89,94,-552,515,723,-128,716,602,-260,853,976,-178,824,-211,-913,589,882,-827,35,1,932,683,55,-407,-987,809,451,526,320,237,499,-546,316,-600,-842,489,-992,100,-134,923,765,-511,774,-876,679,814,-256,-130,337,-348,-718,431,327,402,-197,-741,355,495,330,-836,-501,-861,935,268,292,-399,583,-597,790,830,-426,-225,-80,-933,-969,-432,-893,837,167,395,-240,-350,26,126,508,-10,737,596,574,433,652,-212,109,-290,-204,-722,937,409,140,909,815,342,283,-810,-859,-590,429,-793,-74,-154,-91,-50,-411,647,-25,-660,-528,-191,-790,-315,354,610,-452,79), -3621))
}