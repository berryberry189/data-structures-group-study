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
}
