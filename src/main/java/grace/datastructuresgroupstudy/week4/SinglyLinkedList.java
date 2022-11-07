package grace.datastructuresgroupstudy.week4;

import org.springframework.stereotype.Component;

// 한바향 링크드 리스트
@Component
public class SinglyLinkedList {

  private Node head;
  private int size;

  public void pushFront(int key) {
    Node newNode = new Node(key);
    newNode.changeNext(head);
    this.head = newNode;
    this.size++;
  }

  public void pushBack(int key) {
    Node newNode = new Node(key);
    if(this.size == 0) {
      head = newNode;
    }
    else {
      Node tail = this.head;
      while (tail.getNext() != null) {
        tail = tail.getNext();
      }
      tail.changeNext(newNode);
    }
    this.size++;
  }

  public void popFront() {
    if(this.size == 0) {
      throw new IllegalStateException("빈 리스트입니다.");
    }
    else {
      Node nowHead = this.head;
      if(nowHead.getNext() != null) {
        this.head = nowHead.getNext();
      }
      else {
        this.head = null;
      }
      this.size--;
    }

  }


  public void popBack() {
    if(this.size == 0) {
      throw new IllegalStateException("빈 리스트입니다.");
    }

    Node tail = this.head;
    Node beforeTail = null;

    while (tail.getNext() != null) {
      beforeTail = tail;
      tail = tail.getNext();
    }
    beforeTail.changeNext(null);
    this.size--;
  }

  public Node search(int key) {
    Node searchNode = this.head;
    while(searchNode.getNext() != null) {
      if(key == searchNode.getKey()) {
        return searchNode;
      }
      searchNode = searchNode.getNext();
    }
    if(key == searchNode.getKey()) return searchNode;
    return null;
  }


  public int size() {
    return this.size;
  }


}
