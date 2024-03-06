package graph.shortestpath;

import java.util.*;
import java.io.*;

public class BOJ_1504 {

  static final int MAX_DISTANCE = 200000 * 1000;
  static ArrayList<int[]>[] graph;
  static int[] distance;
  static boolean[] visited;
  static int n;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    // 자료구조 & 입출력 Block
    n = Integer.parseInt(st.nextToken());
    int e = Integer.parseInt(st.nextToken());
    graph = new ArrayList[n + 1];
    distance = new int[n + 1];
    visited = new boolean[n + 1];
    for (int i = 1; i < n + 1; i++) {
      graph[i] = new ArrayList<>();
    }
    for (int i = 0; i < e; i++) {
      st = new StringTokenizer(bf.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      graph[a].add(new int[]{b, c});
      graph[b].add(new int[]{a, c});
    }

    st = new StringTokenizer(bf.readLine());
    int v1 = Integer.parseInt(st.nextToken());
    int v2 = Integer.parseInt(st.nextToken());

    /* 문제 조건 Block
    * 꼭 지나야 하는 두 정점 -> 한 정점을 지나고 다른 정점을 지나 최종 경로에 도달한다.
    * dijkstra는 DP 알고리즘이다.
    * dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, n) OR
    * dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, n)
    */
    int path1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, n);
    int path2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, n);
    if (path1 >= MAX_DISTANCE && path2 >= MAX_DISTANCE){
      System.out.println(-1);
    } else{
      System.out.println(path1 > path2 ? path2 : path1);
    }
  }

  // 알고리즘 Block
  private static int getMinDistanceIdx(){
    int min = MAX_DISTANCE;
    int minIdx = 0;
    for (int i = 0; i < n + 1; i++) {
      if (distance[i] < min && visited[i] == false){
        minIdx = i;
        min = distance[i];
      }
    }
    visited[minIdx] = true;
    return (minIdx);
  }
  private static int dijkstra(int s, int e) {
    Arrays.fill(distance, MAX_DISTANCE);
    Arrays.fill(visited, false);
    distance[s] = 0;
    visited[s] = true;

    int a = s;
    while (a != e && a != 0){
      for (int[] v : graph[a]){
        int b = v[0];
        int c = v[1];

        distance[b] = Math.min(distance[a] + c, distance[b]);
      }
      a = getMinDistanceIdx();
    }
    return distance[e];
  }
}
