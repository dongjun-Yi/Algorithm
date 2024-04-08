import java.util.*;
import java.io.*;

public class Main {
  static ArrayList<Integer>[] g;
  static boolean[] visited;
  static int[] distance;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int start = Integer.parseInt(st.nextToken());

    g = new ArrayList[n + 1];
    visited = new boolean[n + 1];
    distance = new int[n + 1];

    for (int i = 1; i < n + 1; i++) {
      distance[i] = Integer.MAX_VALUE;
    }

    for (int i = 1; i < n + 1; i++) {
      g[i] = new ArrayList();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      g[a].add(b);
    }

    bfs(start);

    boolean flag = false;
    for (int i = 1; i < n + 1; i++) {
      if (distance[i] == k) {
        System.out.println(i);
        flag = true;
      }
    }
    if (flag == false)
      System.out.println(-1);
  }

  static void bfs(int v) {
    Queue<Integer> q = new LinkedList();
    q.add(v);
    visited[v] = true;
    distance[v] = 0;

    while (!q.isEmpty()) {
      int cur = q.poll();

      for (int i : g[cur]) {
        if ((!visited[i]) && (distance[i] == Integer.MAX_VALUE)) {
          distance[i] = distance[cur] + 1;
          visited[i] = true;
          q.add(i);
        }
      }
    }
  }
}
