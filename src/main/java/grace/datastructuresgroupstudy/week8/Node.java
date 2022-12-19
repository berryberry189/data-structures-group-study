package grace.datastructuresgroupstudy.week8;

public class Node {

  private final Integer value;
  private Node left;
  private Node right;
  private Node parent;

  public Node(Integer value) {
    this.value = value;
    this.left = null;
    this.right = null;
    this.parent = null;
  }

  public void changeParent(Node parent) {
    this.parent = parent;
  }

  public void changeLeft(Node left) {
    this.left = left;
  }

  public void changeRight(Node right) {
    this.right = right;
  }

  public int getValue() {
    return value;
  }

  public Node getLeft() {
    return left;
  }

  public Node getRight() {
    return right;
  }

  public Node getParent() {
    return parent;
  }

  public void preOrder() {
    System.out.print(value);
    if (left != null) {
      left.preOrder();
    }
    if (right != null) {
      right.preOrder();
    }
    if (this == null) {
      System.out.println("빈 노드입니다.");
    }
  }

  public void inOrder(){
    if (this != null) {
      if (this.left != null) {
        this.left.inOrder();
      }
      System.out.print(this.value);
      if (this.right != null) {
        this.right.inOrder();
      }
    } else {
      System.out.println("빈 노드입니다.");
    }
  }

  public void postOrder(){
    if (this != null) {
      if (this.left != null) {
        this.left.postOrder();
      }

      if (this.right != null) {
        this.right.postOrder();
      }

      System.out.print(this.value);
    } else {
      System.out.println("빈 노드입니다.");
    }
  }
}
