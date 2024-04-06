import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    ArrayList<Integer> list = new ArrayList<Integer>(n);

    for(int i = 0; i < n; i++){
      list.add(Integer.parseInt(br.readLine()));
    }

    Collections.sort(list);

    StringBuilder sb = new StringBuilder();
    
    for(int i = 0; i < n; i++){
      sb.append(list.get(i) + "\n");
    }

    System.out.println(sb);
  }
}
