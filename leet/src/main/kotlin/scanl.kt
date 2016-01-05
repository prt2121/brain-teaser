/**
 * Created by pt2121 on 1/4/16.
 */
class scanl {

  fun <B, A> scanl(f: (B, A) -> B, initial: B, ls: List<A>): List<B> {
    return listOf(initial).plus(if (ls.isEmpty()) {
      emptyList()
    } else {
      scanl(f, f(initial, ls.first()), ls.drop(1))
    })
  }

}