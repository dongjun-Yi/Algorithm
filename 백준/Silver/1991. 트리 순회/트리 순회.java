import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Tree[] tree = new Tree[n]; // 트리들의 자식 정보들을 관리할 배열
    for (int i = 0; i < n; i++) {
      char root = sc.next().charAt(0);
      char left = sc.next().charAt(0);
      char right = sc.next().charAt(0);

      if (tree[root - 'A'] == null) {
        tree[root - 'A'] = new Tree(root);
      }

      if (left != '.') {
        tree[left - 'A'] = new Tree(left);
        tree[root - 'A'].left = tree[left - 'A'];
      }
      if (right != '.') {
        tree[right - 'A'] = new Tree(right);
        tree[root - 'A'].right = tree[right - 'A'];
      }
    }

    preOrder(tree[0]);
    System.out.println();
    inOrder(tree[0]);
    System.out.println();
    postOrder(tree[0]);

  }

  static void preOrder(Tree tree) {
    if (tree == null)
      return;
    System.out.print(tree.root);
    preOrder(tree.left);
    preOrder(tree.right);
  }

  static void inOrder(Tree tree) {
    if (tree == null)
      return;
    inOrder(tree.left);
    System.out.print(tree.root);
    inOrder(tree.right);
  }

  static void postOrder(Tree tree) {
    if (tree == null)
      return;
    postOrder(tree.left);
    postOrder(tree.right);
    System.out.print(tree.root);
  }
}

class Tree {
  char root;
  Tree left;
  Tree right;

  public Tree(char root) {
    this.root = root;
  }
}