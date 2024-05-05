import java.util.*;
import java.io.*;

public class Main {
  static ArrayList<Integer>[] g;
  static boolean[] visited;
  static int[] group;
  static boolean even;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int v = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      g = new ArrayList[v + 1];
      visited = new boolean[v + 1];
      group = new int[v + 1];
      even = true;

      for (int j = 0; j <= v; j++) {
        g[j] = new ArrayList();
      }

      for (int j = 0; j < e; j++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        g[a].add(b);
        g[b].add(a);
      }

      for (int j = 1; j <= v; j++) {
        if (even == false) {
          break;
        }
        dfs(j);
      }
      if (even == false)
        System.out.println("NO");
      else
        System.out.println("YES");
    }
  }

  static void dfs(int v) {
    visited[v] = true;

    for (int cur : g[v]) {
      if (!visited[cur]) {
        group[cur] = (group[v] + 1) % 2;
        dfs(cur);
      } else if (group[cur] == group[v])
        even = false;
    }
  }
}