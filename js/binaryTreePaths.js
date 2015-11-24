function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
  this.visited = false;
}

var result = [];

/**
 * @param {TreeNode} root
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

var bfs = function(node) {
  var ret = [];
  var queue = [];
  queue.push(node);
  ret.push(node.val);
  node.visited = true
  while(queue.length > 0) {
    var n = queue.shift()
    if (n.left !== null && !n.left.visited) {
      n.left.visited = true;
      queue.push(n.left);
      ret.push(n.left.val);
    }
    if (n.right !== null && !n.right.visited) {
      n.right.visited = true;
      queue.push(n.right);
      ret.push(n.right.val);
    }
  }
  return ret;
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

// new dfs(three);

console.log(new bfs(three))
