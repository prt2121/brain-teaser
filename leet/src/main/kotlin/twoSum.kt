import java.util.*

/**
 * Created by pt2121 on 10/24/15.
 */

// Given an array of integers, find two numbers such that they add up to a specific target number
// return indices of the two numbers such that they add up to the target

fun twoSumBruteForce(arr: Array<Int>, target: Int): Pair<Int, Int>? {
    for (i in 0..arr.lastIndex) {
        for (j in i..arr.lastIndex) {
            if (arr[i] + arr[j] == target)
                return Pair(i + 1, j + 1) // not zero base
        }
    }
    return null;
}

fun twoSumHashMap(arr: Array<Int>, target: Int): Pair<Int, Int>? {
    val map = HashMap<Int, Int>()
    for (i in 0..arr.lastIndex) {
        val current = arr[i]
        val k = target - current
        if (map.containsKey(k)) {
            return Pair(map[k]!! + 1, i + 1)
        } else {
            map.put(current, i)
        }
    }
    return null
}

//fun twoSumOfSortedArray(arr: Array<Int>, target: Int): Pair<Int, Int>? {
//
//}


fun main(args: Array<String>) {
}
