/**
 * Created by pt2121 on 1/5/16.
 */

fun <T : Comparable<T>> binarySearch(ls: List<T>?, target: T): Boolean {
  if (ls == null || ls.isEmpty())
    return false

  if (ls.size == 1)
    return ls.first() == target

  val middle = (ls.size / 2).toInt() - 1
  val item = ls[middle]

  return if (item == target) {
    true
  } else if (item > target) {
    binarySearch(ls.subList(0, middle), target)
  } else {
    binarySearch(ls.subList(middle + 1, ls.size), target)
  }

}