import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

    for (int i = 0; i < n; i++) {
      pq.add(Integer.parseInt(br.readLine()));
    }
    int sum = 0;
    while (pq.size() > 1) {
      int A = pq.poll();
      int B = pq.poll();
      sum += A + B;
      pq.add(A + B);
    }

    System.out.println(sum);
  }
}