import java.util.*;

public class Main {
  static ArrayList<Integer>[] g;
  static boolean[] visited;
  static int[] answer;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    g = new ArrayList[n + 1];
    visited = new boolean[n + 1];
    answer = new int[n + 1];

    for (int i = 0; i <= n; i++) {
      g[i] = new ArrayList();
    }

    for (int i = 0; i < n - 1; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      g[a].add(b);
      g[b].add(a);
    }

    dfs(1);

    for (int i = 2; i <= n; i++) {
      System.out.println(answer[i]);
    }
  }

  static void dfs(int v) {
    visited[v] = true;
    for (int now : g[v]) {
      if (!visited[now]) {
        answer[now] = v;
        dfs(now);
      }
    }
  }
}