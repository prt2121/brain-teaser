/**
 * Created by pt2121 on 11/22/15.
 */
public class NumArray01 {
  private int[] nums = null;
  private int[][] cache = null;

  public NumArray01(int[] nums) {
    this.nums = nums;
    int length = nums.length;
    cache = new int[length][length];
    for (int i = 0; i < nums.length; i++) {
      cache[i][i] = nums[i];
    }
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        cache[i][j] = cache[i][j - 1] + nums[j];
      }
    }
  }

  public int sumRange(int i, int j) {
    return cache[i][j];
  }

}