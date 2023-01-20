package grace.datastructuresgroupstudy.week13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

  // https://www.acmicpc.net/problem/1753
  // 백준 최단경로

  static class Node {
    int v; // 간선
    int cost; // 가중치

    public Node(int v, int cost) {
      this.v = v;
      this.cost = cost;
    }
  }

  // 노드 정보 리스트
  private static List<Node>[] graph;
  // 방문 유무 체크
  private static boolean[] visit;
  // 최단거리 목록
  private static int[] dist;

  public static void main(String[] args) throws Exception{

    // 정점 개수 : V / 간선 개수 : E
    // 시작 정점 번호 : K
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String veStr = br.readLine();
    String[] veStrArr = veStr.split(" ");
    int V = Integer.parseInt(veStrArr[0]);
    int E = Integer.parseInt(veStrArr[1]);
    int K = Integer.parseInt(br.readLine());

    graph = new ArrayList[V+1];
    visit = new boolean[V+1];
    dist = new int[V+1];

    for(int i=1; i<=V; i++) {
      graph[i] = new ArrayList<>();
      dist[i] = Integer.MAX_VALUE; // 최대값으로 초기화
    }


    for(int i=0; i<E; i++) {
      String str = br.readLine();
      String[] strArr = str.split(" ");
      // u, v: 간선 , w: 가중치
      int u = Integer.parseInt(strArr[0]);
      int v = Integer.parseInt(strArr[1]);
      int w = Integer.parseInt(strArr[2]);

      graph[u].add(new Node(v, w));
    }

    dijkstra(K);

    for (int i = 1; i <= V; i++) {
      System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
    }

  }

  private static void dijkstra(int start) {
    //우선 순위 큐 사용, 가중치를 기준으로 오름차순한다.
    PriorityQueue<Node> queue =
        new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

    //시작 노드에 대해서 초기화
    queue.add(new Node(start, 0));
    dist[start] = 0;

    while(!queue.isEmpty()) {
      // 최단 거리가 가장 짧은 노드를 꺼내서 방문처리한다
      Node nowNode = queue.poll();
      if(!visit[nowNode.v]) {
        visit[nowNode.v] =  true;
      }

      for(Node node : graph[nowNode.v]) {
        //방문하지 않았고, 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧을 경우
        if (!visit[node.v] && dist[node.v] > nowNode.cost + node.cost) {
          dist[node.v] = nowNode.cost + node.cost;
          queue.add(new Node(node.v, dist[node.v]));
        }
      }

    }
  }

}
