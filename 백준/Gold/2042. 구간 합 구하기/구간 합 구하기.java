import java.util.*;
import java.io.*;

public class Main {
  static long[] tree;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int treeHeight = 0;

    int length = n;

    while (length > 0) {
      treeHeight++;
      length /= 2;
    }

    int treeSize = (int) Math.pow(2, treeHeight + 1); // 2^k * 2 = 2^(k+1)
    tree = new long[treeSize + 1];
    int nodeStartIndex = treeSize / 2 - 1;

    for (int i = nodeStartIndex + 1; i <= nodeStartIndex + n; i++) {
      tree[i] = Long.parseLong(br.readLine());
    }

    initSegTree(treeSize - 1);

    for (int i = 0; i < m + k; i++) {
      st = new StringTokenizer(br.readLine());
      long a = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      long e = Long.parseLong(st.nextToken());

      if (a == 1) {
        updateTree(nodeStartIndex + s, e);
      } else if (a == 2) {
        s = s + nodeStartIndex;
        e = e + nodeStartIndex;
        System.out.println(getSum(s, (int)e));
      }
    }

  }

  static long getSum(int s, int e){
    long sum = 0;

    while(s<=e){
      if(s%2 == 1){
        sum += tree[s];
        s++;
      }
      if (e%2 == 0){
        sum += tree[e];
        e--;
      }
      s/=2;
      e/=2;
    }
    return sum;
  }

  static void updateTree(int index, long val){
    long diff = val - tree[index];
    while(index > 0){
      tree[index] = tree[index] + diff;
      index /=2;
    }
  }

  static void initSegTree(int i){
    while (i > 0){
      tree[i/2] += tree[i];
      i--;
    }
  }
}