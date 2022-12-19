package grace.datastructuresgroupstudy.week8;

public class BinarySearchTree {

  private Node root;
  private int size;

  public BinarySearchTree() {
    this.root = null;
    this.size = 0;
  }

  public int getSize() {
    return size;
  }

  public void iteratePreOrder(){
    if (root != null) {
      root.preOrder();
    }
  }

  public void iterateInOrder(){
    if (root != null) {
      root.inOrder();
    }
  }

  public void iteratePostOrder(){
    if (root != null) {
      root.postOrder();
    }
  }

  // key값 노드가 있다면 해당노드를, 없다면 노드가 삽입될 부모노드 return
  public Node findLocation(int key){
    if (this.size == 0) {
      return null;
    }
    Node parent = null;
    Node current = this.root;

    while (current != null) {
      if (current.getValue() == key) {
        return current;
      } else if (current.getValue() < key) { // 찾으려는 key값이 더 크면 오른쪽으로
        parent = current;
        current = current.getRight();
      } else { // 찾으려는 key값이 더 작으면 왼쪽으로
        parent = current;
        current = current.getLeft();
      }
    }
    return parent;
  }

  public Node search(int key){
    Node current = findLocation(key);
    if (current != null && current.getValue() == key) {
      return current;
    } else {
      return null;
    }
  }

  public Node insert(int value){
    Node parent = findLocation(value);
    Node newNode = new Node(value);

    if (parent == null || parent.getValue() != value) {
      if (parent == null) {
        this.root = newNode;
      } else  {
        if (parent.getValue() >= value) {
          parent.changeLeft(newNode);
          newNode.changeParent(parent);
        } else {
          parent.changeRight(newNode);
          newNode.changeParent(parent);
        }
      }
    } else {
      System.out.println("key is already exist");
      return parent;
    }
    this.size += 1;
    return newNode;
  }

  public void deleteNodeByMerging(int key){
    Node searchNode = search(key);
    Node leftNode = searchNode.getLeft();
    Node rightNode = searchNode.getRight();
    Node pt = searchNode.getParent();
    Node replaceNode; // x자리를 대체할 노드
    Node leftMaxNode; // 왼쪽 서브트리에서 최대값을 가지는 노드

    // 왼쪽 서브트리가 존재하는 경우
    if (leftNode != null) {
      replaceNode = leftNode;
      leftMaxNode = leftNode;
      while (leftMaxNode.getRight() != null) {
        leftMaxNode = leftMaxNode.getRight();
      }

      if (rightNode != null) {
        // 왼쪽 서브트리의 최대값 노드를 b의 부모로 설정
        rightNode.changeParent(leftMaxNode);
        leftMaxNode.changeRight(rightNode);
      }
    } else { // 왼쪽 서브트리가 존재하지 않는다면, 오른쪽 서브트리로 대체
      replaceNode = rightNode;
    }

    // x가 루트노드인 경우
    if (pt == null) {
      this.root = replaceNode;
      replaceNode.changeParent(null);
    } else {
      if (replaceNode != null) {
        replaceNode.changeParent(pt);
      }
      if (pt.getValue() >= replaceNode.getValue()) {
        pt.changeLeft(replaceNode);
      } else {
        pt.changeRight(replaceNode);
      }
    }
    this.size -= 1;
  }


}
