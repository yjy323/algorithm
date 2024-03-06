package graph.shortestpath;

import java.util.*;
import java.io.*;

public class BOJ_1504_PQ {

  static final int MAX_DISTANCE = 200000 * 1000;
  static ArrayList<Node>[] graph;
  static int[] dist;
  static boolean[] visited;
  static int n;

  static class Node implements Comparable<Node> {

    int v;
    int c;

    Node(int v, int c) {
      this.v = v;
      this.c = c;
    }

    @Override
    public int compareTo(Node o) {
      return Integer.compare(this.c, o.c);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    // 자료구조 & 입출력 Block
    n = Integer.parseInt(st.nextToken());
    int e = Integer.parseInt(st.nextToken());
    graph = new ArrayList[n + 1];
    dist = new int[n + 1];
    visited = new boolean[n + 1];
    for (int i = 1; i < n + 1; i++) {
      graph[i] = new ArrayList<>();
    }
    for (int i = 0; i < e; i++) {
      st = new StringTokenizer(bf.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      graph[a].add(new Node(b, c));
      graph[b].add(new Node(a, c));
    }

    st = new StringTokenizer(bf.readLine());
    int v1 = Integer.parseInt(st.nextToken());
    int v2 = Integer.parseInt(st.nextToken());

    int path1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, n);
    int path2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, n);
    if (path1 >= MAX_DISTANCE && path2 >= MAX_DISTANCE) {
      System.out.println(-1);
    } else {
      System.out.println(path1 > path2 ? path2 : path1);
    }
  }

  private static int dijkstra(int s, int e) {
    Arrays.fill(dist, MAX_DISTANCE);
    Arrays.fill(visited, false);
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(s, 0));
    dist[s] = 0;

    while (!pq.isEmpty()) {
      int now = pq.poll().v;
      if (visited[now]) {
        continue;
      }
      visited[now] = true;

      for (Node next : graph[now]) {
        if (dist[next.v] > dist[now] + next.c) {
          dist[next.v] = dist[now] + next.c;

          pq.offer(new Node(next.v, dist[next.v]));
        }
      }
    }
    System.out.println();
    return (dist[e]);
  }
}