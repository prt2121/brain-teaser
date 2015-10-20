/**
 * Created by pt2121 on 10/20/15.
 */
fun countPaths(m: Int, n: Int): Int {
    if (m == 1 || n == 1) {
        return 1
    }
    return countPaths(m - 1, n) + countPaths(m, n - 1)
}

fun countPaths2(m: Int, n: Int): Int {
    var c = Array(m, {
        i ->
        if (i == 0) Array(n, { i -> 1 })
        else Array(n, { i -> if (i == 0) 1 else 0 })
    })

    for (i in 1..(m - 1)) {
        for (j in 1..(n - 1)) {
            c[i][j] = c[i - 1][j] + c[i][j - 1];
        }
    }
    return c[m - 1][n - 1]
}