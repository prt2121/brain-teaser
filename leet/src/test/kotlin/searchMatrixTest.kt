/**
 * Created by pt2121 on 10/25/15.
 */
import kotlin.test.assertFalse
import kotlin.test.assertTrue

import org.junit.Test as test

class searchMatrixTest {

  private val matrix: Array<Array<Int>>
    get() {
      val m1 = arrayOf(arrayOf(1, 3, 5, 7),
          arrayOf(10, 11, 16, 20),
          arrayOf(23, 30, 34, 50))
      return m1
    }

  @test fun testSearchMatrixRec1() {
    assertTrue(searchMatrixRec(matrix, 3))
  }

  @test fun testSearchMatrixRec2() {
    assertTrue(searchMatrixRec(matrix, 10))
  }

  @test fun testSearchMatrixRec3() {
    assertFalse(searchMatrixRec(matrix, 12))
  }

  @test fun testSearchMatrixRec4() {
    assertFalse(searchMatrixRec(matrix, 70))
  }

  @test fun testSearchMatrix1() {
    assertTrue(searchMatrix(matrix, 3))
  }

  @test fun testSearchMatrix2() {
    assertTrue(searchMatrix(matrix, 10))
  }

  @test fun testSearchMatrix3() {
    assertFalse(searchMatrix(matrix, 12))
  }

  @test fun testSearchMatrix4() {
    assertFalse(searchMatrix(matrix, 70))
  }
}