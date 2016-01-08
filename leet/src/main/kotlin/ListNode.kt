/**
 * Created by pt2121 on 1/7/16.
 */
// check if a linked-list has loop
data class ListNode<T>(
    val value: T,
    var next: ListNode<T>?
)

fun <T> hasLoop(head: ListNode<T>?): Boolean {
  if(head == null) throw IllegalArgumentException("dude, head cannot be null!")
  var fast = head
  var slow = head

  while (fast?.next?.next != null || slow?.next != null) {
    if (fast?.next?.next == slow?.next) {
      return true
    }
    fast = fast?.next?.next
    slow = slow?.next
  }

  return false
}