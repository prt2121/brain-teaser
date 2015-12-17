/**
  * Created by pt2121 on 12/17/15.
  */
object RNG {

  type Rand[+A] = RNG => (A, RNG)

  def unit[A](a: A): Rand[A] = rng => (a, rng)

  def map[A, B](rand: Rand[A])(f: A => B): Rand[B] = rng => {
    val (a, r) = rand(rng)
    (f(a), r)
  }

  case class SimpleRng(seed: Long) extends RNG {

    def nextInt: (Int, RNG) = {
      val newSeed = (seed * 0x5DEECE66DL + 0xBL) & 0xFFFFFFFFFFFFL
      val nextRng = SimpleRng(newSeed)
      val n = (newSeed >>> 16).toInt
      (n, nextRng)
    }
  }

}
