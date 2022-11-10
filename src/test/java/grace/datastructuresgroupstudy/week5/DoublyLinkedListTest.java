package grace.datastructuresgroupstudy.week5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DoublyLinkedListTest {

  @DisplayName("헤드 노드 앞에 새로운 노드 삽입")
  @Test
  void pushFront() {
    //given
    DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
    Node aNode = new Node("a");
    Node bNode = new Node("b");
    Node cNode = new Node("c");

    //when
    doublyLinkedList.pushFront(cNode);
    doublyLinkedList.pushFront(bNode);
    doublyLinkedList.pushFront(aNode);

    //then
    assertThat(arrayToStr(doublyLinkedList.toArray())).isEqualTo("a-b-c");
  }

  @DisplayName("splice 연산")
  @Test
  void splice() {
    //given
    DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
    Node apNode = new Node("ap");
    Node aNode = new Node("a");
    Node anNode = new Node("an");
    Node bpNode = new Node("bp");
    Node bNode = new Node("b");
    Node bnNode = new Node("bn");
    Node xpNode = new Node("xp");
    Node xNode = new Node("x");
    Node xnNode = new Node("xn");


    doublyLinkedList.pushFront(xnNode);
    doublyLinkedList.pushFront(xNode);
    doublyLinkedList.pushFront(xpNode);
    doublyLinkedList.pushFront(bnNode);
    doublyLinkedList.pushFront(bNode);
    doublyLinkedList.pushFront(bpNode);
    doublyLinkedList.pushFront(anNode);
    doublyLinkedList.pushFront(aNode);
    doublyLinkedList.pushFront(apNode);


    //when
    doublyLinkedList.splice(aNode, bNode, xNode);


    //then
    assertThat(arrayToStr(doublyLinkedList.toArray())).isEqualTo("ap-bn-xp-x-a-an-bp-b-xn");

  }

  private String arrayToStr(String[] keyList) {
    return Arrays.stream(keyList)
        .collect(Collectors.joining("-"));
  }

}