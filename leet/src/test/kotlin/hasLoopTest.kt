import com.google.common.truth.Truth.assertThat
import org.junit.Test as test
/**
 * Created by pt2121 on 1/7/16.
 */
class hasLoopTest {

  @test fun testLoop01() {
    val n5 = ListNode(5, null)
    val n4 = ListNode(4, n5)
    val n3 = ListNode(3, n4)
    val n2 = ListNode(2, n3)
    val n1 = ListNode(1, n2)
    assertThat(hasLoop(n1)).isEqualTo(false)
  }

  @test fun testLoop02() {
    var n4 = ListNode(4, null)
    val n3 = ListNode(3, n4)
    val n2 = ListNode(2, n3)
    val n1 = ListNode(1, n2)
    n4.next = ListNode(5, n1)
    assertThat(hasLoop(n1)).isEqualTo(true)
  }

}