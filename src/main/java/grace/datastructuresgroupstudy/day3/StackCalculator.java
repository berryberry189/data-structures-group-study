package grace.datastructuresgroupstudy.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackCalculator {

  static final List<String> operators = List.of("+", "-", "*", "/", "(", ")");

  public static void main(String[] args) {
    System.out.println("스택 계산기");
    // 10
    System.out.println(calculate("6 + ( 3 - 2 ) * 4"));
    // 8
    System.out.println(calculate("( 8 - 4 ) + ( 3 - 2 ) * 4"));
    // 14
    System.out.println(calculate("( 11 - 6 + 5 ) + ( 3 - 2 ) * 4"));

  }

  // postfix 계산
  public static int calculate(String str) {
    List<String> postfix = getPostfix(str);
    Stack<Integer> calculateStack = new Stack<>();
    for (String item : postfix) {
      if (operators.contains(item))  { // 연산자일때
        int num2 = calculateStack.pop();
        int num1 = calculateStack.pop();
        Integer reuslt = calculateByOperator(num1, num2, item);
        if(reuslt != null) {
          calculateStack.push(reuslt);
        }
      }
      else { // 피연산자일때
        calculateStack.push(Integer.parseInt(item));
      }
    }
    return calculateStack.pop();
  }


  // postfix 반환
  public static List<String> getPostfix(String str) {
    // postfix 결과값 저장
    List<String> postfix = new ArrayList<>();

    // 연산자 저장
    Stack<String> opstack = new Stack<>();

    String[] strArr = str.split(" ");
    for(String item : strArr) {
      if(operators.contains(item)) {
        // 연산자
        if(opstack.isEmpty()) {
          opstack.push(item);
        } else {
          if(item.equals(")")) {
            while(!opstack.isEmpty() && !opstack.peek().equals("(")) {
                postfix.add(opstack.pop());
            }
          } else {
            while (!opstack.isEmpty() &&
                (getOpPriority(item) >= getOpPriority(opstack.peek())) &&
                !"(".equals(opstack.peek())) {
                postfix.add(opstack.pop());
            }
            opstack.push(item);
          }
        }
      } else {
        // 숫자
        postfix.add(item);
      }
    }
    // 연산자 스택에 남아있던 나머지 연산자들
    while (opstack.size() != 0) {
      String pop = opstack.pop();
      if(!"(".equals(pop)) {
        postfix.add(pop);
      }
    }
    return postfix;
  }


  // 연산자 우선순위 반환
  public static int getOpPriority(String operator){
    switch (operator) {
      case "*":
      case "/":
        return 2;
      case "+":
      case "-":
        return 1;
      case "(":
        return 0;
      default:
        return -1;
    }
  }

  // 계산
  public static Integer calculateByOperator(int num1, int num2, String operator) {
    switch (operator) {
      case "*":
        return num1 * num2;
      case "/":
        return num1 / num2;
      case "+":
        return num1 + num2;
      case "-":
        return num1 - num2;
    }
    return null;
  }

}
