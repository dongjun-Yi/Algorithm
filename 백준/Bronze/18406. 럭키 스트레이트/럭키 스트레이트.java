import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    char[] str = sc.nextLine().toCharArray();

    int[] arr = new int[str.length];
    for (int i = 0; i < str.length; i++) {
      arr[i] = str[i] - '0';
    }

    int n = arr.length / 2;

    int sum1 = 0;
    int sum2 = 0;

    for (int i = 0; i < n; i++) {
      sum1 += arr[i];
    }
    for (int i = n; i < arr.length; i++) {
      sum2 += arr[i];
    }

    if (sum1 == sum2)
      System.out.println("LUCKY");
    else
      System.out.println("READY");
  }
}
