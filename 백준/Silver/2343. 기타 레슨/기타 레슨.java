import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] A = new int[n];
    int lt = 0;
    int rt = 0;

    for (int i = 0; i < n; i++) {
      A[i] = sc.nextInt();
      if (lt < A[i])
        lt = A[i];
      rt += A[i];
    }

    while (lt <= rt) {
      int mid = (lt + rt) / 2;

      int count = getCount(n, A, mid);

      if (count > m)
        lt = mid + 1;
      else
        rt = mid - 1;
    }

    System.out.println(lt);

  }

  static int getCount(int n, int[] A, int mid) {
    int count = 0;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      if (sum + A[i] > mid) {
        count++;
        sum = A[i];
        continue;
      }
      sum += A[i];
    }
    if (sum != 0)
      count++;
    return count;
  }
}