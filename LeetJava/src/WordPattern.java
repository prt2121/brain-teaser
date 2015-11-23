import java.util.HashMap;
import java.util.Map;

/**
 * Created by pt2121 on 11/23/15.
 */
public class WordPattern {

  public boolean wordPattern(String pattern, String str) {
    int len = pattern.length();
    Map<Character, String> map = new HashMap<>(len);
    String[] strings = str.split("\\s");
    if (strings.length != len)
      return false;
    for (int i = 0; i < len; i++) {
      char key = pattern.charAt(i);
      if (!map.containsKey(key)) {
        if (map.containsValue(strings[i]))
          return false;
        map.put(key, strings[i]);
      } else {
        String val = map.get(key);
        if (!val.equals(strings[i]))
          return false;
      }
    }
    return true;
  }
}
