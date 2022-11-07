package grace.datastructuresgroupstudy.week4;

public class Node {
  private final int key;
  private Node next;

  public Node(int key) {
    this.key = key;
    this.next = null;
  }

  public void changeNext(Node node) {
    this.next = node;
  }

  public int getKey() {
    return key;
  }

  public Node getNext() {
    return next;
  }

  @Override
  public String toString() {
    return "Node{" +
        "key=" + key +
        ", nextKey=" + (next != null ? next.getKey() : "") +
        '}';
  }
}
