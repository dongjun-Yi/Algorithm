import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int scores[] = new int[n];

    for (int i = 0; i < n; i++) {
      scores[i] = scanner.nextInt();
    }
    scanner.close();

    Arrays.sort(scores);
    int max_value = scores[n - 1];
    double result = 0;

    for (int i = 0; i < n; i++) {
      result += (double) scores[i] / max_value * 100;
    }
    System.out.println(result / n);
  }
}
