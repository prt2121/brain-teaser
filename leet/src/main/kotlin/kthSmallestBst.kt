/**
 * Created by pt2121 on 12/2/15.
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 */
fun kthSmallestV2(root: TreeNode, k: Int): Int {
  val leftNum = numberOfNodes(root.left)
  if (leftNum == k - 1) {
    return root.value
  } else if (leftNum < k - 1) {
    return kthSmallestV2(root.right!!, k - leftNum - 1)
  } else {
    return kthSmallestV2(root.left!!, k)
  }
}

fun numberOfNodes(node: TreeNode?): Int {
  if (node == null) return 0
  val l = if (node.left == null) 0 else numberOfNodes(node.left)
  val r = if (node.right == null) 0 else numberOfNodes(node.right)
  return 1 + l + r
}

fun kthSmallestV1(root: TreeNode, k: Int): Int {
  return toOrderedList(root)[k - 1]
}

fun toOrderedList(node: TreeNode?): List<Int> {
  if (node == null) {
    return emptyList()
  } else {
    val ret = if (node.left != null) {
      toOrderedList(node.left).plus(node.value)
    } else {
      listOf(node.value)
    }
    val tmp = if (node.right != null) {
      toOrderedList(node.right)
    } else {
      emptyList<Int>()
    }
    return ret.plus(tmp)
  }
}

