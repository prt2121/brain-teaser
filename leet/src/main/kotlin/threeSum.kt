/**
 * Created by pt2121 on 11/20/15.
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * https://leetcode.com/problems/3sum/
 */
fun threeSum(arr: Array<Int>): List<Tripple> {
  var answer = listOf<Tripple>()
  arr.forEach {
    a ->
    val pairs = twoSum(0 - a, arr.filter { it -> it != a }.toTypedArray())
    pairs.forEach {
      answer = answer.plus(Tripple(a, it.first, it.second))
    }
  }
  return answer
}

fun twoSum(target: Int, arr: Array<Int>): List<Pair<Int, Int>> {
  var ls = emptyList<Pair<Int, Int>>()
  arr.forEach {
    it ->
    val x = target - it
    if (arr.contains(x)) {
      ls = ls.plus(Pair(x, it))
    }
  }
  return ls
}

// println(threeSum(arrayOf(-1, 0, 1, 2, -1, -4)))
// [-1 1 0, -1 0 1, 0 1 -1, 0 -1 1, 0 1 -1, 1 0 -1, 1 -1 0, 1 0 -1, 2 -1 -1, 2 -1 -1, -1 1 0, -1 0 1, -4 2 2]

data class Tripple(val i: Int, val j: Int, val k: Int) {
  override fun toString(): String {
    return i.toString() + " " + j.toString() + " " + k.toString()
  }
}