import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
      public int compare(Integer i1, Integer i2) {
        if (Math.abs(i1) == Math.abs(i2)) {
          return i1 - i2;
        }
        return Math.abs(i1) - Math.abs(i2);
      }
    });

    for (int i = 0; i < n; i++) {
      int x = sc.nextInt();

      if (x != 0) {
        pq.offer(x);
      } else {
        if (pq.isEmpty()){
          System.out.println(0);
          continue;
        }
          
        System.out.println(pq.poll());
      }
    }

  }
}