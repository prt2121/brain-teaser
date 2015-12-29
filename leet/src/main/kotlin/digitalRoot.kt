/**
 * Created by pt2121 on 12/28/15.
 */
// https://en.wikipedia.org/wiki/Digital_root
object digitalRoot {
  fun digitalRoot(num: Int): Int {
    if (num < 10) return num
    return num - (9 * Math.floor(((num - 1) / 9).toDouble())).toInt()
  }
}