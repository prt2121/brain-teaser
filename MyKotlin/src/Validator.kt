import java.util.*

/**
 * Created by pt2121 on 10/18/15.
 */
class Validator {

    private val map: Map<Char, Char> = hashMapOf(Pair('(', ')'), Pair('{', '}'), Pair('[', ']'))

    fun validParentheses(s: String): Boolean {
        val stack = Stack<Char>()
        s.forEach {
            c ->
            if (map.containsKey(c) || map.containsValue(c)) {
                if (map.containsKey(c)) {
                    stack.push(c)
                } else if (stack.isEmpty() || map.get(stack.pop()) != c) {
                    return false
                }
            }
        }
        return stack.isEmpty()
    }
}