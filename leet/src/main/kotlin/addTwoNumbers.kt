/**
 * Created by pt2121 on 10/24/15.
 *
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * https://leetcode.com/problems/add-two-numbers/
 */


class Node(var value: Int = 0, var next: Node? = null) {}

// O(N)
fun addNumbers(ls1: Node?, ls2: Node?): Node? {
  var num1 = ls1
  var num2 = ls2
  var current: Node? = Node()
  var next: Node?
  var ret: Node? = current
  var carry = false
  while (num1 != null && num2 != null) {
    next = Node()
    val x = num1.value + num2.value + if (carry) 1 else 0
    if (x > 9) {
      carry = true
      current!!.value = x - 10
      current.next = next
    } else {
      carry = false
      current!!.value = x
      current.next = next
    }
    current = next
    num1 = num1.next
    num2 = num2.next
  }
  if (carry) {
    current!!.value = 1
  }
  return ret
}

// functional
fun addTwoNumbers(num1: List<Int>, num2: List<Int>): List<Int> {
  val added = num1.zip(num2) {
    n1, n2 ->
    n1 + n2
  }.fold(Pair(listOf<Int>(), false)) {
    acc, n ->
    val x = if (acc.second) 1 + n else n
    if (x > 9) acc.first.plus(x - 10) to true
    else acc.first.plus(x) to false
  }
  return if (added.second) added.first.plus(1) else added.first
}

