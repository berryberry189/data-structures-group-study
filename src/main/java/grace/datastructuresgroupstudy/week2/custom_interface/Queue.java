package grace.datastructuresgroupstudy.week2.custom_interface;

// 큐 구현 인터페이스
public interface Queue <E>{

  // e: 뮤에 추가할 요소
  // 큐에 요소가 정상적으로 추가되었을 경우 true 반환
  boolean offer(E e);

  E poll();

  E peek();

}
