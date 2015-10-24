import java.io.File

/**
 * Created by pt2121 on 10/24/15.
 */
object QuickSort {

    fun sort<T : Comparable<T>>(a: Array<T>): Array<T> {
        val n = a.size()
        if (n <= 1) return a
        val pair = partition(a)
        val pivot = pair.second
        val x = pair.first
        return sort(x.copyOfRange(0, pivot))
                .plus(x[pivot])
                .plus(sort(x.copyOfRange(pivot + 1, n)))
    }

    fun partition<T : Comparable<T>>(a: Array<T>): Pair<Array<T>, Int> {
        val p = a[0]
        var i = 1
        for (j in 1..a.lastIndex) {
            if (a[j] < p) {
                swap(a, j, i)
                i += 1
            }
        }
        return Pair(swap(a, 0, i - 1), i - 1)
    }

    // swap
    fun swap<T>(a: Array<T>, i: Int, j: Int): Array<T> {
        val tmp = a[j]
        a[j] = a[i]
        a[i] = tmp
        return a
    }
}

fun main(args: Array<String>) {

    val lines = File("QuickSort.txt").readLines().map { it.toInt() }
    QuickSort.sort(lines.toTypedArray()).forEach { println(it) }

}