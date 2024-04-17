import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    
    int n = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());

    int[] A= new int[n];
    Deque<Node> dq = new LinkedList();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i< n; i++){
      A[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i< n; i++){
      int now = A[i];
      while (!dq.isEmpty() && (dq.getLast().value > now)){
        dq.removeLast();
      }
      dq.add(new Node(now, i));

      if (dq.getFirst().index <= i - L){
        dq.removeFirst();
      }
      bw.write(dq.getFirst().value + " ");
    }

    bw.flush();
    bw.close();
  }
}

class Node {
  int value;
  int index;

  public Node(int value, int index){
    this.value = value;
    this.index = index;
  }
}
