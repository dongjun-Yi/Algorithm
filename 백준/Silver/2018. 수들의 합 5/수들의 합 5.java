import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] a = new int[n+1];

    for(int i = 0; i < n; i++){
      a[i] = i+1;
    }
    int lt = 0;
    int rt = 0;
    int sum = a[0];
    int result = 0;

    while(rt < n){
      if(sum < n){
        rt++;
        sum += a[rt];
      } else if(sum > n){
        sum -= a[lt];
        lt++;
      } else{
        result++;
        rt++;
        sum += a[rt];
      }
    }

    System.out.println(result);
  }
}