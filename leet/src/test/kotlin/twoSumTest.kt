import kotlin.test.assertEquals
import org.junit.Test as test

class twoSumTest {

    inline fun testUnsorted(f: (Array<Int>, Int) -> Pair<Int, Int>?) {
        val a1 = intArrayOf(9, 1, 5, 3, 2, 7).toTypedArray()
        assertEquals(f(a1, 7), Pair(3, 5))
        val a2 = intArrayOf(1, 3, 2, 7).toTypedArray()
        assertEquals(f(a2, 7), null)
    }

    @test fun testTwoSumBruteForce() {
        testUnsorted(::twoSumBruteForce)
    }

    @test fun testTwoSumHashMap() {
        testUnsorted(::twoSumHashMap)
    }
}