import java.util.*

/**
 * Created by pt2121 on 12/28/15.
 */
object anagram {
  fun isAnagram(s: String, t: String): Boolean {
    return buildMap(s) == buildMap(t)
  }

  fun buildMap(s: String): Map<Char, Int> {
    return s.toList().foldRight(HashMap<Char, Int>()) {
      c, m ->
      if (c in m) {
        val i = m[c] ?: 1
        m.put(c, i + 1)
      } else {
        m.put(c, 1)
      }
      m
    }
  }
}