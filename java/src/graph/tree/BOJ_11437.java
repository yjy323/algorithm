package graph.tree;

import java.util.*;
import java.io.*;

public class BOJ_11437 {

  static ArrayList<Integer>[] tree;
  static int[] parents;
  static int[] depths;
  static boolean[] visited;
  static int n;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    n = Integer.parseInt(bf.readLine());
    tree = new ArrayList[n + 1];
    parents = new int[n + 1];
    depths = new int[n + 1];
    visited = new boolean[n + 1];
    for (int i = 1; i < n + 1; ++i) {
      tree[i] = new ArrayList<>();
    }
    for (int i = 0; i < n - 1; ++i) {
      st = new StringTokenizer(bf.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      tree[s].add(e);
      tree[e].add(s);
    }

    DFS(1, 0, 0);

    int m = Integer.parseInt(bf.readLine());
    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(bf.readLine());
      int n1 = Integer.parseInt(st.nextToken());
      int n2 = Integer.parseInt(st.nextToken());
      LCA(n1, n2);
    }
    bf.close();
  }

  private static void LCA(int n1, int n2) {
    while (n1 != n2) {
      while (depths[n1] != depths[n2]) {
        if (depths[n1] > depths[n2]) {
          n1 = parents[n1];
        } else {
          n2 = parents[n2];
        }
      }
      if (n1 != n2){
        n1 = parents[n1];
        n2 = parents[n2];
      }
    }
    System.out.println(n1);
  }

  private static void DFS(int node, int parent, int depth) {
    if (visited[node] == false) {
      visited[node] = true;

      parents[node] = parent;
      depths[node] = depth;
      for (int child : tree[node]) {
        DFS(child, node, depth + 1);
      }
    }
  }
}
