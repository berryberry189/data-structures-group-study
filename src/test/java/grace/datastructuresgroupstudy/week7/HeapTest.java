package grace.datastructuresgroupstudy.week7;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HeapTest {

  @DisplayName("heap 삽입 연산")
  @Test
  void insert() {

    // given
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(15,12,6,11,10,2,3,1,8));
    Heap heap = new Heap(list);

    // when
    heap.insert(14);

    // then
    assertThat(arrayToStr(heap.getHeap())).isEqualTo("15, 14, 6, 11, 12, 2, 3, 1, 8, 10");

  }

  @DisplayName("max 값 식제 연산")
  @Test
  void maxDelete() {
    // given
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(15,12,6,11,10,2,3,1,8));
    Heap heap = new Heap(list);

    // when
    heap.maxDelete();

    // then
    assertThat(arrayToStr(heap.getHeap())).isEqualTo("12, 11, 6, 8, 10, 2, 3, 1");

  }

  private String arrayToStr(ArrayList<Integer> list) {
    return list.stream()
        .map(String::valueOf)
        .collect(Collectors.joining(", "));
  }

}