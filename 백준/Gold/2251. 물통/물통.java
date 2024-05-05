import java.util.*;

public class Main {
  static int[] sender = { 0, 0, 1, 1, 2, 2 };
  static int[] receiver = { 1, 2, 0, 2, 0, 1 };
  static boolean[][] visited = new boolean[201][201];
  static boolean[] answer = new boolean[201];
  static int[] now = new int[3]; // 현재 용량 담을 배열

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    now[0] = sc.nextInt();
    now[1] = sc.nextInt();
    now[2] = sc.nextInt();

    bfs();

    for (int i = 0; i < 201; i++) {
      if (answer[i])
        System.out.print(i + " ");
    }

  }

  static void bfs() {
    Queue<Volume> q = new LinkedList();
    q.add(new Volume(0, 0, now[2]));
    visited[0][0] = true;
    answer[now[2]] = true;

    while (!q.isEmpty()) {
      Volume v = q.poll();
      int A = v.getA();
      int B = v.getB();
      int C = v.getC();

      for (int i = 0; i < 6; i++) {
        int[] next = { A, B, C };
        next[receiver[i]] += next[sender[i]]; // 물을 옮김
        next[sender[i]] = 0; // 다 옮긴 물통은 0으로 update

        if (next[receiver[i]] > now[receiver[i]]) { // 만약 합쳐진 물의 양이 수용량보다 클경우
          next[sender[i]] = next[receiver[i]] - now[receiver[i]]; // 원래 보내진 넘쳐진 물량 - 물통 수용량
          next[receiver[i]] = now[receiver[i]]; // 물통 최대값으로 update
        }

        if (!visited[next[0]][next[1]]) {
          visited[next[0]][next[1]] = true;
          q.add(new Volume(next[0], next[1], next[2]));
          if (next[0] == 0) {// A의 물이 0이면 정답 기록
            answer[next[2]] = true;
          }
        }
      }
    }
  }
}

class Volume {
  int a;
  int b;
  int c;

  public Volume(int a, int b, int c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  public int getA() {
    return this.a;
  }

  public int getB() {
    return this.b;
  }

  public int getC() {
    return this.c;
  }
}