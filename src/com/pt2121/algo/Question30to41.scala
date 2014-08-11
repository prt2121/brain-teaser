package com.pt2121.algo

class MyInt(val i: Int) {

  implicit def toMyInt(i: Int) = new MyInt(i)

  /**
   * P31 (**) Determine whether a given integer number is prime.
   */
  def isPrime: Boolean = {
    i > 1 && (2 until Math.sqrt(i).ceil.toInt).foldLeft(true) {
      (acc, e) =>
        acc && (i % e != 0)
    }
  }

  /**
   * P33 (*) Determine whether two positive integer numbers are coprime.
   */
  def isCoprimeTo(that: Int): Boolean = MyInt.gcd(i, that) == 1

  /**
   * P34 (**) Calculate Euler's totient function phi(m).
   */
  def totient: Int = (1 to i) filter { i.isCoprimeTo(_) } length

  /**
   * P35 (**) Determine the prime factors of a given positive integer.
   */
  def primeFactors: List[Int] = {
    def p(n: Int, s: Stream[Int]): List[Int] = {
      if (n.isPrime) List(n)
      else if (n % s.head == 0) s.head :: p(n / s.head, s)
      else p(n, s.tail)
    }
    p(i, MyInt.primes)
  }

  def pack[A](ls: List[A]): List[List[A]] = {
    if (ls.isEmpty) List(List())
    else {
      val (packed, next) = ls span { _ == ls.head }
      if (next == Nil) List(packed)
      else packed :: pack(next)
    }
  }

  def encode[A](ls: List[A]): List[(A, Int)] =
    pack(ls) map { e => (e.head, e.length) }

  def primeFactorMultiplicity: List[(Int, Int)] = encode(i.primeFactors)

  def totient2: Int = i.primeFactorMultiplicity.foldLeft(1) { (r, f) =>
    f match { case (p, m) => r * (p - 1) * Math.pow(p, m - 1).toInt }
  }

  /**
   * P40 (**) Goldbach's conjecture.
   */
  def goldbach = {
    val s = MyInt.primes.dropWhile(p => {
      !(i - p).isPrime
    })
    (s.head, i - s.head)
  }

}

object MyInt {

  implicit def toMyInt(i: Int) = new MyInt(i)

  def sieve(s: Stream[Int]): Stream[Int] = {
    s.head #:: sieve(s.tail.filter(x => x % s.head != 0))
  }
  val primes = sieve(Stream.from(2))
  /**
   * P32 (**) Determine the greatest common divisor of two positive integer numbers.
   */
  def gcd(m: Int, n: Int): Int = {
    if (m == n)
      m
    else {
      val min = Math.min(m, n)
      gcd(min, Math.abs(m - n))
    }
  }

  /**
   * P39 (*) A list of prime numbers.
   */
  def listPrimesinRange(l: Seq[Int]) =
    primes.dropWhile(_ < l.head).takeWhile(_ <= l.last).toList

    /**
     * P41 (**) A list of Goldbach compositions.
     */
  def printGoldbachList(l: Seq[Int]) = {
    l filter (_ % 2 == 0) foreach { x =>      
      val g = x.goldbach
      println(x + " = " + g._1 + '+' + g._2)
    }
  }

}

object Question30to41 {

  implicit def toMyInt(i: Int) = new MyInt(i)

  def main(args: Array[String]): Unit = {
    //    println(isPrime(13))
    //    println(isPrime(11))
    //    println(isPrime(104729))
    //    println(MyInt.gcd(18, 27))
    //    println(17.isPrime)
    //    println(3.isCoprimeTo(3))
    //    println(11.totient)
    //    println(16.primeFactors)
    //    println(16.primeFactorMultiplicity)
    //    println(MyInt.listPrimesinRange(7 to 31))
    //println(23.isPrime)
    //println(28.goldbach)
    MyInt.printGoldbachList(9 to 20)

  }

}