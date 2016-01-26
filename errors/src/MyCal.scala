/**
  * Created by pt2121 on 1/25/16.
  */
object MyCal {
  def mean01(xs: Seq[Double]): Double =
    if (xs.isEmpty)
      throw new ArithmeticException("mean of empty list!")
    else xs.sum / xs.length

  // section 4.3 The Option data type
  def mean02(xs: Seq[Double]): Option[Double] =
    if (xs.isEmpty) None
    else Some(xs.sum / xs.length)

  // ex 4.2
  def variance(xs: Seq[Double]): Option[Double] = {
    mean02(xs).flatMap {
      mean =>
        if (xs.isEmpty) None
        else Some(xs.map { d => math.pow(d - mean, 2) }.sum / xs.size)
    }
  }

  def f(x: Int) = if (x > 2) Some(x) else None

  def main(args: Array[String]): Unit = {
    val s = Seq(1.0, 2.0, -3.0)
    println(s"mean ${mean01(s)}!")

    val seq = Seq()
    println(s"getOrElse ${mean02(seq).getOrElse(Double.MinValue)}!")
    println(s"getOrElse ${mean02(s).getOrElse(Double.MinValue)}!")

    println(s"orElse ${mean02(seq).orElse(Some(55))}!")
    println(s"orElse ${mean02(s).orElse(Some(55))}!")

    println(s"filter ${mean02(seq).filter(_ == 0)}!")
    println(s"filter ${mean02(s).filter(_ == 0)}!")

    println(s"map ${
      mean02(s).map {
        _ * 2
      }
    }")

    println(s"flatMap ${
      mean02(s).flatMap {
        d =>
          if (d == 0)
            None
          else
            Some(100 / d)
      }
    }")

    val ls = List(1, 2, 3, 4, 5)
    val ls2 = ls map f

    println(ls2)
  }
}
