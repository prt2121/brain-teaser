/**
 * Created by pt2121 on 10/24/15.
 */
import com.google.common.truth.Truth.assertThat
import org.junit.Test as test

class longestSubstringTest {

  fun check(f: (String) -> Int) {
    assertThat(f("abcdcedf")).isEqualTo(4)
    assertThat(f("abcabcbb")).isEqualTo(3)
    assertThat(f("bbbbb")).isEqualTo(1)
  }

  @test fun testLongestSubstring() {
    check(::longestSubstring)
  }

}