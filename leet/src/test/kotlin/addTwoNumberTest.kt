/**
 * Created by pt2121 on 10/24/15.
 */
import com.google.common.truth.Truth.assertThat
import org.junit.Test as test

class addTwoNumbersTest {
  @test fun addNumbersTest() {
    var n1 = Node(2, null)
    var n2 = Node(4, null)
    var n3 = Node(5, null)
    n1.next = n2
    n2.next = n3

    var m1 = Node(5, null)
    var m2 = Node(6, null)
    var m3 = Node(4, null)
    m1.next = m2
    m2.next = m3

    var a1 = Node(7, null)
    var a2 = Node(0, null)
    var a3 = Node(0, null)
    var a4 = Node(1, null)
    a1.next = a2
    a2.next = a3
    a3.next = a4

    var expected: Node? = a1
    var result: Node? = addNumbers(n1, m1)

    while (result != null && expected != null) {
      println("result " + result.value)
      println("expected " + expected.value)
      assertThat(result.value).isEqualTo(expected.value)
      result = result.next
      expected = expected.next
    }

    if (result != null && expected == null) {
      throw Exception("longer than expected")
    }

    if (result == null && expected != null) {
      throw Exception("shorter than expected")
    }

  }

  @test fun addTwoNumbersTest() {
    assertThat(addTwoNumbers(listOf(9, 8, 1), listOf(9, 9, 9))).isEqualTo(listOf(8, 8, 1, 1))
    assertThat(addTwoNumbers(listOf(2, 4, 5), listOf(5, 6, 4))).isEqualTo(listOf(7, 0, 0, 1))
  }
}