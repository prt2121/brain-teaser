/**
 * Created by pt2121 on 11/21/15.
 *
 * https://leetcode.com/problems/climbing-stairs/
 */

object climb {

  fun climbingStairs001(n: Int): Int {
    if (n == 0) return 1
    if (n == 1) return 1
    if (n == 2) return 2
    return climbingStairs001(n - 1) + climbingStairs001(n - 2)
  }

  var map = emptyMap<Int, Int>()

  fun climbingStairs002(n: Int): Int {
    if (n == 0) return 1
    if (n == 1) return 1
    if (n == 2) return 2
    var n1 = if (map.containsKey(n - 1)) {
      map[n - 1]!!
    } else {
      climbingStairs002(n - 1)
    }
    var n2 = if (map.containsKey(n - 2)) {
      map[n - 2]!!
    } else {
      climbingStairs002(n - 2)
    }
    map.plus(n - 2 to n2)
    return n1 + n2
  }

}