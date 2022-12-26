package grace.datastructuresgroupstudy.week9;

public class AVLTree {

  private Node root;


  public void insert(int value) {
    this.root = insert(this.root, value);
  }

  // 삽입
  public Node insert(Node node, int newValue) {
    Node newNode = new Node(newValue);
    if(node == null) {
      return newNode;
    }

    // 삽입할 데이터가 부모노드의 값보다 작으면 왼쪽 하위 노드에 새로운 노드 삽입
    if(newValue < node.getValue()) {
      node.changeLeft(insert(node.getLeft(), newValue));
    }
    // 삽입할 데이터가 부모노드의 값보다 크면 오른쪽 하위 노드에 새로운 노드 삽입
    else if(newValue > node.getValue()) {
      node.changeRight(insert(node.getRight(), newValue));
    }
    else {
      return node;
    }

    // 사입이 완료되고 높이 갱신
    node.changeHeight(Math.max(findHeight(node.getLeft()), findHeight(node.getRight())) + 1);

    // 삽입으로 트리가 불균형되었을때 회전연산 진행
    return insertRotation(node, newValue);
  }

  public Node delete(int value) {
    return this.root = delete(root, value);
  }

  // 삭제
  public Node delete(Node node, int value) {

    if(node == null) {
      return node;
    }

    // 삭제할 노드 탐색
    // 삭제할 노드의 값이 부모노드의 값보다 작은 경우
    if(value < node.getValue()) {
      // 왼쪽 자식 노드 방향으로 삭제 재귀호출
      node.changeLeft(delete(node.getLeft(), value));
    }
    // 삭제할 노드의 값이 부모노드의 값보다 큰 경우
    else if(value > node.getValue()) {
      // 오른쪽 자식 노드 방향으로 삭제 재귀호출
      node.changeRight(delete(node.getRight(), value));
    }
    // 삭제할 노드 찾은경우
    else {
      // 삭제할 노드가 leaf 노드인 경우
      if(node.getLeft() == null && node.getRight() == null) {
        return null;
      }

      // 삭제할 노드가 하나의 자식노드를 가진경우
      if(node.getLeft() == null) {
        return node.getRight();
      }
      else if(node.getRight() == null) {
        return node.getLeft();
      }

      // 삭제할 노드가 두개의 자식노드를 가진경우
      Node maxLeftNode = node.getLeft();
      node.changeValue(maxLeftNode.getValue());
      node.changeLeft(delete(node.getLeft(), maxLeftNode.getValue()));

    }

    // 높이 갱신
    node.changeHeight(Math.max(findHeight(node.getLeft()), findHeight(node.getRight())) + 1);

    // 불균형 체크, 회전 수행
    return deleteRotation(node);
  }

  // 오른쪽 회전
  public Node rightRotation(Node parentNode) {

    Node newParentNode = parentNode.getLeft(); // 왼쪽 자식노드가 새로운 부모노드가 됨
    if(newParentNode == null) return null;
    Node subRightNode = newParentNode.getRight();     // 왼쪽 자식노드의 오른쪽 자식노드

    newParentNode.changeRight(parentNode);
    parentNode.changeLeft(subRightNode);

    // 높이 갱신
    parentNode.changeHeight(Math.max(findHeight(parentNode.getLeft()), findHeight(parentNode.getRight())) + 1);
    newParentNode.changeHeight(Math.max(findHeight(newParentNode.getLeft()), findHeight(newParentNode.getRight())) + 1);

    return newParentNode;
  }

  // 왼쪽 회전
  public Node leftRotation(Node parentNode) {

    Node newParentNode = parentNode.getRight(); // 오른쪽 자식노드가 새로운 부모노드가 됨
    if(newParentNode == null) return null;
    Node subLeftNode = newParentNode.getLeft(); // 오른쪽 자식노드의 왼쪽 자식노드

    newParentNode.changeLeft(parentNode);
    parentNode.changeRight(subLeftNode);

    // 높이 갱신
    parentNode.changeHeight(Math.max(findHeight(parentNode.getLeft()), findHeight(parentNode.getRight())) + 1);
    newParentNode.changeHeight(Math.max(findHeight(newParentNode.getLeft()), findHeight(newParentNode.getRight())) + 1);

    return newParentNode;
  }


  // 삽입시 - 불균형 해결 회전 연산
  public Node insertRotation(Node node, int value) {

    int balance = getBalance(node);

    // left - left 높이 차이가 1보다 크고, 삽입된 데이터가 상위노드의 데이터보다 작은 경우
    if(balance > 1 && value < node.getValue()) {
      System.out.println("left - left");
      return rightRotation(node); // 오른쪽 회전
    }

    // right - right 높이 차이가 -1보다 작고, 삽입된 데이터가 상위노드의 데이터보다 작은 경우
    if(balance < -1 && value > node.getValue()) {
      System.out.println("right - right");
      return leftRotation(node); // 왼쪽 회전
    }

    // left - right 높이 처이가 1보다 크고, 삽입된 데이터가 상위노드의 데이터보다 큰 경우
    if(balance > 1 && value > node.getValue()) {
      System.out.println("left - right");
      node.changeLeft(leftRotation(node.getLeft())); // 왼쪽 회전
      return rightRotation(node); // 오른쪽 회전
    }

    // right - left 높이 차이가 -1보다 작고, 삽입된 데이터가 상위노드의 데이터보다 큰 경우
    if(balance < -1 && value < node.getValue()) {
      System.out.println("right - left");
      node.changeRight(rightRotation(node.getRight())); // 오른쪽 회전
      return leftRotation(node); // 왼쪽 회전
    }

    return node;
  }

  // 삭제시 - 불균형 해결 회전 연산
  public Node deleteRotation(Node node) {

    int balance = getBalance(node);

    // left - left or left - right
    if(balance > 1) {
      // left - right
      if(getBalance(node.getLeft()) < 0) {
        node.changeLeft(leftRotation(node.getLeft()));
      }
      return rightRotation(node);
    }

    // right - right or right - left
    if(balance < 1) {
      // right - left
      if(getBalance(node.getRight()) < 0) {
        node.changeRight(rightRotation(node.getRight()));
      }
      return leftRotation(node);
    }

    return node;
  }


  public int getBalance(Node node) {
    if(node == null) {
      return 0;
    }
    return findHeight(node.getLeft()) - findHeight(node.getRight());
  }

  public int findHeight(Node node) {
    if(node == null) {
      return 0;
    }
    return node.getHeight();
  }


  public void traverse() {
    if(root == null) {
      return;
    }
    System.out.println("전위 순회 : ");
    root.preOrder();
    System.out.println();
    System.out.println("중위 순회 : ");
    root.inOrder();
    System.out.println();
    System.out.println("후위 순회 : ");
    root.postOrder();

  }

}
