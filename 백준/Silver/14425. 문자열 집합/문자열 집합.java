import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    Set<String> set = new TreeSet();

    for (int i = 0; i < n; i++) {
      set.add(sc.next());
    }

    int result = 0;

    for (int i = 0; i < m; i++) {
      String s = sc.next();

      if (set.contains(s)) {
        result++;
      }
    }

    System.out.println(result);
  }
}