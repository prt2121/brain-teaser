import com.google.common.truth.Truth.assertThat
import org.junit.Test as test

/**
 * Created by pt2121 on 11/22/15.
 */
class scanTest {

  fun <A, B> Iterable<A>.scanl(initial: B, f: (B, A) -> B): List<B> {
    return listOf(initial).plus(if (this.count() == 0) {
      emptyList()
    } else {
      this.drop(1).scanl(f(initial, this.first()), f)
    })
  }

  fun pickEnough(list: List<Int>, enough: Int): List<Int>? {
    return list
        .scanl(0 to 0) {
          pair, x ->
          x to (x + pair.second)
        }
        .drop(1)
        .takeWhile {
          pair ->
          val (x, soFar) = pair
          soFar - x < enough
        }
        .map { it.first }
  }

  @test fun test01() {
    assertThat(listOf(4, 2, 4).scanl(64) {
      a, b ->
      a / b
    }).isEqualTo(listOf(64, 16, 8, 2))
  }

  @test fun test02() {
    assertThat(listOf(1, 2, 3).scanl(4) {
      x, y ->
      2 * x + y
    }).isEqualTo(listOf(4, 9, 20, 43))
  }

  @test fun test03() {
    assertThat(pickEnough(listOf(5, 8, 0, 0, 8), 10)).isEqualTo(listOf(5, 8))
  }

}