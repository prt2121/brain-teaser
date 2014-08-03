package com.pt2121.algo

import scala.collection.mutable.HashMap

object Fibonacci {

  /**
   * simple recursion
   */
  def fib1(n: Int): Long = {
    if (n <= 2)
      1
    else
      fib1(n - 1) + fib1(n - 2)
  }
  
  /**
   * Dynamic Programming
   * https://www.youtube.com/watch?v=OQ5jsbhAv_M
   */
  val m: HashMap[Int, Long] = HashMap()
  def fib2(n: Int): Long = {
    if (m.contains(n))
      m.get(n).get
    else {
      val f = if (n <= 2)
        1
      else
        fib2(n - 1) + fib2(n - 2)
      m.put(n, f)
      f
    }
  }
  
  def main(args: Array[String]) {
    val n = 50
    val start1 = System.nanoTime
    val f1 = fib1(n)
    val time1 = System.nanoTime - start1
    val start2 = System.nanoTime
    val f2 = fib2(n)
    val time2 = System.nanoTime - start2
    assert(f1 == f2, println("bummer!"))    
    println(time1 - time2)
    println(f1)
    println(f2)
    
  }
}

//  var a = Array(1, 1, 2, 3, 5)
//  def fib3(n: Int): Int = {
//    if (a.length >= n)
//      a(n - 1)
//    else {
//      val f = if (n <= 2)
//        1
//      else
//        fib3(n - 1) + fib3(n - 2)
//      a = a :+ f
//      f
//    }
//  }