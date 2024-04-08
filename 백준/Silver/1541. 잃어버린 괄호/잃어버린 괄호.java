import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] s = sc.nextLine().split("-");

    int result = 0;
    for (int i = 0; i < s.length; i++) {
      int temp = sum_pa(s[i]);

      if (i == 0) {
        result = temp;
        continue;
      }
      result -= temp;
    }
    System.out.println(result);
  }

  public static int sum_pa(String s) {
    String[] nums = s.split("\\+");
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += Integer.parseInt(nums[i]);
    }
    return sum;
  }
}
