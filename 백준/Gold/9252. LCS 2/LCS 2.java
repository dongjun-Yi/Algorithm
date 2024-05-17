import java.util.*;

public class Main {
  static char[] A;
  static char[] B;
  static long[][] D;
  static ArrayList<Character> answer = new ArrayList();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    A = sc.next().toCharArray();
    B = sc.next().toCharArray();

    D = new long[A.length + 1][B.length + 1];

    for (int i = 1; i <= A.length; i++) {
      for (int j = 1; j <= B.length; j++) {
        if (A[i - 1] == B[j - 1]) {
          D[i][j] = D[i - 1][j - 1] + 1;
        } else {
          D[i][j] = Math.max(D[i - 1][j], D[i][j - 1]);
        }
      }
    }

    getText(A.length, B.length);

    System.out.println(D[A.length][B.length]);

    for (int i = answer.size() - 1; i >= 0; i--) {
      System.out.print(answer.get(i));
    }
  }

  static void getText(int r, int c) {
    if (r == 0 || c == 0)
      return;

    if (A[r - 1] == B[c - 1]) {
      answer.add(A[r - 1]);
      getText(r - 1, c - 1);
    } else {
      if (D[r - 1][c] > D[r][c - 1])
        getText(r - 1, c);
      else
        getText(r, c - 1);
    }
  }
}