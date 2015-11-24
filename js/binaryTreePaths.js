function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

var result = [];

/**
 * @param {TreeNode} root
 * @return {string[]}
 */
var binaryTreePaths = function(root) {
  dfs(root)
};

var dfs = function(node) {
  result.push(node.val)
  if (node.left !== null) {
    dfs(node.left);
  }
  if (node.right !== null) {
    dfs(node.right);
  }
}

var zero = new TreeNode(0)
var one = new TreeNode(1)
var two = new TreeNode(2)
var three = new TreeNode(3)
var four = new TreeNode(4)
var five = new TreeNode(5)
var six = new TreeNode(6)
var seven = new TreeNode(7)
three.left = one
three.right = five
one.left = zero
one.right = two
five.left = four
five.right = seven
seven.left = six

new binaryTreePaths(three);

console.log(result)
