import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();

    int[] D = new int[51];

    double[] posiblity = new double[51];
    int n = 0;

    for (int i = 0; i < m; i++) {
      D[i] = sc.nextInt();
      n += D[i];
    }

    int k = sc.nextInt();
    double answer = 0.0;

    for (int i = 0; i < m; i++) {
      if (D[i] >= k) {
        posiblity[i] = 1.0;
        for (int j = 0; j < k; j++) {
          posiblity[i] *= (double) (D[i] - j) / (n - j);
        }
      }
      answer += posiblity[i];
    }
    System.out.println(answer);
  }
}