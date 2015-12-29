import com.google.common.truth.Truth
import org.junit.Test

/**
 * Created by pt2121 on 12/28/15.
 */
class digitalRootTest {
  @Test fun test01() {
    Truth.assertThat(digitalRoot.digitalRoot(20)).isEqualTo(2)
  }

  @Test fun test02() {
    Truth.assertThat(digitalRoot.digitalRoot(1000)).isEqualTo(1)
  }

  @Test fun test03() {
    Truth.assertThat(digitalRoot.digitalRoot(77)).isEqualTo(5)
  }

  @Test fun test04() {
    Truth.assertThat(digitalRoot.digitalRoot(9)).isEqualTo(9)
  }
}