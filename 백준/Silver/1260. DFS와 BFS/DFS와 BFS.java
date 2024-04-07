import java.util.*;
import java.io.*;

public class Main {
  static ArrayList<Integer>[] graph;
  static boolean[] visited;

  static StringBuffer sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int start = Integer.parseInt(st.nextToken());

    graph = new ArrayList[n + 1];
    sb = new StringBuffer();

    for (int i = 1; i <= n; i++) {
      graph[i] = new ArrayList<Integer>();
    }

    visited = new boolean[n + 1];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph[a].add(b);
      graph[b].add(a);
    }

    for (int i = 1; i <= n; i++) {
      Collections.sort(graph[i]);
    }

    // dfs 수행.
    sb.append(start + " ");
    dfs(start);
    System.out.println(sb);

    // bfs 수행.
    sb = new StringBuffer();
    visited = new boolean[n + 1];
    sb.append(start + " ");
    bfs(start);

    System.out.println(sb);
  }

  static void bfs(int start) {
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(start);

    visited[start] = true;

    while (!q.isEmpty()) {
      int cur = q.poll();

      for (Integer v : graph[cur]) {
        if (!visited[v]) {
          visited[v] = true;
          q.add(v);
          sb.append(v + " ");
        }
      }
    }
  }

  static void dfs(int v) {
    if (visited[v])
      return;

    visited[v] = true;

    for (Integer cur : graph[v]) {
      if (!visited[cur]) {
        sb.append(cur + " ");
        dfs(cur);
      }
    }

  }
}
