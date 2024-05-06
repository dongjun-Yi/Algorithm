import java.util.*;

public class Main {
  static ArrayList<Integer>[] g;
  static boolean[] visited;
  static int deleteNode;
  static int answer = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    g = new ArrayList[n];
    visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      g[i] = new ArrayList();
    }
    int root = 0;

    for (int i = 0; i < n; i++) {
      int node = sc.nextInt();
      if (node == -1) {
        root = i;
        continue;
      }
      g[node].add(i);
      g[i].add(node);
    }

    deleteNode = sc.nextInt();

    if (deleteNode == root) {
      System.out.println(0);
    } else {
      dfs(root);
      System.out.println(answer);
    }
  }

  static void dfs(int v) {
    visited[v] = true;
    int childCnt = 0;
    for (int x : g[v]) {
      if ((!visited[x]) && (x != deleteNode)) {
        childCnt++;
        dfs(x);
      }
    }

    if (childCnt == 0) {
      answer++;
    }
  }
}