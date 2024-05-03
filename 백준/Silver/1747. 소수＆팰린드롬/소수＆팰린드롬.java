import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] A = new int[10000001];

    for (int i = 2; i <= 10000000; i++) {
      A[i] = i;
    }

    for (int i = 2; i < Math.sqrt(10000001); i++) {
      if (A[i] == 0)
        continue;
      for (int j = i + i; j <= 10000000; j = j + i) {
        A[j] = 0;
      }
    }
    
    int i = n;
    while (true) {
      if ((A[i] != 0) && palindrome(String.valueOf(i))) {
        System.out.println(i);
        System.exit(0);
      }
      i++;
    }
  }

  static boolean palindrome(String s) {
    for (int i = 0; i < s.length() / 2; i++) {
      if (s.charAt(i) != s.charAt(s.length() - 1 - i))
        return false;
    }
    return true;
  }
}