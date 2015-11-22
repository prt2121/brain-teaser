import com.google.common.truth.Truth
import org.junit.Test as test

class climbingStairsTest {

  @test fun testClimbingStairs01() {
    Truth.assertThat(climb.climbingStairs001(4)).isEqualTo(5)
  }

  @test fun testClimbingStairs02() {
    Truth.assertThat(climb.climbingStairs002(4)).isEqualTo(5)
  }

  @test fun testClimbingStairs03() {
    Truth.assertThat(climb.climbingStairs001(5)).isEqualTo(8)
  }

  @test fun testClimbingStairs04() {
    Truth.assertThat(climb.climbingStairs002(5)).isEqualTo(8)
  }

  @test fun testClimbingStairs05() {
    Truth.assertThat(climb.climbingStairs001(6)).isEqualTo(13)
  }

  @test fun testClimbingStairs06() {
    Truth.assertThat(climb.climbingStairs002(6)).isEqualTo(13)
  }

  @test fun testClimbingStairs07() {
    (0..40).forEach {
      Truth.assertThat(climb.climbingStairs002(it))
          .isEqualTo(climb.climbingStairs001(it))
    }
  }

}