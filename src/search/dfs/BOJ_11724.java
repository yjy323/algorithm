package search.dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11724 {

  static boolean[] visited;
  static ArrayList<Integer>[] nodeList;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    visited = new boolean[n + 1];
    nodeList = new ArrayList[n + 1];
    for (int i = 1; i < n + 1; i++) {
      nodeList[i] = new ArrayList<Integer>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(bf.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      nodeList[s].add(e);
      nodeList[e].add(s);
    }

    int count = 0;
    for (int i = 1; i < n + 1; i++) {
      if (visited[i] == false) {
        count++;
        DFS(i);
      }
    }
    System.out.println(count);
  }

  private static void DFS(int v) {
    if (visited[v] == true) {
      return;
    } else {
      visited[v] = true;
      for (int e : nodeList[v]) {
        DFS(e);
      }
    }
  }
}
