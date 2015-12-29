import com.google.common.truth.Truth
import org.junit.Test

/**
 * Created by pt2121 on 12/29/15.
 */
class anagramTest {
  @Test fun test01() {
    Truth.assertThat(anagram.isAnagram("", "")).isTrue()
  }
  @Test fun test02() {
    Truth.assertThat(anagram.isAnagram("abc", "cab")).isTrue()
  }
  @Test fun test03() {
    Truth.assertThat(anagram.isAnagram("abc", "xab")).isFalse()
  }
  @Test fun test04() {
    Truth.assertThat(anagram.isAnagram("abc", "aabbcc")).isFalse()
  }
}