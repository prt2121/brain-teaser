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
    assertThat(f("dbcdeabcdfg")).isEqualTo(7)
  }

  @test fun testLongestSubstring() {
    check(::longestSubstring)
  }

  @test fun testLongestSubList() {
//    assertThat(longestSubList("abcdcedf".toList())).isEqualTo(4)
//    assertThat(longestSubList("abcabcbb".toList())).isEqualTo(3)
    assertThat(longestSubList("bbbbb".toList())).isEqualTo(1)
    //assertThat(longestSubList(listOf(4, 2, 3, 4, 5, 1, 2, 3, 4, 7, 9))).isEqualTo(7)
  }

}