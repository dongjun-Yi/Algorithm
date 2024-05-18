import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    int[][] D = new int[n][m];
    int result = 0;

    for (int i = 0; i < n; i++) {
      String input = sc.next();
      for (int j = 0; j < m; j++) {
        D[i][j] = Integer.parseInt(String.valueOf((input.charAt(j))));

        if(D[i][j] == 1 && i >0 && j > 0)
          D[i][j] = Math.min(D[i-1][j], Math.min(D[i][j-1], D[i-1][j-1])) + 1;

        if(result < D[i][j])
          result = D[i][j];
      }
    }

    System.out.println(result * result);
  }
}