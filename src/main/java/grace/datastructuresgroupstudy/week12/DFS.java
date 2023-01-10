package grace.datastructuresgroupstudy.week12;

import java.util.ArrayList;
import java.util.List;

public class DFS {

  static List<Integer>[] nodeList;
  static int[] visited;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    // 입력 데이터
    int N = 5;

    int[][] nodes = {{0,1},{0,2},{1,3},{1,4}};

    // 리스트, 배열 초기화
    nodeList = new ArrayList[N];
    for(int i=0; i<N; i++) nodeList[i] = new ArrayList<>();
    visited = new int[N];

    // 입력받은 간선을 간선 리스트(인접 리스트)에 저장
    // ex) 1-2 : nodeList[1].add(2); nodeList[2].add(1);
    // 무방향성이므로 양쪽을 저장
    for(int[] e : nodes){
      nodeList[e[0]].add(e[1]);
      nodeList[e[1]].add(e[0]);
    }

    visited[0] = 1; // 0부터 출발, 0은 방문 처리
    dfs(0);
    System.out.println(sb.toString());
  }

  static void dfs(int v) {
    sb.append(v).append(" ");
    for(int next : nodeList[v]) {
      if(visited[next] == 0) { // 이어진 점이 방문한 곳이 아니면
        visited[next] = 1; // 방문 처리하고
        dfs(next); // 해당 점부터 재귀
      }
    }
  }

}
