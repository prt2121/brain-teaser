package com.pt2121.algo

object LongestPalindromicSubstring {

  // brute force
  def f1(str: String) = {
    val p = for {
      i <- 2 to str.size;
      s <- str.sliding(i) if s == s.reverse
    } yield s
    if (p.isEmpty)
      ""
    else
      p.maxBy(_.size)
  }

  // dynamic programming
  def f2(str: String) = {
    val n = str length
    var begin = 0
    var maxLen = 1
    var table = Array.ofDim[Boolean](100, 60)
    val zipped = str.zip(str.tail)
    def mark(i: Int) = {
      table(i)(i + 1) = true
      begin = i
      maxLen = 2
    }
    Array.tabulate(zipped.length) { i => mark(i) }
    val r1 = 3 until (n + 1)
    for (len <- 3 until (n + 1); i <- 0 until n - len + 1) {
      val j = i + len - 1
      if (str(i) == str(j) && table(i+1)(j-1)) {
        table(i)(j) = true;
        begin = i;
        maxLen = len;
      }
    }
    str.substring(begin, maxLen)
  }

  def main(args: Array[String]) {
    val str = "nolemonnomelon"
    println(f2(str))
  }

}