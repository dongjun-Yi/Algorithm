import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    for (int i = 0; i < t; i++) {
      StringBuilder sb = new StringBuilder();

      int r = sc.nextInt();
      String str = sc.next();

      for (String s : str.split("")) {
        for (int j = 0; j < r; j++) {
          sb.append(s);
        }
      }
      System.out.println(sb.toString());
    }

  }
}