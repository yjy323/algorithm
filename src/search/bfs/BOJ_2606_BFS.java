package search.bfs;

import java.util.*;
import java.io.*;

public class BOJ_2606_BFS {

  static ArrayList<Integer>[] graph;
  static boolean[] visited;
  static int depth = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(bf.readLine());
    int e = Integer.parseInt(bf.readLine());

    graph = new ArrayList[n + 1];
    visited = new boolean[n + 1];
    for (int i = 1; i < n + 1; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < e; i++) {
      st = new StringTokenizer(bf.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      graph[v1].add(v2);
      graph[v2].add(v1);
    }

    bfs();
    System.out.println(depth);
  }

  private static void bfs() {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);
    visited[1] = true;
    while (!queue.isEmpty()) {
      int v = queue.poll();
      Iterator<Integer> iter = graph[v].iterator();
      while (iter.hasNext()){
        int w = iter.next();
        if (visited[w] == false){
          depth++;
          visited[w] = true;
          queue.add(w);
        }
      }
    }
  }
}
