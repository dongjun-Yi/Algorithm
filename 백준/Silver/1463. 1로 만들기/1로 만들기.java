import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] D = new int[1000001];
    D[2] = 1;
    D[3] = 1;

    for (int i = 4; i <= n; i++) {
      D[i] = D[i - 1] + 1;
      if (i % 2 == 0) {
        D[i] = Math.min(D[i], D[i / 2] + 1);
      }
      if (i % 3 == 0) {
        D[i] = Math.min(D[i], D[i / 3] + 1);
      }
    }

    System.out.println(D[n]);
  }
}