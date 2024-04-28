import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    long[] A = new long[n];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      A[i] = Long.parseLong(st.nextToken());
    }

    Arrays.sort(A);
    int result = 0;

    for (int i = 0; i < n; i++) {
      long target = A[i];

      int lt = 0;
      int rt = n - 1;

      while (lt < rt) {
        if ((A[lt] + A[rt]) == target) {
          if (lt != i && rt != i) {
            result++;
            break;
          }

          if (lt == i) {
            lt++;
          } else {
            rt--;
          }
        } else if ((A[lt] + A[rt]) > target) {
          rt--;
        } else {
          lt++;
        }
      }
    }

    System.out.println(result);
  }
}