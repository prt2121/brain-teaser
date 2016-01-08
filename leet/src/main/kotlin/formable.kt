/**
 * Created by pt2121 on 1/8/16.
 */
// check if the str can be created from characters in the doc
// assuming alphanumeric only inputs
fun formable(str: String, doc: String): Boolean {
  if (str.isNullOrBlank()) throw IllegalArgumentException("str cannot be null or blank!")

  var chars = doc.fold(Array(256) { 0 }) {
    acc, c ->
    if (c.isLetterOrDigit())
      acc[c.toInt()] = acc[c.toInt()] + 1
    acc
  }

  return str.all {
    val count = chars[it.toInt()]
    if (count > 0) {
      chars[it.toInt()] = chars[it.toInt()] - 1
      true
    } else {
      false
    }
  }
}