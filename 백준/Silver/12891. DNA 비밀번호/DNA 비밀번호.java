import java.util.*;
import java.io.*;

public class Main {
  static int[] myArr;
  static int[] checkArr;
  static int checkSecret = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int s = Integer.parseInt(st.nextToken());

    int p = Integer.parseInt(st.nextToken());

    char[] dnaArray = br.readLine().toCharArray();
    myArr = new int[4];

    st = new StringTokenizer(br.readLine());

    int result = 0;
    checkArr = new int[4];
    for (int i = 0; i < 4; i++) {
      checkArr[i] = Integer.parseInt(st.nextToken());
      if (checkArr[i] == 0) {
        checkSecret++;
      }
    }

    for (int i = 0; i < p; i++) { // 초기 슬라이딩 윈도우
      add(dnaArray[i]);
    }

    if (checkSecret == 4)
      result++;

    for (int i = p; i < s; i++) {
      int j = i - p; // 슬라이딩 윈도우가 이동 후 윈도우 범위를 벗어난 인덱스
      add(dnaArray[i]);
      remove(dnaArray[j]);
      if (checkSecret == 4)
        result++;
    }

    System.out.println(result);
  }

  public static void add(char c) {
    switch (c) {
      case 'A':
        myArr[0]++;
        if (myArr[0] == checkArr[0])
          checkSecret++;
        break;
      case 'C':
        myArr[1]++;
        if (myArr[1] == checkArr[1])
          checkSecret++;
        break;
      case 'G':
        myArr[2]++;
        if (myArr[2] == checkArr[2])
          checkSecret++;
        break;
      case 'T':
        myArr[3]++;
        if (myArr[3] == checkArr[3])
          checkSecret++;
        break;

    }
  }

  public static void remove(char c) {
    switch (c) {
      case 'A':
        if (myArr[0] == checkArr[0])
          checkSecret--;
        myArr[0]--;
        break;
      case 'C':
        if (myArr[1] == checkArr[1])
          checkSecret--;
        myArr[1]--;
        break;
      case 'G':
        if (myArr[2] == checkArr[2])
          checkSecret--;
        myArr[2]--;
        break;
      case 'T':
        if (myArr[3] == checkArr[3])
          checkSecret--;
        myArr[3]--;
        break;
    }
  }
}
