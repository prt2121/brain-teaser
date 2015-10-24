/**
 * Created by pt2121 on 10/24/15.
 *
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * https://leetcode.com/problems/add-two-numbers/
 */
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