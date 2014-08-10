package com.pt2121.algo

object Question30to41 {

  /**
   * P31 (**) Determine whether a given integer number is prime.
   */
  def isPrime(i: Int): Boolean = {
    (2 until Math.sqrt(i).ceil.toInt).foldLeft(true) {
      (acc, e) =>
        acc && (i % e != 0)
    }
  }

  def main(args: Array[String]): Unit = {
    println(isPrime(13))
    println(isPrime(11))
    println(isPrime(104729))
    println(Math.sqrt(17).ceil.toInt)
  }
  
  
  
}