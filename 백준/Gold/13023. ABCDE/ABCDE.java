import java.util.*;
import java.io.*;

public class Main {
  static ArrayList<Integer>[] g;
  static boolean[] visited;
  static boolean friend;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    g = new ArrayList[n];

    for (int i = 0; i < n; i++) {
      g[i] = new ArrayList();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      g[a].add(b);
      g[b].add(a);
    }

    for (int i = 0; i < n; i++) {
      visited = new boolean[n];
      dfs(1, i);
      if (friend) {
        System.out.println(1);
        System.exit(0);
      }
    }
    System.out.println(0);
  }

  static void dfs(int level, int v) {
    if (level == 5 || friend) {
      friend = true;
      return;
    }
    visited[v] = true;

    for (int cur : g[v]) {
      if (!visited[cur])
        dfs(level + 1, cur);
    }

    visited[v] = false;
  }
}