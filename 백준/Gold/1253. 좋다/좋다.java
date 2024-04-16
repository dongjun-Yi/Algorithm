import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] a = new int[n];

    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }

    Arrays.sort(a);

    int result = 0;

    for (int i = 0; i < n; i++) {
      int target = a[i];
      int lt = 0;
      int rt = n - 1;

      while (lt < rt) {
        if ((a[lt] + a[rt]) == target) {
          if (lt != i && rt != i) {
            result++;
            break;
          }
          if (lt == i)
            lt++;
          if (rt == i)
            rt--;
        } else if ((a[lt] + a[rt]) < target) {
          lt++;
        } else {
          rt--;
        }
      }
    }
    System.out.println(result);
  }
}