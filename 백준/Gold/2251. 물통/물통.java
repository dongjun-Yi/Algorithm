import java.util.*;

public class Main {
  static int[] S = { 0, 0, 1, 1, 2, 2 };
  static int[] R = { 1, 2, 0, 2, 0, 1 };
  static boolean[][] visited = new boolean[201][201];
  static int[] capacity = new int[3];
  static boolean[] answer = new boolean[201];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    capacity[0] = sc.nextInt();
    capacity[1] = sc.nextInt();
    capacity[2] = sc.nextInt();

    answer[capacity[2]] = true;

    dfs(0, 0, capacity[2]);

    for (int i = 0; i < answer.length; i++) {
      if (answer[i])
        System.out.print(i + " ");
    }
  }

  static void dfs(int A, int B, int C) {

    if (visited[A][B])
      return;

    visited[A][B] = true;

    for (int i = 0; i < 6; i++) {
      int[] next = { A, B, C };

      next[R[i]] += next[S[i]];
      next[S[i]] = 0;

      if (next[R[i]] > capacity[R[i]]) {
        next[S[i]] = next[R[i]] - capacity[R[i]];
        next[R[i]] = capacity[R[i]];
      }

      if (!visited[next[0]][next[1]]) {
        if (next[0] == 0) {
          answer[next[2]] = true;
        }
        dfs(next[0], next[1], next[2]);
      }
    }

  }
}