package grace.datastructuresgroupstudy.week5;

public class DoublyLinkedList {

  private Node head;
  private Node tail;
  private int size;

  public DoublyLinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public void pushFront(int key) {
    Node newNode = new Node(key);
    if(size == 0) {
      this.head = newNode;
    } else {
      Node originHead = this.head;
      newNode.changeNext(originHead);
      originHead.changePrev(newNode);
      this.head = newNode;
    }
    this.size++;
  }

  public void splice(Node a, Node b, Node x) {
    //if(a == null || b == null || x == null)

    Node aPrev = a.getPrev();
    Node bNext = b.getNext();

    // 자르기
    aPrev.changeNext(bNext);
    bNext.changePrev(aPrev);

    // x 뒤에 a~b 삽입
    Node xNext = x.getNext();
    x.changeNext(a);
    a.changePrev(x);
    b.changeNext(xNext);
    xNext.changePrev(b);

  }

  public Integer[] toArray() {
    Integer[] array = new Integer[size];
    int idx = 0;
    for (Node x = head; x != null; x = x.getNext()) {
      array[idx++] = x.getKey();
    }
    return array;
  }






}
