package com.pt2121.algo

object Question1to4 {

  /**
   * Find the last element of a list.
   */
  def last(l: List[Int]): Int = l match {
    case x :: Nil => x
    case x :: xs => last(xs)
    case _ => throw new IllegalArgumentException
  }

  /**
   * Find the last but one element of a list.
   */
  def penultimate(l: List[Int]): Int = l match {
    case x :: _ :: Nil => x
    case x :: xs => penultimate(xs)
    case _ => throw new IllegalArgumentException
  }

  /**
   * Find the Kth element of a list.
   */
  def nth(n: Int, l: List[Int]): Int = (n, l) match {
    case (0, x :: xs) => x
    case (_, x :: xs) => nth(n - 1, xs)
    case _ => throw new IllegalArgumentException
  }

  /**
   * Find the number of elements of a list.
   */
  def length(l: List[Int]): Int = l match {
    case Nil => 0
    case x :: xs => 1 + length(xs)
    case _ => throw new IllegalArgumentException
  }

  def main(args: Array[String]): Unit = {
    println(length(List(1, 2, 3, 4)))
  }

}