import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by pt2121 on 11/20/15.
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubList {

  public static <T> int lengthOfLongestSubList(List<T> list) {
    Set<T> set = new HashSet<>();
    int longestLen = 0;
    int len = 0;
    int i = 0;
    int size = list.size();
    while (i < size) {
      int j = i;
      while (j < size) {
        T element = list.get(j);
        if (set.contains(element)) {
          set.clear();
          len = 0;
        } else {
          set.add(element);
          len++;
          if (len > longestLen) {
            longestLen = len;
          }
        }
        j++;
      }
      i++;
    }
    return longestLen;
  }

  public static void main(String[] args) {
    List<Character> chars = "abcabcbbadbc".chars().mapToObj(e -> (char) e).collect(Collectors.toList());
    System.out.println(LongestSubList.lengthOfLongestSubList(chars));
  }
}
