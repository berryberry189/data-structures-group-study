package grace.datastructuresgroupstudy.week9;

public class Node {

  private int value;
  private int height;
  private Node left;
  private Node right;

  public Node(Integer value) {
    this.value = value;
    this.height = 1;
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

  public int getHeight() {
    return height;
  }

  public void changeLeft(Node left) {
    this.left = left;
  }

  public void changeRight(Node right) {
    this.right = right;
  }

  public void changeHeight(int height) {
    this.height = height;
  }

  public void changeValue(int value) {
    this.value = value;
  }

  // 전위
  public void preOrder() {
    if (this == null) {
      System.out.println("빈 노드입니다.");
    }
    System.out.print(this.value + "-");
    if (left != null) {
      left.preOrder();
    }
    if (right != null) {
      right.preOrder();
    }
  }

  // 중위
  public void inOrder(){
    if (this == null) {
      System.out.println("빈 노드입니다.");
    }
    if (this.left != null) {
      this.left.inOrder();
    }
    System.out.print(this.value + "-");
    if (this.right != null) {
      this.right.inOrder();
    }

  }

  // 후위
  public void postOrder(){
    if (this == null) {
      System.out.println("빈 노드입니다.");
    }
    if (this.left != null) {
      this.left.postOrder();
    }
    if (this.right != null) {
      this.right.postOrder();
    }
    System.out.print(this.value + "-");

  }


}
