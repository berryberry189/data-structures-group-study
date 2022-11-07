package grace.datastructuresgroupstudy.week4;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SinglyLinkedListTest {


  @DisplayName("헤드 노드 앞에 새로운 노드 삽입")
  @Test
  void pushFront() {

    //given
    SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

    //when
    singlyLinkedList.pushFront(3);
    singlyLinkedList.pushFront(2);
    singlyLinkedList.pushFront(1);

    //then
    assertThat(singlyLinkedList.size()).isEqualTo(3);
    assertThat(singlyLinkedList.search(4)).isNull();

  }

  @DisplayName("테일 노드 뒤에 새로운 노드 삽입")
  @Test
  void pushBack() {

    //given
    SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

    //when
    singlyLinkedList.pushBack(1);
    singlyLinkedList.pushBack(2);
    singlyLinkedList.pushBack(3);
    singlyLinkedList.pushBack(4);

    //then
    assertThat(singlyLinkedList.size()).isEqualTo(4);
    System.out.println(singlyLinkedList.search(4).toString());
    assertThat(singlyLinkedList.search(4)).isNotNull();

  }

  @DisplayName("헤드 노드 삭제")
  @Test
  void popFront() {

    //given
    SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
    singlyLinkedList.pushFront(3);
    singlyLinkedList.pushFront(2);
    singlyLinkedList.pushFront(1);

    //when
    singlyLinkedList.popFront();

    //then
    assertThat(singlyLinkedList.size()).isEqualTo(2);
    assertThat(singlyLinkedList.search(1)).isNull();
    assertThat(singlyLinkedList.search(2)).isNotNull();

  }

  @DisplayName("테일 노드 삭제")
  @Test
  void popBack() {
    //given
    SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
    singlyLinkedList.pushFront(3);
    singlyLinkedList.pushFront(2);
    singlyLinkedList.pushFront(1);

    //when
    singlyLinkedList.popBack();

    //then
    assertThat(singlyLinkedList.size()).isEqualTo(2);
    assertThat(singlyLinkedList.search(3)).isNull();
    assertThat(singlyLinkedList.search(2)).isNotNull();

  }
}