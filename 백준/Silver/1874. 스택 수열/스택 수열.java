import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    int num = 1;
    Stack<Integer> stack = new Stack<Integer>();
    StringBuffer sb = new StringBuffer();

    for (int i = 0; i < n; i++) {
      int target = arr[i];

      if (target >= num) {
        while (target >= num) {
          stack.push(num++);
          sb.append("+\n");
        }
        stack.pop();
        sb.append("-\n");
      } else {
        int last = stack.pop();
        if (target < last) {
          System.out.println("NO");
          System.exit(0);
        }
        sb.append("-\n");
      }
    }
    System.out.println(sb.toString());
  }
}