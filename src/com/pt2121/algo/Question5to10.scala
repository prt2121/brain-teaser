package com.pt2121.algo

import scala.annotation.tailrec

object Question4to10 {

  /**
   * Q5
   * Reverse a list.
   */
  def reverse(ls: List[Int]): List[Int] = {
    if (ls.length == 1)
      ls
    else
      reverse(ls.tail) :+ ls.head
  }

  /**
   * Q6
   * Find out whether a list is a palindrome.
   */
  def isPalindrome(ls: List[Int]): Boolean = {
    ls == ls.reverse
  }

  /**
   * Q7
   * Flatten a nested list structure.
   */
  def flatten(ls: List[Any]): List[Any] = ls flatMap {
    case ms: List[_] => flatten(ms)
    case e => List(e)
  }

  /**
   * Q8
   * Eliminate consecutive duplicates of list elements.
   */
  def compress[T](ls: List[T]): List[T] = {
    ls.foldLeft(List[T]())((acc, e) => {
      if (!acc.isEmpty && acc.last == e)
        acc
      else
        acc :+ e
    })
  }

  /**
   * Pack consecutive duplicates of list elements into sublists.
   */
  def pack[T](ls: List[T]): List[List[T]] = {
    ls.foldLeft(List[List[T]]())((acc, e) => {
      if (!acc.isEmpty && acc.last.last == e) {        
        acc.dropRight(1) :+ (acc.last :+ e)             
      } else
        acc :+ List[T](e)
    })
  }
  
  /**
   * Run-length encoding of a list.
   */
  def encode[T](ls: List[T]): List[(Int, T)] = {
    val l = pack(ls)
    l.map(e => {
      (e.length, e(0))
    })
  }

  def main(args: Array[String]): Unit = {
//    println(reverse(List(1, 2, 3, 4)))
//    println(isPalindrome(List(1, 1)))
//    println(flatten(List(List(1, 1), List(1, 2))))
//    println(compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
    println(pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
    println(encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }
}