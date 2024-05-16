import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] T = new int[n + 1];
    int[] P = new int[n + 1];
    int[] D = new int[n + 2];

    for (int i = 1; i <= n; i++) {
      T[i] = sc.nextInt();
      P[i] = sc.nextInt();
    }

    for (int i = n; i > 0; i--) {
      if (i + T[i] <= n + 1) {
        D[i] = Math.max(D[i + T[i]] + P[i], D[i + 1]);
      } else {
        D[i] = D[i + 1];
      }
    }

    System.out.println(D[1]);
  }
}