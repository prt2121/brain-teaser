/**
 * Created by pt2121 on 10/10/15.
 */

fun countInversion(ls: List<Int>): Long {
    return count(ls).first
}

fun count(ls: List<Int>): Pair<Long, List<Int>> {
    val size = ls.size()
    if (size == 1) return Pair(0, ls)
    if (size == 2) {
        return if (ls.get(0) > ls.get(1))
            Pair<Long, List<Int>>(1, listOf(ls.get(1), ls.get(0))) else
            Pair<Long, List<Int>>(0, ls)
    }
    val lSize = size div 2
    val a1 = ls.slice(0..lSize)
    val a2 = ls.slice((lSize + 1)..(size - 1))
    val p1 = count(a1)
    val p2 = count(a2)
    val p3 = merge(p1.second, p2.second)
    return Pair((p1.first + p2.first + p3.first), p3.second)
}

fun merge(ls1: List<Int>, ls2: List<Int>): Pair<Long, List<Int>> {
    val ls2First = ls2.first()
    var r = ls1.takeWhile {
        e ->
        e < ls2First
    }
    var y = ls1.subtract(r).toList()
    var z = ls2
    var count = 0.toLong()
    while (y.size() > 0 && z.size() > 0) {
        if (y.first() > z.first()) {
            count += y.size()
            r = r.plus(z.first())
            z = z.drop(1)
        } else {
            r = r.plus(y.first())
            y = y.drop(1)
        }
    }
    if (y.size() > 0) {
        r = r.plus(y)
    }
    if (z.size() > 0) r = r.plus(z)
    return Pair<Long, List<Int>>(count, r)
}