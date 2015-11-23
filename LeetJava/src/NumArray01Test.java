import static org.junit.Assert.assertEquals;

/**
 * Created by pt2121 on 11/22/15.
 */
public class NumArray01Test {

  private int[] nums = {-8, 2, 7, -9, 2, 9, -8, -3, 4, -4, -6, -6, -3, 3, 2, 0, -7, 8, -5, 1, 4, 8, -5, 3, 8, 2, 8, 7, -1, 6, 7, 0, -7, 7, -5, -7, 2, 7};

  @org.junit.Test
  public void testSumRange() throws Exception {
    NumArray numArray = new NumArray(nums);
    assertEquals(-8, numArray.sumRange(5, 10));
  }

  @org.junit.Test
  public void testSumRange01() throws Exception {
    NumArray01 numArray = new NumArray01(nums);
    assertEquals(-8, numArray.sumRange(5, 10));
  }
}