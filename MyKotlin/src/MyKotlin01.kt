import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Created by pt2121 on 10/7/15.
 */

fun plusOne(digits: List<Int>): List<Int> {
    val (x, y) = (digits map { it + 1 }).foldRight(Pair(emptyList<Int>(), false), {
        i, pair ->
        val ls = pair.first
        val ten = pair.second
        val n = if (ten) i + 1 else i
        val t = n > 9
        val current = if (t) n - 10 else n
        Pair(listOf(current).plus(ls), t)
    })
    return if (y) {
        listOf(1).plus(x)
    } else {
        x
    }
}

fun palindromeNumber(num: Int): Boolean {
    val s = num.toString()
    return s == s.reversed()
}

// imperative
fun palindromeNumber2(num: Int): Boolean {
    var i = 0
    var n = num
    while (n > 0) {
        i = (n mod 10) + i * 10;
        n = n div 10
    }
    return i == num
}

fun palindromeNumber3(num: Int): Boolean {
    var divider = 1
    while (num div divider >= 10) {
        divider *= 10
    }
    var n = num
    while (n != 0) {
        val first = n div divider
        val last = n mod 10
        if (first != last) return false
        n = (n mod divider) div 10
        divider /= 100
    }
    return true
}

// imperative
fun mergeTwoSortedList(ls1: LinkedList<Int>, ls2: LinkedList<Int>): List<Int> {
    var i = 0
    var j = 0
    val len1 = ls1.size()
    val len2 = ls2.size()
    var l = listOf<Int>()
    while (i < len1 && j < len2) {
        var n1 = ls1.get(i)
        var n2 = ls2.get(j)
        if (n1 < n2) {
            l = l.plus(n1)
            i++
        } else {
            l = l.plus(n2)
            j++
        }
    }
    while (i < len1) {
        l = l.plus(ls1.get(i))
        i++
    }
    while (j < len2) {
        l = l.plus(ls2.get(j))
        j++
    }
    return l
}

fun addListOfNumbers(ls1: List<Int>, ls2: List<Int>): List<Int> {
    fun ten(l: List<Int>): Pair<List<Int>, List<Int>> {
        val ps = l.map {
            it ->
            Pair(it div 10, it mod 10)
        }
        return Pair(ps.map { it.first }, ps.map { it.second })
    }

    fun shiftAdd(ls: Pair<List<Int>, List<Int>>): List<Int> {
        val sum = ls.first
        val ten = ls.second
        return listOf(0).plus(ten).reversed().merge(sum.plus(0).reversed(), {
            x, y ->
            x + y
        }).reversed()
    }
    return shiftAdd(ten(ls1.merge(ls2, { x, y -> x + y })))
}

// Merge K Sorted Linked Lists
fun mergeKSortedLists(lists: List<LinkedList<Int>>): LinkedList<Int>? {
    fun isNotEmpty(lists: List<LinkedList<Int>>): Boolean {
        val k = lists.size()
        for (i in 1..k)
            if (lists.get(i - 1).isNotEmpty())
                return true
        return false
    }

    if (lists.size() == 0)
        return null
    val k = lists.size()
    val q = PriorityQueue<Int>(k)
    for (i in 1..k) {
        q.add(lists.get(i - 1).poll())
    }
    val ret = LinkedList<Int>()
    while (isNotEmpty(lists) || q.isNotEmpty()) {
        while (q.isNotEmpty()) {
            val x = q.poll()
            ret.add(x)
        }
        if (isNotEmpty(lists)) {
            for (i in 1..k) {
                q.add(lists.get(i - 1).poll())
            }
        }
    }
    return ret
}

// Definition for singly-linked list with a random pointer.
private data class RandomListNode(val label: Int) {
    var next: RandomListNode? = null
    var random: RandomListNode? = null

    override fun toString(): String {
        val n = next?.label ?: "null"
        val r = random?.label ?: "null"
        return "label: $label, next: $n, random: $r"
    }
}

fun copyRandomList(head: RandomListNode): RandomListNode {
    val map = HashMap<RandomListNode?, RandomListNode?>()
    var p = head
    val pointer = RandomListNode(0)
    var copy = pointer
    while (p.next != null) {
        copy.next = RandomListNode(p.label)
        map.put(p, copy.next)
        p = p.next!!
        copy = copy.next!!
    }
    // last node
    copy.next = RandomListNode(p.label)
    map.put(p, copy.next)

    p = head
    copy = pointer
    while (p.next != null) {
        copy.next?.random = map.get(p.random)
        p = p.next!!
        copy = copy.next!!
    }
    copy.next?.random = map.get(p.random)

    return pointer.next!!
}

// Brute force
fun isValidBst(root: TreeNode?): Boolean {
    if (root == null) return true
    return isSubtreeLessThan(root.left, root.item) && isSubtreeGreaterThan(root.right, root.item)
            && isValidBst(root.left) && isValidBst(root.right)
}

fun isSubtreeLessThan(root: TreeNode?, value: Int): Boolean {
    if (root == null) return true
    return root.item < value && isSubtreeLessThan(root.left, root.item) && isSubtreeLessThan(root.right, root.item)
}

fun isSubtreeGreaterThan(root: TreeNode?, value: Int): Boolean {
    if (root == null) return true
    return root.item > value && isSubtreeGreaterThan(root.right, root.item) && isSubtreeGreaterThan(root.right, root.item)
}

class TreeNode(val item: Int, val left: TreeNode? = null, val right: TreeNode? = null) {
    fun itemCheck(): Int {
        var res = item
        if (left != null)
            res += left.itemCheck()
        if (right != null)
            res -= right.itemCheck()
        return res
    }
}

fun main(args: Array<String>) {

    assertTrue(palindromeNumber3(12321))
    assertEquals(listOf(0, 1, 2, 4, 5, 6), mergeTwoSortedList(linkedListOf(0, 2, 4), linkedListOf(1, 5, 6)))
    assertEquals(listOf(1, 1, 5, 4), addListOfNumbers(listOf(1, 5, 6), listOf(9, 9, 8)))
    val l1 = linkedListOf(1, 2, 5)
    val l2 = linkedListOf(2, 3, 4)
    val ls = listOf(l1, l2)
    assertEquals(linkedListOf(1, 2, 2, 3, 4, 5), mergeKSortedLists(ls))

    val r1 = RandomListNode(1)
    val r2 = RandomListNode(2)
    val r3 = RandomListNode(3)
    val r4 = RandomListNode(4)
    r1.next = r2
    r2.next = r3
    r3.next = r4
    r1.random = r3
    r2.random = r1
    r3.random = r4
    r4.random = r2

    var c1 = copyRandomList(r1)

    while (c1.next != null) {
        println(c1)
        c1 = c1.next!!
    }
    println(c1)

    //    assertEquals(2.toLong(), countInversion(listOf(2, 1, 4, 3, 5)))
    //    assertEquals(5.toLong(), countInversion(listOf(1, 20, 6, 4, 5)))
    //    assertEquals(1.toLong(), countInversion(listOf(1, 20, 6)))
    //    assertEquals(15.toLong(), countInversion(listOf(2, 17, 21, 1, 20, 6, 4, 5)))
    //
    //    println("File " + File(".").absoluteFile)
    //
    //    val lines = File("IntegerArray.txt").readLines()
    //    val ints = lines.map { it.toInt() }
    //    println(countInversion(ints))

    assertEquals('a', findSingle01(listOf('c', 'e', 'c', 'a', 'd', 'd', 'e')))
    assertEquals(1, findSingle01(listOf(1)))
    assertEquals("xx", findSingle02(listOf("yy", "zz", "xx", "yy", "zz")))
    assertEquals(1, findSingleNum(listOf(1)))
    assertEquals(1, findSingleNum(listOf(2, 1, 3, 2, 3)))
    assertEquals(1, findSingleNum(listOf(2, 2, 4, 4, 1)))

    for (i in 1..20) {
        println(climbStairs01(i).toString() + ", " + climbStairs02(i))
        assertEquals(climbStairs01(i), climbStairs02(i))
    }

    val minStack: MinStack<Char> = MinStack()
    minStack.push('b')
    minStack.push('c')
    minStack.push('b')
    minStack.push('c')
    minStack.push('a')
    assertEquals('a', minStack.peekMin())
    assertEquals('a', minStack.pop())
    assertEquals('b', minStack.peekMin())
    assertEquals('c', minStack.pop())
    assertEquals('b', minStack.peekMin())
    //    println(plusOne(listOf(1, 2, 9)))
    //    println(plusOne(listOf(1, 9, 9)))
    //    println(plusOne(listOf(9, 9, 9)))

    val v = Validator()
    assertTrue { v.validParentheses("println(climbStairs01(i).toString()  + climbStairs02(i))") }
    assertFalse { v.validParentheses("(println(climbStairs01(i).toString()  + climbStairs02(i))") }
    assertFalse { v.validParentheses("println(climbStairs01(i).toString())  + climbStairs02(i))") }
    assertTrue { v.validParentheses("(println(climbStairs01(i).toString()  + climbStairs02(i)))") }
    assertTrue { v.validParentheses("()") }
    assertTrue { v.validParentheses("(1, 2, 3)") }

//    val map: Map<Char, Char> = hashMapOf(Pair('(', ')'), Pair('{', '}'), Pair('[', ']'))
//    println(map.get('('))
}
// 2407905288