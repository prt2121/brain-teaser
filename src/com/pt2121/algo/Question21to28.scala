package com.pt2121.algo

import scala.util.Random

object Question21to28 {

  /**
   * P21 (*) Insert an element at a given position into a list.
   */
  def insertAt[T](e: T, i: Int, ls: List[T]): List[T] = (i, ls) match {
    case (i, l) if i == 0 => e :: l
    case (i, _) if i < 0 => throw new IllegalArgumentException()
    case (i, h :: t) => h :: insertAt(e, i - 1, t)
  }

  /**
   * P22 (*) Create a list containing all integers within a given range.
   */
  def range(i: Int, j: Int): List[Int] = {
    if (i == j)
      List(j)
    else
      i :: range(i + 1, j)
  }

  def removeAt[A](n: Int, ls: List[A]): (List[A], A) = ls.splitAt(n) match {
    case (Nil, _) if n < 0 => throw new NoSuchElementException
    case (pre, e :: post) => (pre ::: post, e)
    case (pre, Nil) => throw new NoSuchElementException
  }

  /**
   * P23 (**) Extract a given number of randomly selected elements from a list.
   */
  def randomSelect[T](n: Int, ls: List[T]): List[T] = {
    if (n == 1) {
      List(ls(Random.nextInt(ls.size)))
    } else {
      val i = Random.nextInt(ls.size)
      ls(i) :: randomSelect(n - 1, removeAt(i, ls)._1)
    }
  }

  /**
   * P24 (*) Lotto: Draw N different random numbers from the set 1..M
   */
  def lotto(n: Int, m: Int): List[Int] = {
    randomSelect(n, range(1, m))
  }

  /**
   * P25 (*) Generate a random permutation of the elements of a list.
   */
  def randomPermute[T](ls: List[T]): List[T] = {
    randomSelect(ls.length, ls)
  }

  def main(args: Array[String]): Unit = {
    println(insertAt('new, 4, List('a, 'b, 'c, 'd)))
    println(range(2, 5))
    println(randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)))
    println(lotto(6, 49))
    println(randomPermute(List('a, 'b, 'c, 'd, 'e, 'f)))
  }

}