/**
 * Created by pt2121 on 12/28/15.
 */
public class UglyNumber {
  // Ugly numbers are positive numbers whose prime factors can only include 2, 3, 5.
  // prime is not ugly
  public boolean isUgly(int num) {
    if (num <= 0) return false;
    if (num <= 6) return true;
    while (num % 2 == 0) num = num / 2;
    while (num % 3 == 0) num = num / 3;
    while (num % 5 == 0) num = num / 5;
    if (num <= 6) return true;
    int max = (num > 1000) ? (int) Math.ceil(Math.sqrt(num)) : (int) Math.ceil(num / 2);
    for (int i = 3; i <= max; i += 2) {
      if (num % i == 0) {
        return false;
      }
    }
    return num % 2 == 0 || num % 3 == 0 || num % 5 == 0;
  }
}
