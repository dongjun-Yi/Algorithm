import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] A = new int[n];

    for (int i = 0; i< n; i++){
      A[i] = sc.nextInt();
    }

    int[] DL = new int[n];
    int[] DR = new int[n];

    int result = A[0];
    DL[0] = A[0];
    
    for (int i = 1; i < n; i++){
      DL[i] = Math.max(DL[i-1] + A[i], A[i]);  
      result = Math.max(result, DL[i]);
    }

    DR[n-1] = A[n-1];

    for (int i = n-2; i>=0; i--){
      DR[i] = Math.max(DR[i+1] + A[i], A[i]);  
    }

    for (int i = 1; i< n-1; i++){
      int temp = DL[i-1] + DR[i+1];
      result = Math.max(result, temp);
    }

    System.out.println(result);
  }
}
