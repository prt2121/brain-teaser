import kotlin.test.assertEquals
import org.junit.Test as test

class reverseWordsTest {
  @test fun reverseWords1Test() {
    assertEquals("sihT si ti", reverseWords1("This is it"))
  }

  @test fun reverseWords2Test1() {
    assertEquals("sihT si ti", reverseWords2("This is it"))
  }

  @test fun reverseWords2Test2() {
    assertEquals("sihT si ti lol", reverseWords2("This is it lol"))
  }
}