/**
 * Created by pt2121 on 10/20/15.
 */
fun maxSubArray(a: IntArray): Int {
    var maxEndHere = a[0]
    var maxSoFar = a[0]
    a.forEach {
        x ->
        maxEndHere = Math.max(maxEndHere + x, x)
        maxSoFar = Math.max(maxEndHere, maxSoFar)
    }
    return maxSoFar
}