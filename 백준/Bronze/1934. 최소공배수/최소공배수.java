import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    for (int i = 0; i < t; i++) {
      int A = sc.nextInt();
      int B = sc.nextInt();

      System.out.println(lcm(A, B));
    }
  }

  static int lcm(int a, int b) {
    return (a * b) / gcd(a, b);
  }

  static int gcd(int a, int b) {
    if (b == 0)
      return a;
    return gcd(b, a % b);
  }
}