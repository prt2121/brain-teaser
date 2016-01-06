import com.google.common.truth.Truth
import org.junit.Test

/**
 * Created by pt2121 on 1/5/16.
 */
class binarySearchTest {

  @Test fun testBinarySearch01() {
    Truth.assertThat(binarySearch(listOf(1, 2, 3, 4, 5, 6, 7, 8), 6)).isEqualTo(true)
  }

  @Test fun testBinarySearch02() {
    Truth.assertThat(binarySearch(listOf(1, 2, 3, 4, 5, 6, 7), 6)).isEqualTo(true)
  }

  @Test fun testBinarySearch03() {
    Truth.assertThat(binarySearch(listOf(1, 3, 4, 5, 6, 7), 2)).isEqualTo(false)
  }

  @Test fun testBinarySearch04() {
    Truth.assertThat(binarySearch(listOf(1, 3, 4, 5, 6, 7, 9), 0)).isEqualTo(false)
  }

  @Test fun testBinarySearch05() {
    Truth.assertThat(binarySearch(listOf(1), 0)).isEqualTo(false)
  }

  @Test fun testBinarySearch06() {
    Truth.assertThat(binarySearch(listOf(1), 1)).isEqualTo(true)
  }
}