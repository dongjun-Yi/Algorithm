import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    PriorityQueue<Integer> q = new PriorityQueue<Integer>(new MyComparator());

    for (int i = 0; i < n; i++) {
      int cur = sc.nextInt();

      if (cur == 0) {
        if (q.isEmpty()) {
          System.out.println(0);
          continue;
        }
        System.out.println(q.poll());
      } else {
        q.add(cur);
      }
    }
  }
}

class MyComparator implements Comparator<Integer> {
  public int compare(Integer i1, Integer i2) {
    if (Math.abs(i1) == Math.abs(i2)) {
      return i1 > i2 ? 1 : -1;
    }
    return Math.abs(i1) - Math.abs(i2);
  }
}