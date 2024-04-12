import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[][] meetings = new int[n][2];

    for (int i = 0; i < n; i++) {
      meetings[i][0] = sc.nextInt();
      meetings[i][1] = sc.nextInt();
    }

    Arrays.sort(meetings, new Comparator<int[]>() {
      public int compare(int[] o1, int[] o2) {
        if (o1[1] == o2[1])
          return o1[0] - o2[0];
        return o1[1] - o2[1];
      }
    });

    int time = 0;
    int result = 0;

    for (int i = 0; i < n; i++) {
      if (time <= meetings[i][0]) {
        time = meetings[i][1];
        result++;
      }
    }

    System.out.println(result);

  }
}