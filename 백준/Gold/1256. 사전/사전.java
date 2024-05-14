import java.util.*;

public class Main {
  static int[][] D;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();
    D = new int[201][201]; // N+M = 200으로 초기화

    for(int i = 0; i <= 200; i++){
      for(int j = 0; j <=i; j++){
        if(i==j || j ==0){
          D[i][j] = 1;
        } else{
          D[i][j] = D[i-1][j-1] + D[i-1][j]; 
          if(D[i][j] >  1000000000)
            D[i][j] = 1000000001;
        }
      }
    }

    if(D[n+m][m] < k){
      System.out.println(-1);
      System.exit(0);
    } 

    while(!(n==0 && m==0)){
      if(D[n-1+m][m] >= k){
        System.out.print("a");
        n--;
      } else{
        k -= D[n-1+m][m];
        System.out.print("z");
        m--;
      }
    }

  }
}