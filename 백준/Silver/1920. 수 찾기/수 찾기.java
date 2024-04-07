import java.util.*;
import java.io.*;

public class Main {

  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    int m = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < m; i++) {
      int target = Integer.parseInt(st.nextToken());

      if (binarySearch(target)) {
        sb.append(1 + "\n");
      } else {
        sb.append(0 + "\n");
      }
    }

    System.out.print(sb);
  }

  static boolean binarySearch(int target) {

    int lt = 0;
    int rt = arr.length - 1;

    while (lt <= rt) {
      int mid = (lt + rt) / 2;

      if (arr[mid] == target)
        return true;
      else if (arr[mid] < target) {
        lt = mid + 1;
      } else {
        rt = mid - 1;
      }
    }
    return false;
  }
}
