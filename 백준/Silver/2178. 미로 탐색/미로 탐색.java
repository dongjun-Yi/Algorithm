import java.util.*;
import java.io.*;

public class Main {
  static int[][] graph;
  static boolean[][] visited;

  static int n;
  static int m;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    graph = new int[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      String tmp = br.readLine();

      for (int j = 0; j < m; j++) {
        graph[i][j] = tmp.charAt(j) - '0';
      }
    }

    bfs(0, 0);
    System.out.println(graph[n - 1][m - 1]);
  }

  static void bfs(int x, int y) {

    // 상하좌우
    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };

    Queue<int[]> q = new LinkedList();
    q.add(new int[] { x, y });
    visited[x][y] = true;

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int cx = cur[0];
      int cy = cur[1];

      for (int i = 0; i < 4; i++) {
        int nx = cx + dx[i];
        int ny = cy + dy[i];

        if (nx < 0 || nx >= n || ny < 0 || ny >= m)
          continue;

        if (graph[nx][ny] != 0 && (!visited[nx][ny])) {
          visited[nx][ny] = true;
          graph[nx][ny] = graph[cx][cy] + 1;
          q.add(new int[] { nx, ny });
        }
      }
    }

  }

  static void printArray() {
    for (int i = 0; i < n; i++) {
      for (int v : graph[i]) {
        System.out.print(v);
      }
      System.out.println();
    }
  }
}
