import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] A = new int[n];
    for (int i = 0; i < n; i++) {
      A[i] = sc.nextInt();
    }

    int num = 1; // 스택에 넣을 숫자.
    Stack<Integer> stack = new Stack<Integer>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      int target = A[i];

      if (target < num) {
        int pop = stack.pop();
        if (target < pop) {
          System.out.println("NO");
          System.exit(0);
        }
        sb.append("-\n");
      } else {
        while (target >= num) {
          stack.add(num++);
          sb.append("+\n");
        }
        stack.pop();
        sb.append("-\n");
      }
    }
    System.out.println(sb.toString());
  }
}