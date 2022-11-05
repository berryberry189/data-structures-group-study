package grace.datastructuresgroupstudy.week1;

import java.util.Arrays;

public class PrefixSum {
  // 누적 합, 구간 합
  // 누적합 또는 구간 합을 빠르게 구하는 알고리즘
  // 부분 합 : 0 ~ k까지의 합
  // 구간 합 : a ~ b까지의 합

  public static void main(String[] args) {

    int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] psum = new int[arr.length];

    int a = 3;
    int b = 5;

    for (int i = 1; i < 10; i++) {
      psum[i] = psum[i - 1] + arr[i];
    }

    Arrays.stream(psum).forEach(System.out::println);

    // 쿼리 a에서 b까지의 합 구하기
    int result = prefixSum(a, b, psum);
    System.out.println(result);
  }

  static int prefixSum(int l, int r, int[] psum) {
    return psum[r] - psum[l - 1];
  }

}
