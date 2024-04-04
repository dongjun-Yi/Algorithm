import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int target = sc.nextInt() * sc.nextInt() * sc.nextInt();

    String str = Integer.toString(target);

    int[] result = new int[10];

    // i는 기준 숫자
    for (int i = 0; i< 10; i++){
      int count = 0;

      for (int j = 0; j< str.length();j++){
        if (i == (str.charAt(j) - '0'))
          count++;
      }
      result[i] = count;
    }

    for (int i = 0; i< 10; i++){
      System.out.println(result[i]);
    }
  }
}
