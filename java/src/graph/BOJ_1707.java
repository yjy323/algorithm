package graph;

import java.util.*;
import java.io.*;

public class BOJ_1707 {

  static ArrayList<Integer>[] graph; // 양방향 가중치 없는 인접 리스트
  static boolean[] visited;
  static boolean[] group;
  static boolean isBinaryGraph;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
    int k = Integer.parseInt(st.nextToken());
    for (int i = 0; i < k; i++) {

      st = new StringTokenizer(bf.readLine(), " ");
      int v = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      graph = new ArrayList[v + 1];
      visited = new boolean[v + 1];
      group = new boolean[v + 1];
      for (int j = 1; j < v + 1; j++) {
        graph[j] = new ArrayList<>();
      }

      for (int j = 0; j < e; j++) {
        st = new StringTokenizer(bf.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        graph[start].add(end);
        graph[end].add(start);
      }

      isBinaryGraph = true;
      for (int j = 1; j < v + 1; j++) {
        if (isBinaryGraph == true) {
          dfs(j);
        } else {
          break;
        }
      }
      if (isBinaryGraph){
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }

  private static void dfs(int v) {
    visited[v] = true;
    for (int w : graph[v]) {
      if (visited[w] == false) {
        group[w] = !group[v];
        dfs(w);
      } else if (group[w] == group[v]) {
        isBinaryGraph = false;
      }
    }
  }
}
