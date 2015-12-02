import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by pt2121 on 12/2/15.
 */
class kthSmallestBstTest {

  val n5 = TreeNode(5)
  val n7 = TreeNode(7, n5, null)
  val n10 = TreeNode(10, n7, null)
  val n30 = TreeNode(30)
  val n20 = TreeNode(20, n10, n30)

  @Test fun testToOrderedList() {
    assertEquals(toOrderedList(n20), listOf(5, 7, 10, 20, 30))
  }

  @Test fun testKthSmallestV1() {
    assertEquals(kthSmallestV1(n20, 2), 7)
  }

  @Test fun testKthSmallestV2() {
    assertEquals(kthSmallestV2(n20, 2), 7)
  }
}