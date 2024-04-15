import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    long[] count = new long[m];
    long[] sum = new long[n];
    long[] a = new long[n];
    long result = 0;

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    sum[0] = a[0];
    for (int i = 1; i < n; i++) {
      sum[i] = sum[i - 1] + a[i];
    }

    for (int i = 0; i < n; i++) {
      int remain = (int) (sum[i] % m);
      if (remain == 0)
        result++;
      count[remain]++;
    }

    for (int i = 0; i < m; i++) {
      if (count[i] > 1)
        result += (count[i] * (count[i] - 1)) / 2;
    }

    System.out.println(result);
  }
}