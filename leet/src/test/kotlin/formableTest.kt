import com.google.common.truth.Truth.assertThat
import org.junit.Test as test
/**
 * Created by pt2121 on 1/8/16.
 */
class formableTest {

  @test fun test01() {
    val str = "kow"
    val doc = "I don't know"
    assertThat(formable(str, doc)).isEqualTo(true)
  }

  @test fun test02() {
    val str = "koow"
    val doc = "I don't know"
    assertThat(formable(str, doc)).isEqualTo(true)
  }

  @test fun test03() {
    val str = "kooow"
    val doc = "I don't know"
    assertThat(formable(str, doc)).isEqualTo(false)
  }

  @test fun test04() {
    val str = "ioodtknw"
    val doc = "I don't know"
    assertThat(formable(str, doc)).isEqualTo(false)
  }

  @test fun test05() {
    val str = "cow"
    val doc = "I don't know"
    assertThat(formable(str, doc)).isEqualTo(false)
  }

}
