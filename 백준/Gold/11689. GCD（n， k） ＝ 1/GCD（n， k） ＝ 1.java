import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(br.readLine());

    long result = n;

    for(int i = 2; i <= Math.sqrt(n); i++){
      if (n % i == 0) { // n의 소인수 일때
        result = result - result / i;
      }
      
      while(n % i == 0){ // n의 소인수가 중복으로 겹치게 되면 처리된것을 표시하기 위해 나눠줌.
        n /= i;
      }
    }

    if (n > 1) // n이 1보다 크다는 것은 마지막 소인수를 뜻함.
      result = result - result /n;
    System.out.println(result);
  }
}