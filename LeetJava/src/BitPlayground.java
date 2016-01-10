/**
 * Created by pt2121 on 1/9/16.
 *
 * http://stackoverflow.com/questions/13422259/how-are-integers-internally-represented-at-a-bit-level-in-java
 */
public class BitPlayground {

  /**
   * This method uses XOR and AND bitwise operator to calculate sum of two integer.
   * (Adding two number without using + or plus arithmetic operator.)
   */
  public static int add(int a, int b) {
    if (b == 0) return a;
    int sum = a ^ b; //SUM of two integer is A XOR B
    int carry = (a & b) << 1;  //CARRY of two integer is A AND B
    return add(sum, carry);
  }

  // java int ...Two's Complement
  // A faster way of find the complementary is by fixing the first bit that as value 1 and inverting the remaining bits.
  // This means, the most significant bit (MSB) works as the sign bit.
  // The integer represented by an int is nothing but the weighted sum of the bits
  public static void main(String args[]) {
    int a = 60;	/* 60 = 0011 1100 */
    int b = 13;	/* 13 = 0000 1101 */
    int c;
    int bitmask = 0x000F;
    int val = 0x2222;

    // prints "2"
    c = val & bitmask;
    System.out.println("val & bitmask " + c);

    c = a & b;       /* 12 = 0000 1100 */
    System.out.println("a & b = " + c);

    // inclusive OR operation
    c = a | b;       /* 61 = 0011 1101 */
    System.out.println("a | b = " + c);

    // exclusive OR operation
    c = a ^ b;       /* 49 = 0011 0001 */
    System.out.println("a ^ b = " + c);

    c = ~a;          /*-61 = 1100 0011 */
    System.out.println("~a = " + c);

    c = a << 2;     /* 240 = 1111 0000 */
    System.out.println("a << 2 = " + c);

    c = a >> 2;     /* 215 = 1111 */
    System.out.println("a >> 2  = " + c);

    c = a >>> 2;     /* 215 = 0000 1111 */
    System.out.println("a >>> 2 = " + c);

    int n = 3;
    int m = 4;
    System.out.println("3 ^ 4 " + (n ^ m));
    System.out.println("3 & 4 " + (n & m));
  }
}
