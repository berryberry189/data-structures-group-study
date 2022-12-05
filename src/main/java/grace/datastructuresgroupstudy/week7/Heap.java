package grace.datastructuresgroupstudy.week7;

import java.util.ArrayList;

public class Heap {

  private ArrayList<Integer> heap;

  public Heap() {
    heap = new ArrayList<Integer>();
  }

  // 테스트용
  public Heap(ArrayList<Integer> heapList) {
    heap = heapList;
  }

  public ArrayList<Integer> getHeap() {
    return heap;
  }

  public void insert(int val) {
    //맨 마지막 위치에 삽입
    heap.add(val);

    int k = heap.size()-1; //새로 넣은 노드의 인덱스 위치 정보

    //루트까지 이동 자식이 더 크면 교환
    while(k>0 && heap.get(k)> heap.get((k-1)/2)) {
      int temp = heap.get((k-1)/2);
      heap.set((k-1)/2, heap.get(k));
      heap.set(k, temp);
      k = (k-1)/2;
    }
  }

  public int maxDelete() {
    //힙 이 비어있으면 0리턴
    if(heap.size()-1 < 1) {
      return 0;
    }

    //삭제할 루트 노드 값 저장
    int deleteItem = heap.get(0);

    //맨 마지막 자식 루트에 넣고 마지막 값 삭제
    heap.set(0, heap.get(heap.size()-1));
    heap.remove(heap.size()-1);

    //루트에 새로 넣은 노드의 인덱스 정보
    int pos = 0;
    while((pos*2)<heap.size()) {

      int max = heap.get(pos*2);
      int maxPos = pos*2;

      //오른쪽 자식이 존재하고 오른쪽 자식이 왼쪽 자식보다 클때 바꿀 자식 오른쪽으로 설정
      if((pos*2 +1)<heap.size() && max < heap.get(pos*2+1)) {
        max = heap.get(pos*2+1);
        maxPos = pos*2+1;
      }

      //부모가 더 크면 끝
      if(heap.get(pos) > max){
        break;
      }

      //자식이 더 크면 교환
      int tmp = heap.get(pos);
      heap.set(pos, max);
      heap.set(maxPos, tmp);
      pos = maxPos;
    }
    return deleteItem;
  }

}
