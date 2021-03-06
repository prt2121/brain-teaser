import java.util.Arrays;

/**
 * Created by pt2121 on 10/5/15.
 */
public class Leet01 {

    // String to Integer (atoi)
    public static int atoi(String str) throws Exception {
        System.out.println(Integer.MAX_VALUE);
        final int CEILING = Integer.MAX_VALUE / 10;

        int length = str.length();
        int i = 0;
        while (i < length && Character.isWhitespace(str.charAt(i))) {
            i++;
        }
        int sign = 1;
        if (i < length) {
            if (str.charAt(i) == '+') {
                i++;
            } else if (str.charAt(i) == '-') {
                i++;
                sign = -1;
            }
        } else {
            throw new Exception("Empty string");
        }

        int mul = 10;
        int value = 0;
        while (i < length) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                value = value * mul + Character.getNumericValue(c);
                if (i + 1 < length
                        && Character.isDigit(str.charAt(i + 1))) {
                    int next = Character.getNumericValue(str.charAt(i + 1));
                    if (next >= 8 && value >= CEILING) {
                        throw new Exception("Overflow!");
                    }
                }
            } else {
                throw new Exception("The String is invalid!");
            }
            i++;
        }
        return sign * value;
    }

    // Longest Substring Without Repeating Characters
    public static int lengthOfLongestSubstring(String str) {
        int length = str.length();
        String longest = "";
        int i = 0;
        while (i < length) {
            int j = 0;
            String current = "";
            while (j < length) {
                char c = str.charAt(j);
                boolean exist = isExist(current, c);
                if (exist) {
                    if (current.length() > longest.length()) {
                        longest = current;
                    }
                    i++;
                    break;
                } else {
                    current += c;
                    j++;
                }
            }
        }
        System.out.println(longest);
        return longest.length();
    }

    private static boolean isExist(String current, char c) {
        boolean exist = false;
        for (int j = 0; j < current.length(); j++) {
            char x = current.charAt(j);
            if (x == c) {
                exist = true;
            }
        }
        return exist;
    }

    public static int lengthOfLongestSubstring2(String s) {
        boolean[] exist = new boolean[256];
        int i = 0, maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            while (exist[s.charAt(j)]) {
                exist[s.charAt(i)] = false;
                i++;
            }
            exist[s.charAt(j)] = true;
            maxLen = Math.max(j - i + 1, maxLen);
        }
        return maxLen;
    }

    public static int lengthOfLongestSubstring3(String s) {
        int[] charMap = new int[256];
        Arrays.fill(charMap, -1);
        int i = 0, maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            if (charMap[s.charAt(j)] >= i) {
                i = charMap[s.charAt(j)] + 1;
            }
            charMap[s.charAt(j)] = j;
            maxLen = Math.max(j - i + 1, maxLen);
        }
        return maxLen;
    }

    public static String longestPalindrome(String s) {
        int begin = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddPosLen = longestPalindromeAtPosition(s, i, i);
            int evenPosLen = longestPalindromeAtPosition(s, i, i + 1);
            int max = Math.max(oddPosLen, evenPosLen);
            if (max > end - begin) {
                begin = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }
        return s.substring(begin, end + 1);
    }

    private static int longestPalindromeAtPosition(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public static boolean isOneEditDistance(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int lenDiff = Math.abs(sLen - tLen);
        if (lenDiff > 1) return false;
        if (sLen > tLen) return isOneEditDistance(t, s);
        int i = 0;
        while (i < sLen && s.charAt(i) == t.charAt(i)) {
            i++;
        }
        if (i == sLen && lenDiff == 1) return true;
        if (i == sLen) return false;
        // insert case
        if (lenDiff == 1) {
            while (i < sLen && s.charAt(i) == t.charAt(i + 1)) {
                i++;
            }
            return i == sLen;
        }
        // modify case
        i++;
        while (i < sLen && s.charAt(i) == t.charAt(i)) {
            i++;
        }
        return i == sLen;
    }

    public static void main(String[] args) {
//        try {
//            System.out.println(atoi("2147483648"));
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
        int l = lengthOfLongestSubstring3("abcdcedf");
        System.out.println(l);

        String p = longestPalindrome("987xjhihjx123xabcbay");
        System.out.println(p);

        System.out.println(isOneEditDistance("abc", "abcd"));
        System.out.println(isOneEditDistance("abc", "abc"));
        System.out.println(isOneEditDistance("abc", "ab"));
        System.out.println(isOneEditDistance("abc", "axbc"));
        System.out.println(isOneEditDistance("abc", "xbc"));
        System.out.println(isOneEditDistance("abc", "abx"));
        System.out.println(isOneEditDistance("a", "axx"));
        System.out.println(isOneEditDistance("xaby", "ab"));
    }
}
