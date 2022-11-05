package grace.datastructuresgroupstudy.week3;

public interface Stack {

  boolean isEmpty();
  boolean isFull();
  void push(char item);
  char pop();
  char peek();
  void clear();

}
