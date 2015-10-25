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
    // if repeat, clear flag
    while (existLetter[c.toInt()]) {
      existLetter[s[i].toInt()] = false
      i++
    }
    existLetter[c.toInt()] = true
    maxLen = Math.max(j - i + 1, maxLen)
  }
  return maxLen
}
