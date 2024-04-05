import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String input = sc.next();

    Integer[] arr = new Integer[input.length()];

    for (int i = 0; i < input.length(); i++) {
      arr[i] = input.charAt(i) - '0';
    }

    Arrays.sort(arr, Collections.reverseOrder());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
      sb.append(arr[i]);
    }

    System.out.println(sb.toString());
  }
}
