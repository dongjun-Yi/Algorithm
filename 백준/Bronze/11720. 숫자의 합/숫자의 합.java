import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    String str = scanner.next();
    char[] arr = str.toCharArray();
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += arr[i] - 48;
    }
    System.out.println(sum);
    scanner.close();
  }
}
