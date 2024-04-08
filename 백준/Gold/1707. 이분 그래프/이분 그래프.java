import java.util.*;
import java.io.*;

public class Main {
  static ArrayList<Integer>[] g;
  static boolean[] visited;
  static boolean[] check;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());
    StringTokenizer st;

    for (int i = 0; i < t; i++) {
      st = new StringTokenizer(br.readLine());

      int v = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());

      g = new ArrayList[v + 1];
      check = new boolean[v + 1];

      for (int j = 1; j < v + 1; j++) {
        g[j] = new ArrayList<Integer>();
      }
      visited = new boolean[v + 1];

      for (int k = 0; k < e; k++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        g[a].add(b);
        g[b].add(a);
      }

      boolean even = true;

      for (int j = 1; j < v + 1; j++) {
        if (!dfs(j)) {
          even = false;
          break;
        }
      }

      if (even == false) {
        System.out.println("NO");
      } else {
        System.out.println("YES");
      }
    }
  }

  public static boolean dfs(int v) {
    visited[v] = true;
    for (int cur : g[v]) {
      if (!visited[cur]) {
        check[cur] = !check[v];
        dfs(cur);
      } else {
        if (check[cur] == check[v])
          return false;
      }
    }
    return true;
  }
}
