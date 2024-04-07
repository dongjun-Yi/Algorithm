import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    StringTokenizer st = new StringTokenizer(sc.nextLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    Integer[] arr = new Integer[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(sc.nextLine());
    }

    Arrays.sort(arr, Collections.reverseOrder());

    int result = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] <= k) {
        int temp = (k / arr[i]);
        result += temp;
        k -= temp * arr[i];
      }
    }

    System.out.println(result);
  }
}
