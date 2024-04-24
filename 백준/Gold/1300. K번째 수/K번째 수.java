import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();

    long lt = 1;
    long rt = k;
    long result = 0;

    while (lt <= rt) {
      long mid = (lt + rt) / 2;
      long count = getCount(n, mid);

      if (count >= k) {
        result = mid;
        rt = mid - 1;
      } else {
        lt = mid + 1;
      }
    }

    System.out.println(result);
  }

  static long getCount(long n, long mid) {
    int count = 0;
    for (int i = 1; i <= n; i++) {
      count += Math.min(mid / i, n);
    }
    return count;
  }
}