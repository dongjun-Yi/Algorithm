import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] A = new int[n];
    int[] answer = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i< n; i++){
      A[i] = Integer.parseInt(st.nextToken());
    }

    Stack<Integer> stack = new Stack();

    stack.add(0);

    for (int i =1 ;i < n; i++){
      while ((!stack.isEmpty()) && A[stack.peek()] < A[i]){
        answer[stack.pop()] = A[i];
      }
      stack.add(i);
    }

    while(!stack.isEmpty())
      answer[stack.pop()] = -1;

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i< n; i++){
      sb.append(answer[i] +" ");
    }

    System.out.println(sb.toString());
  }
}