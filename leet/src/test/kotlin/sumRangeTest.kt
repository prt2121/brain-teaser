import com.google.common.truth.Truth.assertThat
import org.junit.Test as test

/**
 * Created by pt2121 on 11/22/15.
 */
class sumRangeTest {
  val arr = intArrayOf(-8, 2, 7, -9, 2, 9, -8, -3, 4, -4, -6, -6, -3, 3, 2, 0, -7, 8, -5, 1, 4, 8, -5, 3, 8, 2, 8, 7, -1, 6, 7, 0, -7, 7, -5, -7, 2, 7)
  val nums = NumArray(arr.toTypedArray())
  val nums2 = NumArray2(arr.toTypedArray())

  @test fun test01() {
    assertThat(nums.sumRange(5, 10)).isEqualTo(-8)
  }

  @test fun test02() {
    assertThat(nums2.sumRange(5, 10)).isEqualTo(-8)
  }
}