package com.pt2121.algo

object Playground {

  def reverseWords(s: String): String = {
    var result = ""
    var currentWord = ""
    for (c <- s.toCharArray()) {
      if (c == ' ' && currentWord.length() != 0) {
        result = currentWord + " " + result
        currentWord = ""
      } else if(c != ' ' || currentWord.length() != 0) {
        currentWord = currentWord + c
      }
    }
    if (currentWord.length() != 0) {
      result = currentWord + " " + result
    }
    result trim
  }

  // imperative
  // 'In-place' reverse
  def reverseWords2(s: Array[Char]): String = {
    reverse(s, 0, s.size - 1)
    var i = 0
    for(j <- 0 to s.size) {
      if (j == s.length || s(j) == ' ') {
         reverse(s, i, j - 1)
         i = j + 1
      }
    }
    s.mkString
  }                                         //> reverseWords2: (s: Array[Char])String

  // imperative
  // reverse string 'in place'
  def reverse(s: Array[Char], begin: Int, end: Int) {
  var b = begin; var e = end
    while(b < e) {
      val tmp = s(b)
      s(b) = s(e)
      s(e) = tmp
      b = b + 1
      e = e - 1
    }
  }

  def main(args: Array[String]) {
    reverseWords(" a ")
    reverseWords(" abc xyz 1234 ")
    var test = "this is a test "
    println(reverseWords2(test.toCharArray))
  }
}
