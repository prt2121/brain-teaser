import java.util.*

/**
 * Created by pt2121 on 10/24/15.
 */

// Longest Substring Without Repeating Characters
/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/

Given a string, find the length of the longest substring without repeating characters.
 */
fun longestSubstring(s: String): Int {
  var existLetter = Array(256, { false })
  var i = 0
  var maxLen = 0
  s.forEachIndexed { j, c ->
    if (!existLetter[c.toInt()]) {
      existLetter[c.toInt()] = true
    } else {
      // if repeat, clear flag
      while (s[i] != c) {
        existLetter[s[i].toInt()] = false
        i++
      }
      i++
    }
    maxLen = Math.max(j - i + 1, maxLen)
  }
  return maxLen
}

fun <T> longestSubList(ls: List<T>): Int {
  var exist = HashSet<T>()
  var leftPointer = 0
  var longest = 0
  ls.forEachIndexed { rightPointer, element ->
    if (!exist.contains(element)) {
      exist.add(element)
    } else {
      while (ls[leftPointer] != element) {
        exist.remove(ls[leftPointer])
        leftPointer++
      }
      leftPointer++
    }
    println("")
    longest = Math.max(rightPointer - leftPointer + 1, longest)
  }
  return longest
}