import static org.junit.Assert.assertEquals;

/**
 * Created by pt2121 on 12/4/15.
 */
public class HouseRobberTest {

  @org.junit.Test
  public void testHouseRobber() throws Exception {
    int[] nums = {1, 1, 1};
    assertEquals(2, new HouseRobber().rob(nums));
  }

  @org.junit.Test
  public void testHouseRobber2() throws Exception {
    int[] nums = {2, 1, 1, 1, 3, 3, 8, 2, 8, 7};
    assertEquals(22, new HouseRobber().rob(nums));
  }
}
