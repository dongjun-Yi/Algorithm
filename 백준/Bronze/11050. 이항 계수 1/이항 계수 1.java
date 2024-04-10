import java.util.*;

public class Main {
  static int[][] d;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();

    d = new int[n + 1][n + 1];

    for (int i = 0; i <= n; i++) {
      d[i][i] = 1;
      d[i][1] = i;
      d[i][0] = 1;
    }

    for (int i = 2; i <= n; i++) {
      for (int j = 1; j < i; j++) {
        d[i][j] = d[i - 1][j] + d[i - 1][j - 1];
      }
    }

    System.out.println(d[n][k]);

  }
}
