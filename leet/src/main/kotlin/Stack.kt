/**
 * Modified from zach-klippenstein/FunctionalStack.kt
 */
import java.util.*

public interface Stack<out T> {
  public val size: Int
  public fun pop(): Pair<T, Stack<T>>
}

/**
 * This has to be an extension method so we can specify the lower bound of the stack's type parameter.
 * Kotlin's type inference will correctly bind E to the most-specific-common-superclass of
 * <code>T</code> and whatever is being passed in.
 *
 * Kotlin does not (as of M10) support using out-types as lower bounds for method type parameters.
 * Ideally, we could define something like this on FunctionalStack:
 * <code>
 *     public fun &lt;E :&gt; T&gt; push(obj: E): FunctionalStack&lt;E&gt;
 * </code>
 */
public fun <E, T : E> Stack<T>.push(obj: E): Stack<E> {
  return N(size + 1, obj, this)
}

public object Empty : Stack<Nothing> {
  override val size = 0

  override fun pop(): Pair<Nothing, Stack<Nothing>> {
    throw NoSuchElementException()
  }
}

private class N<T>(
    override val size: Int,
    val head: T,
    val tail: Stack<T>
) : Stack<T> {
  override fun pop(): Pair<T, Stack<T>> {
    return Pair(head, tail)
  }
}