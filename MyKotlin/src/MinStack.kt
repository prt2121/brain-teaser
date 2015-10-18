import java.util.*

/**
 * Created by pt2121 on 10/18/15.
 *
 * A stack that supports push, peek, top, and retrieving the minimum element in constant time
 */
public class MinStack<T : Comparable<T>>() {

    private val stack: Stack<T> = Stack()
    private val mins: Stack<T> = Stack()

    fun push(t: T) {
        stack.push(t)
        if (mins.isNotEmpty() && mins.peek() > t) {
            mins.push(t)
        } else {
            if (mins.empty()) {
                mins.push(t)
            } else {
                mins.push(mins.peek())
            }
        }
    }

    fun pop(): T {
        mins.pop()
        return stack.pop()
    }

    fun peek(): T {
        return stack.peek()
    }

    fun peekMin(): T {
        return mins.peek()
    }

}