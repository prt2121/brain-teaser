import com.google.common.truth.Truth
import org.junit.Test

/**
 * Created by pt2121 on 1/12/16.
 */
class coinChangeTest {
  @Test fun test01() {
    Truth.assertThat(combinations(5, intArrayOf(1, 2, 3), 0)).isEqualTo(5)
  }

  @Test fun test02() {
    Truth.assertThat(combinations(4, intArrayOf(1, 2), 0)).isEqualTo(3)
  }
}