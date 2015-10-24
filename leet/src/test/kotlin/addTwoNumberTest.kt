/**
 * Created by pt2121 on 10/24/15.
 */
import com.google.common.truth.Truth.assertThat
import org.junit.Test as test

class addTwoNumbersTest {
  @test fun addTwoNumbersTest() {
    assertThat(addTwoNumbers(listOf(9, 8, 1), listOf(9, 9, 9))).isEqualTo(listOf(8, 8, 1, 1))
    assertThat(addTwoNumbers(listOf(2, 4, 5), listOf(5, 6, 4))).isEqualTo(listOf(7, 0, 0, 1))
  }
}