/**
 * Created by pt2121 on 12/4/15.
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
fun lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode? {
  var n: TreeNode? = root
  while (n != null) {
    // if p and q are on different sides of the tree
    if ((n.value < p.value && n.value > q.value) || (n.value > p.value && n.value < q.value)) {
      return n
    }
    if (n.value > p.value && n.value > q.value) {
      n = n.left
    } else if (n.value < p.value && n.value < q.value) {
      n = n.right
    }
  }
  return null
}

fun lowestCommonAncestor2(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode {
  val m = root
  if (m.value > p.value && m.value < q.value) {
    return m
  } else if (m.value > p.value && m.value > q.value) {
    return lowestCommonAncestor2(root.left!!, p, q)
  } else if (m.value < p.value && m.value < q.value) {
    return lowestCommonAncestor2(root.right!!, p, q)
  }
  return root
}