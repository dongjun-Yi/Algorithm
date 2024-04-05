import java.util.*;
import java.io.*;

public class Main {
  static ArrayList<Integer>[] list;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    list = new ArrayList[n + 1];
    visited = new boolean[n + 1];

    for (int i = 1; i <= n; i++) {
      list[i] = new ArrayList<Integer>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());

      list[s].add(e);
      list[e].add(s);
    }

    int result = 0;
    for (int i = 1; i <= n; i++) {
      if (!visited[i]) {
        dfs(i);
        result++;
      }
    }
    System.out.println(result);
  }

  public static void dfs(int v) {
    if (visited[v]) // 이미 방문한 노드라면 skip
      return;

    visited[v] = true;

    for (Integer i : list[v]) {
      if (!visited[i]) {
        dfs(i);
      }
    }
  }
}
