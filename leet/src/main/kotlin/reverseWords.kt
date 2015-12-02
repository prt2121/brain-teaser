/**
 * Created by pt2121 on 12/2/15.
 *
 * Reverse words in string
 */
fun reverseWords1(input: String): String {
  return input.split(" ")
      .map { it.reversed() }
      .fold("", { acc, str -> acc + " " + str })
      .trim()
}

fun reverseWords2(input: String): String {
  var out = ""
  var current = " "
  input.forEach {
    c ->
    if (c == ' ') {
      out = out.plus(current)
      current = " "
    } else {
      current = c.plus(current)
    }
  }
  return out.plus(current).trim()
}