package search.bfs;

import java.util.*;

public class PG_43162 {

  static boolean[] visited;
  static ArrayList<Integer>[] graph;
  static int network = 0;

  public int solution(int n, int[][] computers) {
    visited = new boolean[n];
    Arrays.fill(visited, false);
    graph = new ArrayList[n];

    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        if (i != j && computers[i][j] == 1) {
          graph[i].add(j);
        }
      }
    }

    for (int i = 0; i < n; i++) {
      BFS(i);
    }
    return network;
  }

  static private void BFS(int s) {
    if (visited[s] == true) {
      return;
    }
    visited[s] = true;
    network++;

    Queue<ArrayList<Integer>> queue = new LinkedList<>();
    queue.add(graph[s]);
    while (!queue.isEmpty()) {
      ArrayList<Integer> v = queue.poll();
      for (int w : v) {
        if (visited[w] == false) {
          visited[w] = true;
          queue.add(graph[w]);
        }
      }
    }
  }
}
