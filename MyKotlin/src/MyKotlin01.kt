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

fun main(args: Array<String>) {
    println("Hello, Kotlin!")
    println(plusOne(listOf(1, 2, 9)))
    println(plusOne(listOf(1, 9, 9)))
    println(plusOne(listOf(9, 9, 9)))
    println(palindromeNumber3(12321))
}