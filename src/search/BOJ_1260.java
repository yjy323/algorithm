package search;

import java.util.*;
import java.io.*;

public class BOJ_1260 {

  static boolean[] visitedDfs;
  static boolean[] visitedBfs;
  static ArrayList<Integer>[] graph;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int v = Integer.parseInt(st.nextToken());

    visitedDfs = new boolean[n + 1];
    visitedBfs = new boolean[n + 1];
    graph = new ArrayList[n + 1];
    for (int i = 1; i < n + 1; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(bf.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());

      graph[v1].add(v2);
      graph[v2].add(v1);
    }
    for (int i = 1; i < n + 1; i++) {
      Collections.sort(graph[i]);
    }

    dfs(v);
    System.out.println();
    bfs(v);
  }

  private static void dfs(int v) {
    if (visitedDfs[v] == true) {
      return;
    } else {
      visitedDfs[v] = true;
      System.out.print(v + " ");
      for (int e : graph[v]) {
        dfs(e);
      }
    }
  }

  private static void bfs(int v) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(v);
    visitedBfs[v] = true;
    while (!queue.isEmpty()) {
      int w = queue.poll();
      System.out.print(w + " ");
      Iterator<Integer> iter = graph[w].iterator();
      while (iter.hasNext()) {
        int nextV = iter.next();
        if (visitedBfs[nextV] == false) {
          visitedBfs[nextV] = true;
          queue.add(nextV);
        }
      }
    }
  }

}
