package com.pt2121.algo

import scala.collection.mutable.HashMap

/**
 * Given n, find the number of different ways
 * to write n as the sum of 1, 3, 4
 */
object OneThreeFour {

  val m = HashMap[Int, Int](0 -> 1, 1 -> 1, 2 -> 1, 3 -> 2)

  def d(i: Int): Int = {
    if (m.contains(i))
      m(i)
    else
      d(i - 1) + d(i - 3) + d(i - 4)
  }

  def main(args: Array[String]): Unit = {
    println(d(5))
  }

}