import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    int[][] D = new int[15][15];

    for(int i = 1;i<= 14; i++){
      D[0][i] = i;
    }

    for(int i = 1; i <=14; i++){
      for(int j = 1; j<=14; j++){
        for(int k = 1; k <=j;k++){
          D[i][j] += D[i-1][k];
        }
      }
    }
    
    for(int i = 0; i < T; i++){
      int a = sc.nextInt();
      int b = sc.nextInt();
      System.out.println(D[a][b]);
    }
  }

}