package com.pt2121.algo

import scala.collection.mutable.HashMap

/**
 * https://www.youtube.com/watch?v=ENyox7kNKeY
 * http://cs.nyu.edu/courses/fall11/CSCI-GA.1170-003/TextAlignment.pdf
 */
object TextJustification {

  // length of the line from word at pos i to j
  def length(l: Array[Int], i: Int, j: Int): Int = {
    (0 /: l.slice(i - 1, j))(_ + _) + j - i + 1 //j - i + 1 is space between the words..
  }

  def bad(gap: Int): Int = Math.pow(gap, 3).toInt

  def badness(l: Array[Int], i: Int, j: Int, L: Int) =
    bad(L - length(l, i, j))

  def split(text: String) = text.split("\\s+")

  /*
   * http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/
   * 6-006-introduction-to-algorithms-fall-2011/lecture-videos/MIT6_006F11_lec20_orig.pdf   *
   */

  /**
   * iterative version
   *
   * @return map (end, start)
   */
  def splitLine2(words: Array[String], L: Int) = {
    // array of the lengths of the words
    val l = words.map(_.length)
    // number of words in the text
    val n = words.length
    // m(i) is the total badness of the text l1,...,li
    val m = HashMap(0 -> 0)

    // map of an end position to a start position. (word position) 
    val result: HashMap[Int, Int] = HashMap()

    // loop on i going up to n
    (1 until n + 1).foreach { i =>

      val sum: HashMap[Int, Int] = HashMap()
      var k = i // the last line starts with lk
      while (length(l, k, i) <= L && k > 0) {
        sum(bad(L - length(l, k, i)) + m(k - 1)) = k
        k = k - 1 // go from the back
      }
      m(i) = sum.minBy(_._1)._1
      result(i) = sum(m(i))
    }
    result
  }

  def printMap(m1: HashMap[Int, Int]) {
    for ((k, v) <- m1) printf("key: %s, value: %s\n", k, v)
  }

  def main(args: Array[String]) {
    val test = "This is an example of text justification."
    val L = 16
    val m = splitLine2(split(test), L)
  }
}


  //   "This    is    an",
  //   "example  of text",
  //   "justification.  "

  //    var line = 1
  //    while (n > 1) {
  //      println("line " + line + " : " + result(n) + " -> " + n)
  //      n = result(n) - 1
  //      line = line + 1
  //    }
  //    line 1 : 7 -> 7
  //	line 2 : 4 -> 6
  //    line 3 : 1 -> 3

  // key: 2, value: 1
  // key: 5, value: 4
  // key: 4, value: 3
  // key: 7, value: 7
  // key: 1, value: 1
  // key: 3, value: 1
  // key: 6, value: 4
