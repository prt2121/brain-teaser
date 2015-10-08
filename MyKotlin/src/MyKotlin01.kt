import java.util.*
import kotlin.test.assertEquals
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


fun main(args: Array<String>) {
    //    println("Hello, Kotlin!")
    //    println(plusOne(listOf(1, 2, 9)))
    //    println(plusOne(listOf(1, 9, 9)))
    //    println(plusOne(listOf(9, 9, 9)))
    assertTrue(palindromeNumber3(12321))
    assertEquals(mergeTwoSortedList(linkedListOf(0, 2, 4), linkedListOf(1, 5, 6)), listOf(0, 1, 2, 4, 5, 6))
    assertEquals(addListOfNumbers(listOf(1, 5, 6), listOf(9, 9, 8)), listOf(1, 1, 5, 4))
}