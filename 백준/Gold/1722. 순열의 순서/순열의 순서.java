import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] number = new int[n + 1];
    boolean[] visited = new boolean[n + 1];
    long[] F = new long[21];
    F[0] = 1;
    for (int i = 1; i <= 20; i++) {
      F[i] = i * F[i - 1];
    }

    int p = sc.nextInt();

    if (p == 1) { // 소문제 1
      long k = sc.nextLong();
      for (int i = 0; i < n; i++) {
        int cnt = 1;
        for (int j = 1; j <= n; j++) {
          if (visited[j])
            continue;
          if (k <= cnt * F[n - i - 1]) {
            k -= (cnt - 1) * F[n - i - 1];
            number[i] = j;
            visited[j] = true;
            break;
          }
          cnt++;
        }
      }
      for (int i = 0; i < n; i++) {
        System.out.print(number[i] + " ");
      }
    }
    if (p == 2) {
      long k = 1;
      for (int i = 0; i < n; i++) {
        number[i] = sc.nextInt();
        int cnt = 0;

        for (int j = 1; j < number[i]; j++) {
          if (visited[j] == false)
            cnt++;
        }
        k += cnt * F[n - i - 1];
        visited[number[i]] = true;
      }
      System.out.println(k);
    }
  }
}