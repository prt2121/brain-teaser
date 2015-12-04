/**
 * Created by pt2121 on 12/4/15.
 */
public class HouseRobber {
  public int rob(int[] nums) {
    int len = nums.length;
    if (len == 0) return 0;
    else if (len == 1) return nums[0];
    else if (len == 2) return Math.max(nums[0], nums[1]);
    else {
      int[] results = new int[len];
      results[0] = nums[0];
      results[1] = Math.max(nums[0], nums[1]);
      for (int i = 2; i < len; i++) {
        results[i] = Math.max(results[i - 1], results[i - 2] + nums[i]);
      }
      return results[len - 1];
    }
  }
}
