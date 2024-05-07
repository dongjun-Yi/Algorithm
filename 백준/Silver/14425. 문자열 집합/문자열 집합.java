import java.util.*;

public class Main {
  static Scanner sc;

  public static void main(String[] args) {
    sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    Trie root = new Trie();
    makeTrie(root, n);
    int result = findStrings(root, m);
    System.out.println(result);
  }

  static int findStrings(Trie root, int m) {
    int count = 0;
    while (m > 0) {
      String text = sc.next();
      Trie now = root;

      for (int i = 0; i < text.length(); i++) {
        char c = text.charAt(i);
        int index = c - 'a';
        if (now.next[index] == null)
          break;

        now = now.next[index];
        if (i == text.length() - 1 && now.isEnd == true) {
          count++;
        }
      }
      m--;
    }
    return count;
  }

  static void makeTrie(Trie root, int n) {
    while (n > 0) {
      String text = sc.next();
      Trie now = root;

      for (int i = 0; i < text.length(); i++) {
        char c = text.charAt(i);
        int index = c - 'a';
        if (now.next[index] == null) {
          now.next[index] = new Trie();
        }
        now = now.next[index];
        if (i == text.length() - 1)
          now.isEnd = true;
      }
      n--;
    }
  }
}

class Trie {
  Trie[] next = new Trie[26];
  boolean isEnd;
}