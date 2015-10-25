/**
 * Created by pt2121 on 10/25/15.
 *
 * https://leetcode.com/problems/search-a-2d-matrix/
 * 74 Search a 2D Matrix
 */

// binary search (recursive)
// n * m matrix convert to an array => matrix[x][y] => a[x * m + y]
// an array convert to n * m matrix => a[x] =>matrix[x / m][x % m];
fun <T : Comparable<T>> searchMatrixRec(matrix: Array<Array<T>>, target: T): Boolean {
  val n = matrix.size
  val m = matrix.first().size
  var l = 0
  var r = m * n - 1
  fun search(l: Int, r: Int): Int {
    if (l == r) return l
    val mid = (l + r - 1).shr(1)
    if (matrix[mid / m][mid % m] < target)
      return search(mid + 1, r)
    else
      return search(l, mid)
  }

  val p = search(l, r)
  return matrix[p / m][p % m] == target
}

// binary search
fun <T : Comparable<T>> searchMatrix(matrix: Array<Array<T>>, target: T): Boolean {
  val n = matrix.size
  val m = matrix.first().size
  var l = 0
  var r = m * n - 1
  while (l != r) {
    val mid = (l + r - 1).shr(1)
    if (matrix[mid / m][mid % m] < target) {
      l = mid + 1
    } else {
      r = mid
    }
  }
  return matrix[r / m][r % m] == target
}

