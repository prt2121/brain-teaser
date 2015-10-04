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

  def main(args: Array[String]) {
    reverseWords(" a ")
    reverseWords(" abc xyz 1234 ") 
  }
}
