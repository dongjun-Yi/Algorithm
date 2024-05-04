import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    long A = sc.nextLong();
    long B = sc.nextLong();
    long count = gcd(A, B);

    while (count > 0) {
      bw.write("1");
      count--;
    }
    bw.flush();
    bw.close();
  }

  static long gcd(long a, long b) {
    if (b == 0)
      return a;
    return gcd(b, a % b);
  }
}