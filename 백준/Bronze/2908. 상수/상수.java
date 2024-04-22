import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s1 = sc.next();
    String s2 = sc.next();

    String rs1 = "";
    String rs2 = "";

    for (int i = s1.length() - 1; i >= 0; i--) {
      rs1 += String.valueOf(s1.charAt(i));
    }

    for (int i = s2.length() - 1; i >= 0; i--) {
      rs2 += String.valueOf(s2.charAt(i));
    }

    if (Integer.parseInt(rs1) > Integer.parseInt(rs2)) {
      System.out.println(rs1);
    } else {
      System.out.println(rs2);
    }
  }
}