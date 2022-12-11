package grace.datastructuresgroupstudy.week8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BinarySearchTree {

  private Node root;
  private int size;

  public BinarySearchTree() {
    this.root = null;
    this.size = 0;
  }

  public Node insert(Integer value) {
    Node newNode = new Node(value);
    if(root == null) {
      root = newNode;
      return root;
    }

    Node parent = null;
    Node current = root;

    while(true) {
      parent = current;
      if(current.getValue() > value) {
        current = parent.getLeft();
        if(current == null) {
          parent.changeLeft(newNode);
          break;
        }
      } else {
        current = parent.getRight();
        if(current == null) {
          parent.changeRight(newNode);
          break;
        }
      }
    }
    newNode.changeParent(parent);

    size ++;
    return parent;
  }

  public Node search(Integer value) {
    if(root == null) return null;
    Node parent = null;
    Node current = root;
    while(current.getValue() != value){
      if(current.getValue() == value) return current;
      if(current.getValue() > value){  // 현재 값이 전달된 값보다 더 크다면
        parent = current;
        current = current.getRight();
      } else {
        parent = current;
        current = current.getRight();
      }
    }
    return parent;
  }

  public Node remove(Integer value){
    Node target = search(value);
    Node parent = target.getParent();

    // 부모 노드와 현재 target 노드의 관계 알아내기
    boolean isLeft = target.equals(root) ? false : target.equals(parent.getLeft()) ? true : false;

    Node replacement;
    // 자식 노드가 없는 경우
    if(target.getLeft() == null && target.getRight() == null){
      target = null;

      // 왼쪽 자식 노드만 있는 경우
    } else if(target.getRight() == null){
      replacement = target.getLeft();
      if(target.equals(root)){  // root를 삭제한다면 root 정보를 바꿔준다.
        root = replacement;
      } else if(isLeft){
        parent.changeLeft(replacement); // parent와의 관계를 통해 연결해준다.
      } else {
        parent.changeRight(replacement);
      }
      replacement.changeParent(parent);  // 대체된 노드의 parent도 변경한다.

      // 우측 자식 노드만 있는 경우
    } else if(target.getLeft() == null){
      replacement = target.getRight();
      if(target.equals(root)){  // root를 삭제한다면 root 정보를 바꿔준다.
        root = replacement;
      } else if(isLeft){
        parent.changeLeft(replacement); // parent와의 관계를 통해 연결해준다.
      } else {
        parent.changeRight(replacement);
      }
      replacement.changeParent(parent);  // 대체된 노드의 parent도 변경한다.

      // 양 쪽 자식 노드가 모두 있는 경우
    } else {
      // 이번 코드 예시에선 좌측 서브 트리의 가장 큰 노드로 대체해보자.
      Node leftSubTreeRoot = target.getLeft();
      Node rightSubTreeRoot = target.getRight();

      replacement = getSubTreeMax(leftSubTreeRoot);
      replacement.getParent().changeRight(null);  // 대체 노드로 사용했으니 해당 자리는 null로 변경

      // 대체된 후 모든 관계를 바꿔주어야 함.
      if(target.equals(root)){
        root = replacement;
      } else if(isLeft){
        parent.changeLeft(replacement);
      } else {
        parent.changeRight(replacement);
      }
      replacement.changeLeft(leftSubTreeRoot);
      replacement.changeRight(rightSubTreeRoot);
      replacement.changeParent(parent);
    }
    return target;
  }

  public Node getSubTreeMax(Node start){
    if(start == null){
      throw new NullPointerException();
    }
    Node current = start;
    while(current.getRight() != null){
      current = current.getRight();
    }
    return current;
  }

  public String toPreorderString() {
    List<Integer> list = new ArrayList<>();
    Node left = root.getLeft();
    Node right = root.getRight();

    list.add(root.getValue());

    while (true) {
      if(left == null) break;
      list.addAll(subPreorder(left));
      left = left.getLeft();
    }

    while (true) {
      if(right == null) break;
      list.addAll(subPreorder(right));
      right = right.getLeft();
    }

    return list.stream()
        .map(String::valueOf)
        .collect(Collectors.joining("-"));
  }

  public List<Integer> subPreorder(Node node) {
    List<Integer> list = new ArrayList<>();
    list.add(node.getValue());
    if(node.getLeft() != null) {
      list.add(node.getLeft().getValue());
    }
    if(node.getRight() != null) {
      list.add(node.getRight().getValue());
    }
    return list;
  }

}
