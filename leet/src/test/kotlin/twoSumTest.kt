import com.google.common.truth.Truth.assertThat
import kotlin.test.assertNull
import org.junit.Test as test

class twoSumTest {

  inline fun testUnsorted(f: (Array<Int>, Int) -> Pair<Int, Int>?) {
    val a1 = intArrayOf(9, 1, 5, 3, 2, 7).toTypedArray()
    assertThat(f(a1, 7)).isEqualTo(Pair(3, 5))
    val a2 = intArrayOf(1, 3, 2, 7).toTypedArray()
    assertNull(f(a2, 7))
    val a3 = intArrayOf(5, 5).toTypedArray()
    assertThat(f(a3, 10)).isEqualTo(Pair(1, 2))
  }

  @test fun testTwoSumBruteForce() {
    testUnsorted(::twoSumBruteForce)
  }

  @test fun testTwoSumHashMap() {
    testUnsorted(::twoSumHashMap)
  }
}