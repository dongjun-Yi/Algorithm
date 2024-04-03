import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    sc.close();
    
    int[] arr = new int[n + 1];

    for (int i = 0; i <= n; i++) {
      arr[i] = i;
    }

    int lt = 1;
    int rt = 1;
    int sum_value = 1;
    int cnt = 0;

    while (rt < n) {
      if (sum_value < n) {
        rt++;
        sum_value += arr[rt];
      } else if (sum_value > n) {
        sum_value -= arr[lt];
        lt++;
      } else {
        cnt++;
        rt++;
        sum_value += arr[rt];
      }
    }

    System.out.println(cnt + 1);

  }
}
