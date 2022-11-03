package grace.datastructuresgroupstudy.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class StackCalculator {

  // 계산
  public int calculate(String str) {
    List<String> postfix = getPostfix(str);
    String postfixStr = postfix.stream()
        .collect(Collectors.joining(""));
    System.out.println("postfix = " + postfixStr);
    Stack<Integer> calculateStack = new Stack<>();
    for (String item : postfix) {
      if (getOperators().contains(item))  { // 연산자일때
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
  private List<String> getPostfix(String str) {
    // postfix 결과값 저장
    List<String> postfix = new ArrayList<>();

    // 연산자 저장
    Stack<String> opstack = new Stack<>();

    String[] strArr = str.split(" ");
    for(String item : strArr) {
      if(getOperators().contains(item)) {
        // 연산자
        if(item.equals(")")) {
          // ")" 일때 - 첫번째 "(" 까지 stack 에서 빼기
          while(!opstack.isEmpty()) {
            if("(".equals(opstack.peek())) {
              opstack.pop();
              break;
            } else {
              postfix.add(opstack.pop());
            }
          }
        }
        else if(item.equals("(")) {
          opstack.push(item);
        }
        else {
          // 괄호가 아닐 때
          if(opstack.isEmpty()) {
            opstack.push(item);
          }
          else {
            while (!opstack.isEmpty()) {
              if(getOpPriority(item) < getOpPriority(opstack.peek())  && !"(".equals(opstack.peek())) {
                postfix.add(opstack.pop());
              } else {
                break;
              }
            }
            opstack.push(item);
          }
        }

      } else {
        // 숫자 (피연산자)
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
  private int getOpPriority(String operator){
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
  private Integer calculateByOperator(int num1, int num2, String operator) {
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

  private List<String> getOperators() {
    return List.of("+", "-", "*", "/", "(", ")");
  }

}
