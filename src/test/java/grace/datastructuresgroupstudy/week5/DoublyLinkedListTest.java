package grace.datastructuresgroupstudy.week5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DoublyLinkedListTest {

  @Test
  void pushFront() {
    //given
    DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

    //when
    doublyLinkedList.pushFront(3);
    doublyLinkedList.pushFront(2);
    doublyLinkedList.pushFront(1);

    //then
    assertThat(arrayToStr(doublyLinkedList.toArray())).isEqualTo("1-2-3");
  }

  private String arrayToStr(Integer[] keyList) {
    return Arrays.stream(keyList)
        .map(String::valueOf)
        .collect(Collectors.joining("-"));
  }

}