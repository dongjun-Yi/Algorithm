import java.util.*;

public class Main {
  static int n;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    dfs(1, 2);
    dfs(1, 3);
    dfs(1, 5);
    dfs(1, 7);
  }

  public static void dfs(int Level, int number) {
    if (Level == n)
      System.out.println(number);

    for (int i = 1; i < 10; i++) {
      if (i % 2 == 0)
        continue;

      if (isPrime(number * 10 + i)) {
        dfs(Level + 1, number * 10 + i);
      }
    }
  }

  public static boolean isPrime(int number) {

    for (int i = 2; i < number / 2; i++) {
      if (number % i == 0)
        return false;
    }
    return true;
  }
}
