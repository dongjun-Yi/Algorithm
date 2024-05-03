import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long min = sc.nextLong();
    long max = sc.nextLong();

    boolean[] A = new boolean[(int) (max - min) + 1];

    for(long i = 2; i * i <= max; i++){
      long pow = i * i; // 제곱수
      long startIndex = min / pow; // 시작 위치

      if(min % pow != 0)
        startIndex++;

      for(long j = startIndex; j * pow <= max; j++){
        A[(int) ((j*pow) - min)] = true;
      }
    }

    int result = 0;
    for(int i = 0 ; i <= max - min; i++){
      if(!A[i]){
        result++;
      }
    }

    System.out.println(result);
  }
}