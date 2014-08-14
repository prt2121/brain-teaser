package com.pt2121.algo

object Question55to69 {

  sealed abstract class Tree[+T] {

    def countChildNodes: Int
    def countLeft: Int
    def countRight: Int
    def isLeaf: Boolean
    // TODO
    def isSymmetric: Boolean

    /**
     *  P67 (**) A string representation of binary trees.
     *  a(b(d,e),c(,f(g,)))
     */
    def myToString: String

    /**
     * P57 (**) Binary search trees (dictionaries).
     */
    def addValue[U >: T <% Ordered[U]](x: U): Tree[U]
  }
  case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
    override def toString = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"

    def countChildNodes: Int = countLeft + countRight
    def countLeft: Int = {
      if (left == End)
        0
      else
        1 + left.countLeft + left.countRight
    }
    def countRight: Int = {
      if (right == End)
        0
      else
        1 + right.countLeft + right.countRight
    }

    def isLeaf: Boolean = (left == End) && (right == End)

    override def myToString: String = {
      if (left == End && right == End)
        value.toString
      else
        value.toString + "(" + left.myToString + "," + right.myToString + ")"
    }

    override def isSymmetric: Boolean = {
      def symmetric(level: Int): Boolean = {
        val ns = Tree.nodesAtLevel(level, this)
        if (ns.forall(n => n == End || n.isLeaf))
          Tree.isMirror(ns)
        else {
          symmetric(level + 1)
        }
      }
      if (this.isLeaf)
        true
      else {
        symmetric(2)
      }
    }

    def addValue[U >: T <% Ordered[U]](x: U): Tree[U] = {
      if (x < value) Node(value, left.addValue(x), right)
      else Node(value, left, right.addValue(x))
    }
  }

  case object End extends Tree[Nothing] {
    override def toString = "."

    def countChildNodes: Int = countLeft + countRight
    def countLeft: Int = throw new Exception()
    def countRight: Int = throw new Exception()
    def isLeaf: Boolean = throw new Exception()
    override def myToString: String = ""
    override def isSymmetric: Boolean = true
    def addValue[U <% Ordered[U]](x: U) = Node(x)
  }

  object Node {
    def apply[T](value: T): Node[T] = Node(value, End, End)
  }

  object Tree {

    def fromList[T <% Ordered[T]](l: List[T]): Tree[T] =
      l.foldLeft(End: Tree[T])((r, e) => r.addValue(e))

    def nodesAtLevel[T](n: Int, t: Tree[T]): List[Tree[T]] = {
      if (n == 1)
        List(t)
      else {
        t match {
          case x: Node[T] => nodesAtLevel(n - 1, x.left) ++ nodesAtLevel(n - 1, x.right)
          case _ => Nil
        }
      }
    }

    def isMirror[T](l: List[Tree[T]]): Boolean = {
      if (l.isEmpty)
        true
      else if ((l.head == End && l.last == End) ||
        (l.head != End && l.last != End))
        true && isMirror(l.tail.dropRight(1))
      else
        false
    }

    //TODO:
    /**
     * P55 (**) Construct completely balanced binary trees.
     */
    def cBalanced[T](nodes: Int, value: T): List[Tree[T]] = nodes match {
      case n if n < 1 => List(End)
      case n if n % 2 == 1 => {
        val subtrees = cBalanced(n / 2, value)
        subtrees.flatMap(l => subtrees.map(r => Node(value, l, r)))
      }
      case n if n % 2 == 0 => {
        val lesserSubtrees = cBalanced((n - 1) / 2, value)
        val greaterSubtrees = cBalanced((n - 1) / 2 + 1, value)
        lesserSubtrees.flatMap(l => greaterSubtrees.flatMap(g => List(Node(value, l, g), Node(value, g, l))))
      }
    }
  }

  def main(args: Array[String]): Unit = {
//    val tmp = Node('a',
//      Node('b', Node('d'), Node('e')),
//      Node('c', End, Node('f', Node('g'), End)))
//    val t2 = Node('a', Node('b', Node('d', End, Node('f')), End), Node('c', End, Node('e', Node('g'), End)))
//    println(t2.myToString)
//    println(t2.isSymmetric)    
    //println(Tree.isMirror(Tree.nodesAtLevel(4, t2)))
    
    println(Tree.fromList(List(5, 3, 18, 1, 4, 12, 21)).isSymmetric)
    println(Tree.fromList(List(3, 2, 5, 7, 4)).isSymmetric)
  }

}
