import java.util.*;
import java.io.*;

public class Main {
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    long[][] dp = new long[n+1][m+1];

    int[][] horizontal = new int[n+1][m+1];
    int[][] vertical = new int[n+1][m+1];

    int k = Integer.parseInt(br.readLine());

    for (int i = 0; i< k; i++){
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      if (x1 == x2) // 세로 선
        vertical[x1][Math.min(y1,y2)] = 1;
      else
        horizontal[Math.min(x1,x2)][y1] = 1;
    }

    for (int i = 1; i<=n; i++){ // 가로 초기화
      if (horizontal[i-1][0] == 1) break;
      dp[i][0] = 1;
    }

    for (int i = 1; i<=m; i++){ // 세로 초기화
      if (vertical[0][i - 1] == 1) break;
      dp[0][i] = 1;
    }

    for (int i = 1; i<= n;i ++){
      for (int j = 1; j <= m; j++){
        dp[i][j] = dp[i][j-1] + dp[i-1][j];

        if (horizontal[i-1][j] == 1)
          dp[i][j] -= dp[i-1][j];


        if (vertical[i][j - 1] == 1)
          dp[i][j] -= dp[i][j - 1];
        
      }
    }

    System.out.println(dp[n][m]);
  }
}
