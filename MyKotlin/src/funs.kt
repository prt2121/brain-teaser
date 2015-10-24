/**
 * Created by pt2121 on 10/20/15.
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

fun searchInsertPosition<T : Comparable<T>>(a: Array<T>, target: T): Int {
    var l = 0
    var r = a.size() - 1
    while (l < r) {
        val m = (l + r) / 2
        if (a[m] < target) {
            l = m + 1
        } else {
            r = m
        }
    }
    return if (a[l] < target) l + 1 else l
}

fun maxSubArray(a: IntArray): Int {
    var maxEndHere = a[0]
    var maxSoFar = a[0]
    a forEach {
        x ->
        maxEndHere = Math.max(maxEndHere + x, x)
        maxSoFar = Math.max(maxEndHere, maxSoFar)
    }
    return maxSoFar
}

fun maxProductSubArray(a: IntArray): Int {
    var maxEndHere = 1
    var maxSoFar = 1
    var minEndHere = 1
    a forEach {
        x ->
        if (x > 0) {
            maxEndHere *= x
            minEndHere = Math.min(minEndHere * x, 1)
        } else if (x == 0) {
            maxEndHere = 1
            minEndHere = 1
        } else {
            val tmp = maxEndHere
            maxEndHere = Math.max(minEndHere * x, 1)
            minEndHere = tmp * x
        }

        if (maxSoFar < maxEndHere)
            maxSoFar = maxEndHere
    }
    return maxSoFar
}