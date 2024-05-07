import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Tree[] A = new Tree[n];
    sc.nextLine();
    for (int i = 0; i < n; i++) {
      String value = sc.nextLine();
      char parentValue = value.charAt(0);
      char leftValue = value.charAt(2);
      char rightValue = value.charAt(4);

      if (A[parentValue - 'A'] == null)
        A[parentValue - 'A'] = new Tree(parentValue);

      if (leftValue != '.') {
        A[leftValue - 'A'] = new Tree(leftValue);
        A[parentValue - 'A'].leftTree = A[leftValue - 'A'];
      }
      if (rightValue != '.') {
        A[rightValue - 'A'] = new Tree(rightValue);
        A[parentValue - 'A'].rightTree = A[rightValue - 'A'];
      }
    }

    preOrder(A[0]);
    System.out.println();
    inOrder(A[0]);
    System.out.println();
    postOrder(A[0]);
    System.out.println();
  }

  static void preOrder(Tree tree) {
    if (tree == null)
      return;
    System.out.print(tree.data);
    preOrder(tree.leftTree);
    preOrder(tree.rightTree);
  }

  static void inOrder(Tree tree) {
    if (tree == null)
      return;
    inOrder(tree.leftTree);
    System.out.print(tree.data);
    inOrder(tree.rightTree);
  }

  static void postOrder(Tree tree) {
    if (tree == null)
      return;

    postOrder(tree.leftTree);
    postOrder(tree.rightTree);
    System.out.print(tree.data);
  }
}

class Tree {
  char data;
  Tree leftTree;
  Tree rightTree;

  public Tree(char data) {
    this.data = data;
  }
}
