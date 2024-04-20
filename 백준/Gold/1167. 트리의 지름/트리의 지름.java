import java.util.*;
import java.io.*;

public class Main {
  static ArrayList<ArrayList<Node>> g;
  static boolean[] visited;
  static int result = 0;
  static int farNode;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int v = Integer.parseInt(br.readLine());
    g = new ArrayList();

    for (int i = 0; i <= v; i++) {
      g.add(new ArrayList());
    }

    StringTokenizer st;
    for (int i = 1; i <= v; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());

      while (true) {
        int vertex = Integer.parseInt(st.nextToken());
        if (vertex == -1)
          break;
        int cost = Integer.parseInt(st.nextToken());
        g.get(a).add(new Node(vertex, cost));
      }
    }

    visited = new boolean[v + 1];
    dfs(1, 0);

    visited = new boolean[v + 1];
    dfs(farNode, 0);

    System.out.println(result);
  }

  static void dfs(int v, int cost) {
    if (result < cost) {
      result = cost;
      farNode = v;
    }

    if (visited[v])
      return;
    visited[v] = true;

    for (Node n : g.get(v)) {
      if (!visited[n.getVertex()]) {
        dfs(n.getVertex(), cost + n.getCost());
      }
    }
    visited[v] = false;
  }
}

class Node {
  private int vertex;
  private int cost;

  public Node(int vertex, int cost) {
    this.vertex = vertex;
    this.cost = cost;
  }

  public int getVertex() {
    return vertex;
  }

  public int getCost() {
    return cost;
  }
}