import java.util.*;

public class Main {
  static ArrayList<ArrayList<Integer>> g;
  static boolean[] visited;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    g = new ArrayList();

    for (int i = 0; i < n; i++) {
      g.add(new ArrayList());
    }

    for (int i = 0; i < m; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();

      g.get(a).add(b);
      g.get(b).add(a);
    }

    for (int i = 0; i < n; i++) {
      visited = new boolean[n];
      dfs(0, i);
    }
    System.out.println(0);
  }

  static void dfs(int level, int v) {
    if (level == 4) {
      System.out.println(1);
      System.exit(0);
    }

    if (visited[v])
      return;

    visited[v] = true;

    for (int cur : g.get(v)) {
      if (!visited[cur]) {
        dfs(level + 1, cur);
      }
    }
    visited[v] = false;
  }
}