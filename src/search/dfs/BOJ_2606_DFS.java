package search.dfs;

import java.util.*;
import java.io.*;

public class BOJ_2606_DFS {

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

    dfs(1);
    System.out.println(depth - 1);
  }

  private static void dfs(int v) {
    if (visited[v] == true) {
      return;
    } else{
      visited[v] = true;
      depth++;
      for (int e : graph[v]){
        dfs(e);
      }
    }
  }
}
