package grace.datastructuresgroupstudy.day3;

public class ArrayStack implements Stack {

  private int top;
  private int stackSize;
  private char stackArr[];

  // 스택 생성자
  public ArrayStack(int stackSize) {
    this.top =-1;
    this.stackSize = stackSize;
    this.stackArr = new char[this.stackSize];
  }

  // 스택이 비었는지 확인
  @Override
  public boolean isEmpty() {
    return (top == -1);
  }

  @Override
  public boolean isFull() {
    return (top == this.stackSize - 1);
  }

  @Override
  public void push(char item) {
    if(isFull()) {
      System.out.println("스택이 꽉 찼습니다.");
    } else {
      stackArr[++top] = item;
    }
  }

  @Override
  public char pop() {
    if(isEmpty()) {
      System.out.println("스택이 비어 있습니다.");
      return 0;
    } else {
      return stackArr[top--];
    }
  }

  @Override
  public char peek() {
    if(isEmpty()) {
      System.out.println("스택이 비어 있습니다.");
      return 0;
    } else {
      return stackArr[top];
    }
  }

  @Override
  public void clear() {
    if(isEmpty()) {
      System.out.println("스택이 비어 있습니다.");
    } else {
      // 초기화
      this.top =-1;
      this.stackArr = new char[this.stackSize];
    }
  }
}
