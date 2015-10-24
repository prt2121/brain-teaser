import java.util.*

/**
 * Created by pt2121 on 10/24/15.
 */

// Given an array of integers, find two numbers such that they add up to a specific target number
// return indices of the two numbers such that they add up to the target

fun twoSumBruteForce(arr: Array<Int>, target: Int): Pair<Int, Int>? {
  val lastIndex = arr.lastIndex
  arr.forEachIndexed { i, v ->
    for (j in (i + 1)..lastIndex) {
      if (v + arr[j] == target)
        return Pair(i + 1, j + 1) // not zero base
    }
  }
  return null;
}

fun twoSumHashMap(arr: Array<Int>, target: Int): Pair<Int, Int>? {
  val map = HashMap<Int, Int>()
  arr.forEachIndexed { i, current ->
    val k = target - current
    if (map.containsKey(k)) {
      return Pair(map[k]!! + 1, i + 1)
    } else {
      map.put(current, i)
    }
  }
  return null
}

fun twoSumOfSortedArray(arr: Array<Int>, target: Int): Pair<Int, Int>? {
  var rightIndex = arr.lastIndex
  var leftIndex = 0
  while (leftIndex < rightIndex) {
    val v = arr[leftIndex]
    val right = arr[rightIndex]
    if (v + right == target) {
      return Pair(leftIndex + 1, rightIndex + 1)
    } else if (v + right > target) {
      rightIndex--
    } else {
      leftIndex++
    }
  }
  return null
}

fun main(args: Array<String>) {
}
