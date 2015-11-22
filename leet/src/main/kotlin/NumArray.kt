/**
 * Created by pt2121 on 11/22/15.
 *
 * Range Sum Query - Immutable
 *
 * There are many calls to sumRange function.
 * https://leetcode.com/problems/range-sum-query-immutable/
 */
class NumArray(val nums: Array<Int>) {
  var cache = emptyMap<Int, Int>()

  init {
    val last = nums.size - 1
    nums.forEachIndexed {
      index, element ->
      cache = cache.plus(index to nums.slice(index..last).sum())
    }
  }

  fun sumRange(i: Int, j: Int): Int {
    if (i < 0 || j < 0 || i > j || i >= nums.size || j >= nums.size)
      throw Exception("invalid index")
    val tmp = if (j == nums.size - 1) 0 else cache[j + 1]
    return cache[i]!! - tmp!!
  }
}

class NumArray2(val nums: Array<Int>) {
  var cache = emptyMap<Pair<Int, Int>, Int>()

  init {
    val last = nums.size - 1
    nums.forEachIndexed {
      index, element ->
      (index..last).forEach {
        i ->
        val key = index to i
        cache = cache.plus(key to nums.slice(index..i).sum())
      }
    }
  }

  fun sumRange(i: Int, j: Int): Int {
    if (i < 0 || j < 0 || i > j || i >= nums.size || j >= nums.size)
      throw Exception("invalid index")
    return cache[i to j]!!
  }
}