import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    long A = Long.parseLong(st.nextToken());
    long B = Long.parseLong(st.nextToken());

    long[] arr = new long[10000001]; // 10^7 까지 구함.

    for (int i = 2; i < arr.length; i++) {
      arr[i] = i;
    }

    for (int i = 2; i <= Math.sqrt(arr.length); i++) {
      if (arr[i] == 0)
        continue;
      for (int j = i + i; j < arr.length; j = j + i) {
        arr[j] = 0;
      }
    }
    int result = 0;

    for (int i = 2; i < 10000001; i++) {
      if (arr[i] != 0) {
        long temp = arr[i];
        while ((double) arr[i] <= (double) B / (double) temp) { // N^k < B => N < B / N ^(k-1)
          if ((double) arr[i] >= (double) A / (double) temp) {
            result++;
          }
          temp = temp * arr[i];
        }
      }
    }

    System.out.println(result);
  }
}