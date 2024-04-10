import java.util.*;

public class Main {
  static int[][] board;
  static Map<Integer, String> map = new HashMap();
  // 우하좌상
  static int[] dx = { 0, 1, 0, -1 };
  static int[] dy = { 1, 0, -1, 0 };
  static int d = 0;

  static Queue<int[]> q = new LinkedList();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
    board = new int[n][n];

    int k = Integer.parseInt(sc.nextLine());

    StringTokenizer st;
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(sc.nextLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      board[a - 1][b - 1] = 2;
    }

    int z = Integer.parseInt(sc.nextLine());

    for (int i = 0; i < z; i++) {
      st = new StringTokenizer(sc.nextLine());
      int t = Integer.parseInt(st.nextToken());
      String direction = st.nextToken();

      map.put(t, direction);
    }

    int time = 0;
    int x = 0;
    int y = 0;
    board[x][y] = 1;
    q.add(new int[] { x, y });

    while (true) {
      time += 1;
      int nx = x + dx[d];
      int ny = y + dy[d];

      if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1)
        break;
      if (board[nx][ny] == 2) { // 사과라면
        q.add(new int[] { nx, ny });
        board[nx][ny] = 1;
      } else {
        int[] temp = q.poll();
        int px = temp[0];
        int py = temp[1];
        board[px][py] = 0;
        q.add(new int[] { nx, ny });
        board[nx][ny] = 1;
      }

      for (int i : map.keySet()) {
        if (time == i) {
          String c = map.get(i);
          changeDirection(c);
        }
      }
      x = nx;
      y = ny;
    }

    System.out.println(time);

  }

  static void changeDirection(String c) {
    if (c.equals("D")) { // 오른쪽 회전
      d++;
      if (d == 4)
        d = 0;
    } else {
      d--;
      if (d == -1)
        d = 3;
    }
  }

  static void printArray(int[][] board) {
    for (int[] a : board) {
      System.out.println(Arrays.toString(a));
    }
  }
}
