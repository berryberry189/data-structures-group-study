package grace.datastructuresgroupstudy.day2;

import grace.datastructuresgroupstudy.day2.custom_interface.Queue;

// 배열을 사용한 큐 구현
public class ArrayQueue<E> implements Queue<E> {

  // front : 앞
  // rear : 뒤
  // front == rear : 큐가 비어있다

  private static final int DEFAULT_CAPACITY = 64; // 최소(기본) 용적 크기
  private Object[] array; // 요소를 담을 배열
  private int size; // 요소 개수
  private int front; // 시작 인덱스를 가리키는 변수(빈 공간임을 유의)
  private int rear; // 마지막 요소의 인덱스를 가리키는 변수

  // 생성자1 (초기 용적 할당을 안할 경우)
  public ArrayQueue() {
    this.array = new Object[DEFAULT_CAPACITY];
    this.size = 0;
    this.front = 0;
    this.rear = 0;
  }

  // 생성자2 (초기 용적 할당을 할 경우)
  public ArrayQueue(int capacity) {
    this.array = new Object[capacity];
    this.size = 0;
    this.front = 0;
    this.rear = 0;
  }

  private void resize(int newCapacity) {
    int arrayCapacity = array.length; // 현재 용적의 크기

    Object[] newArray = new Object[newCapacity]; // 용적을 변경할 배열

    /*
     * i = new array index
     * j = original array
     * index 요소 개수(size)만큼 새 배열에 값복
     */

    for(int i=0, j = front + 1; i<=size; i++, j++) {
      newArray[i] = array[j % arrayCapacity];
    }

    this.array = null;
    this.array = newArray;

    front = 0;
    rear = size;
  }

  public boolean offer(E e){
    // 용적이 가득 찼을 경우
    if( (rear + 1) % array.length == front ) {
      resize(array.length * 2); // queue의 사이즈를 2배로 늘려준다.
    }

    rear = (rear + 1) % array.length; // rear를 rear의 다음 위치로 갱신

    array[rear] = e;
    size ++;

    return true;
  }

  @Override
  public E poll() {
    // 삭제할 원소가 없을 경우 null을 반환
    if(size == 0) {
      return null;
    }

    front = (front + 1) % array.length; // front를 한 칸 옮긴다.

    // @SuppressWarnings를 붙이지 않으면 type safe(타입 안정성)에 대한 경고를 보낸다.
    // 반환되는 것을 보면 E타입으로 캐스팅하고 있고 그 대상이 되는 것은 Object[]배열의 Object데이터이다.
    // 즉, Object -> E로 타입을 변환하는 것
    @SuppressWarnings("unchecked")
    E item = (E) array[front];

    array[front] = null;
    size--;

    // 용적이 최소 크기(64)보다 크고, 요소 개수가 1/4 미만일 경우
    if(array.length > DEFAULT_CAPACITY && size < (array.length / 4)) {
      // 아무리 작아도 최소용적 미만으로 작아지지는 않도록 한다.
      resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
    }

    return item;
  }

  @Override
  // poll()과 마찬가지로 Queue에서 꺼내 E타입의 원소를 반환해야하기 때문에
  // @SuppressWarnings("unchecked")를 붙여준다.
  public E peek() {
    if(size == 0) {
      return null;
    }

    @SuppressWarnings("unchecked")
    E item = (E) array[(front) + 1 % array.length];
    return item;
  }


  public static void main(String[] args) {
    ArrayQueue<Integer> que = new ArrayQueue<>();

    que.offer(1);
    que.offer(2);
    que.offer(3);
    //System.out.println(que.poll());

    System.out.println(que.poll());
    System.out.println(que.poll());
    System.out.println(que.poll());
  }



}
