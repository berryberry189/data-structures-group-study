package grace.datastructuresgroupstudy.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class gcd {
  // https://level.goorm.io/exam/50089/%EC%B5%9C%EB%8C%80%EA%B3%B5%EC%95%BD%EC%88%98-%EA%B5%AC%ED%95%98%EA%B8%B0/quiz/1

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // String input = br.readLine();
    String input = "8 12";

    String[] numArr =	input.split(" ");

    int a = Integer.parseInt(numArr[0]);
    int b = Integer.parseInt(numArr[1]);

    while(a != 0 && b != 0){
      if(a > b){
        a = a % b;
      } else {
        b = b % a;
      }
    }

    System.out.println("최대공약수 :  " + (a + b));
  }

}
