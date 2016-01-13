/**
 * Created by pt2121 on 1/12/16.
 *
 * Find all combinations of coins when given some dollar value
 * http://stackoverflow.com/questions/1106929/find-all-combinations-of-coins-when-given-some-dollar-value
 */
fun combinations(dollars: Int, coins: IntArray, i: Int): Int {
  if (dollars < 0) return 0
  if (dollars == 0) return 1
  if (i == coins.size && dollars > 0 ) return 0
  return combinations(dollars - coins[i], coins, i) + combinations(dollars, coins, i + 1)
}
