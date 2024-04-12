import java.util.*;
import java.io.*;

public class Main {
  static int v,e;
  static int[] parent;
  static ArrayList<Edge> edges = new ArrayList();
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int v = Integer.parseInt(st.nextToken());
    int e = Integer.parseInt(st.nextToken());

    parent = new int[v+1];

    for (int i = 1; i<=v;i++){
      parent[i] = i;
    }

    for (int i = 0; i< e;i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      edges.add(new Edge(cost, a,b));
    }

    Collections.sort(edges);

    int result = 0;
    
    for (Edge edge : edges){
      int cost = edge.distance;
      int a = edge.nodeA;
      int b = edge.nodeB;

      if (findParent(a) != findParent(b)){
        result += cost;
        unionParent(a,b);
      }
    }

    System.out.println(result);
  }

  static int findParent(int x){
    if (x == parent[x])
      return x;
    return parent[x] = findParent(parent[x]);
  }

  static void unionParent(int a, int b){
    a = findParent(a);
    b = findParent(b);

    if (a <b) parent[b] = a;
    else parent[a] =b;
  }
}

class Edge implements Comparable<Edge>{
  int distance;
  int nodeA;
  int nodeB;

  public Edge(int distance, int nodeA, int nodeB){
    this.distance = distance;
    this.nodeA = nodeA;
    this.nodeB = nodeB;
  }

  public int compareTo(Edge o){
    if (this.distance < o.distance)
      return -1;
    return 1;
  }
}