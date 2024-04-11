import java.util.*;
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] T = new int[n+1];
    int[] P = new int[n+1];

    sc.nextLine();

    StringTokenizer st;
    for (int i = 1; i<= n;i ++){
      st = new StringTokenizer(sc.nextLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      T[i] = a;
      P[i] = b;
    }
    
    int[] D = new int[n+2];

    for (int i = n; i > 0; i--){
      if (i + T[i] <= n + 1){
        D[i] = Math.max(D[i+1], D[i+T[i]] + P[i]);
      } else{
        D[i] = D[i+1];
      }
    }
    System.out.println(D[1]);
  }
}
