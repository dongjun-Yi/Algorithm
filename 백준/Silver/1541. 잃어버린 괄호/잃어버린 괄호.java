import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] exp = sc.nextLine().split("-");
    int result = 0;
    
    for (int i = 0; i < exp.length; i++) {
      int num = makeNum(exp[i]);

      if (i == 0){ // 첫 번째 숫자는 result 변수에 담음
        result = num;
        continue;
      }
      result -= num; // 최소값 갱신
    }

    System.out.println(result);
  }

  static int makeNum(String s) {
    String[] nums = s.split("\\+");
    int sum = 0;

    for (int i = 0; i < nums.length; i++) {
      sum += Integer.parseInt(nums[i]);
    }
    return sum;
  }
}