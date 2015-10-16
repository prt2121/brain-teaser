import java.util.*

/**
 * Created by pt2121 on 10/11/15.
 */

fun climbStairs01(n: Int): Int {
    if (n <= 2) return n
    return climbStairs01(n - 1) + climbStairs01(n - 2)
}

fun climbStairs02(n: Int): Int {
    if (n <= 2) return n
    var ls = IntArray(n + 1)
    ls[1] = 1
    ls[2] = 2
    for (i in 3..n) {
        ls[i] = ls[i - 1] + ls[i - 2]
    }
    return ls[n]
}

fun findSingle01<T>(ls: List<T>): T {
    val map = HashMap<T, Int>()
    ls.forEach { it ->
        if (map.containsKey(it)) {
            map.remove(it)
        } else {
            map.put(it, 1)
        }
    }
    return map.toList().get(0).first
}

fun findSingle02<T>(ls: List<T>): T {
    val set = HashSet<T>()
    ls.forEach { it ->
        if (set.contains(it)) {
            set.remove(it)
        } else {
            set.add(it)
        }
    }
    return set.first()
}

fun findSingleNum(ls: List<Int>): Int {
    var ret = 0
    ls.forEach { it ->
        ret = ret.xor(it)
    }
    return ret
}
