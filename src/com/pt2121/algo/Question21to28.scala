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

  def flatMapSublists[A, B](ls: List[A])(f: (List[A]) => List[B]): List[B] =
    ls match {
      case Nil => Nil
      case sublist @ (_ :: tail) => f(sublist) ::: flatMapSublists(tail)(f)
    }

  /**
   * P26 (**) Generate the combinations of K distinct objects chosen from the N elements of a list.
   */
  def combinations[A](n: Int, ls: List[A]): List[List[A]] =
    if (n == 0) List(Nil)
    else flatMapSublists(ls) { sl =>
      combinations(n - 1, sl.tail) map { sl.head :: _ }
    }

  /**
   * P27 (**) Group the elements of a set into disjoint subsets.
   */
  def group[T](ns: List[Int], ls: List[T]): List[List[List[T]]] = (ns, ls) match {
    case (last :: Nil, xs) if (last == xs.length) => List(List(xs))
    case (head :: tail, xs) => {
      for {
        com <- combinations(head, xs)
        ys <- group(tail, xs diff com)
      } yield com :: ys
    }
  }

  def groupSol[A](ns: List[Int], ls: List[A]): List[List[List[A]]] = ns match {
    case Nil => List(Nil)
    case n :: ns => combinations(n, ls) flatMap { c =>
      groupSol(ns, ls diff c) map { c :: _ }
    }
  }

  /**
   * P28 (**) Sorting a list of lists according to length of sublists.
   * a
   */
  def lsort[T](ls: List[List[T]]): List[List[T]] =
    ls.sorted(Ordering.by[List[T], Int](_.length))

  def pack[A](ls: List[A]): List[List[A]] = {
    if (ls.isEmpty) List(List())
    else {
      val (packed, next) = ls span { _ == ls.head }
      if (next == Nil) List(packed)
      else packed :: pack(next)
    }
  }

  // Run-length encoding of a list.
  def encode[A](ls: List[A]): List[(Int, A)] =
    pack(ls) map { e => (e.length, e.head) }

  //http://stackoverflow.com/questions/6051302/what-does-colon-underscore-star-do-in-scala
  /**
   * P28 (**) Sorting a list of lists according to length of sublists.
   * b
   */
  def lsortFreq[T](ls: List[List[T]]): List[List[T]] = {
    val freqs = Map(encode(ls map { _.length } sortWith { _ < _ }) map { _.swap }: _*)
    ls sortWith { (e1, e2) => freqs(e1.length) < freqs(e2.length) }
  }

  def main(args: Array[String]): Unit = {
    //    println(insertAt('new, 4, List('a, 'b, 'c, 'd)))
    //    println(range(2, 5))
    //    println(randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)))
    //    println(lotto(6, 49))
    //    println(randomPermute(List('a, 'b, 'c, 'd, 'e, 'f)))
    //    println(combinations(3, List('a, 'b, 'c, 'd, 'e, 'f)))
    //    println(combinations(3, List('a, 'b, 'c, 'd, 'e, 'f)).size)
    //println(combinations(2, List('a, 'b, 'c, 'd, 'e, 'f)))
    //List(List(List(Aldo, Beat, Carla), List()), List(List(Aldo, Carla, Carla), List(Beat)), List(List(Beat, Beat, Carla), List(Aldo)), List(List(Beat, Carla, Carla), List(Aldo)), List(List(Carla, Beat, Carla), List(Aldo)), List(List(Carla, Carla, Carla), List(Aldo, Beat)))
    println(group(List(1, 2), List("Aldo", "Beat", "Carla")))
    lazy val g1 = group(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
    lazy val g2 = groupSol(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
    println(g1 == g2)
    println(lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))))
    println(lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))))
  }

}