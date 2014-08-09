package com.pt2121.algo

object Question11to20 {

  /**
   * P9
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
   * P10
   * Run-length encoding of a list.
   */
  def encode[T](ls: List[T]): List[(Int, T)] = {
    val l = pack(ls)
    l.map(e => {
      (e.length, e(0))
    })
  }

  /**
   * P11
   * Modified run-length encoding.
   */
  def encodeModified[T](ls: List[T]): List[Any] = {
    encode(ls) map {
      t => if (t._1 == 1) t._2 else t
    }
  }

  /**
   * P12
   * Decode a run-length encoded list.
   */
  def decode[T](ls: List[(Int, T)]): List[T] = {
    ls.flatMap { t =>
      List.fill(t._1)(t._2)
    }
  }

  /**
   * P13
   * Run-length encoding of a list (direct solution).
   */
  def encodeDirect[T](ls: List[T]): List[(Int, T)] = {
    ls.foldLeft(List[(Int, T)]())((acc, e) => {
      if (acc.isEmpty || acc.last._2 != e)
        acc :+ (1, e)
      else {
        val v = acc.last._1 + 1
        acc.dropRight(1) :+ (v, e)
      }
    })
  }

  /**
   * P13
   * a better solution!
   */
  def encodeDirect2[A](ls: List[A]): List[(Int, A)] =
    if (ls.isEmpty) Nil
    else {
      val (packed, next) = ls span { _ == ls.head }
      (packed.length, packed.head) :: encodeDirect2(next)
    }

  /**
   * P14
   * Duplicate the elements of a list.
   */
  def duplicate[A](ls: List[A]): List[A] = ls match {
    case Nil => List()
    case x :: Nil => List(x, x)
    case head :: tail => List(head, head) ++ duplicate(tail)
  }

  /**
   * P14
   * a better solution!
   */
  def duplicate2[A](ls: List[A]): List[A] = ls flatMap { e => List(e, e) }

  def duplicateN[A](i: Int, ls: List[A]): List[A] = ls flatMap {
    e => List.fill(i)(e)
  }

  /**
   * P16 (**) Drop every Nth element from a list.
   */
  def drop[A](i: Int, ls: List[A]): List[A] = {
    ls.grouped(3).flatMap { _.take(2) }.toList
  }

  /**
   * P17 (*) Split a list into two parts.
   */
  def split[T](n: Int, ls: List[T]): (List[T], List[T]) =
    (ls.take(n), ls.drop(n))

  /**
   * P18 (**) Extract a slice from a list.
   */
  def slice[T](i: Int, k: Int, ls: List[T]): List[T] =
    if (k < ls.length)
      ls.drop(i).dropRight(k - i)
    else
      ls.drop(i)

  /**
   * P19 (**) Rotate a list N places to the left.
   */
  def rotate[T](n: Int, ls: List[T]): List[T] = n match {
    case 0 => ls
    case n if n > 0 => ls.drop(n) ++ ls.take(n)
    case n if n < 0 => ls.drop(ls.length + n) ++ ls.take(ls.length + n)
  }

  /**
   * P20 Remove the Kth element from a list.
   */
  def removeAt[T](n: Int, ls: List[T]): (List[T], T) = (n, ls) match {
    case (0, l) => (l.tail, l.head)
    case (_, Nil) => throw new NoSuchElementException
    case (x, xs) => {
      val tmp = removeAt(x-1, xs.tail)
      (xs.head :: tmp._1, tmp._2)
    }
  }

  def main(args: Array[String]): Unit = {
    //println(encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
    //println(encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
    //println(decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))))
    //    println(encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
    //    println(duplicateN(3, List('a, 'b, 'c, 'c, 'd)))
    //    println(drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    //    println(split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    //    println(slice(3, 70, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(removeAt(1, List('a, 'b, 'c, 'd)))
  }

}
