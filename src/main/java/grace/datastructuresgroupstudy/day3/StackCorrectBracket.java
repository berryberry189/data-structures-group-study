package grace.datastructuresgroupstudy.day3;

import java.util.Stack;

// 괄호 맞추기
public class StackCorrectBracket {

  public static void main(String[] args) {
    System.out.println(solution("(2 + 5) * 7 - ((3 - 1) / 2 + 7)"));
    System.out.println(solution("(()())"));
    System.out.println(solution("(()))("));
  }

  public static boolean solution(String str) {
    boolean answer = true;
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < str.length(); i++) {
      char temp = str.charAt(i);

      if(temp == '(') {
        stack.push(temp);
      } else if(temp == ')' && stack.size() > 0) {
        stack.pop();
      } else if(temp == ')' && stack.size() == 0) {
        return false;
      }
    }

    if(stack.size() > 0) answer = false;

    return answer;
  }

}
