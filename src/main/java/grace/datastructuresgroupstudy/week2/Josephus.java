package grace.datastructuresgroupstudy.week2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Josephus {

  public static void main(String[] args) {
    int n = 9;
    int k = 3;

    List<Integer> resultList = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<Integer>();

    for(int i=1; i<=n; i++) {
      queue.add(i);
    }

    int cnt = 0;
    while(!queue.isEmpty()) {
      cnt++;
      int temp = queue.poll();
      if(cnt % k == 0) resultList.add(temp);
      else queue.add(temp);
    }

    System.out.println(resultList.toString());

  }

}
