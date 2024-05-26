package graph.tree;

import java.util.*;
import java.io.*;

public class BOJ_11438 {

  static ArrayList<Integer>[] tree;
  static int[] parents;
  static int[] depths;
  static int[][] ancestors;
  static boolean[] visited;
  static int n, k;

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
    k = (int) Math.ceil(Math.log(Arrays.stream(depths).max().getAsInt() + 1) / Math.log(2));
    ancestors = new int[k][n + 1];
    fillAncestors();

    int m = Integer.parseInt(bf.readLine());
    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(bf.readLine());
      int n1 = Integer.parseInt(st.nextToken());
      int n2 = Integer.parseInt(st.nextToken());
      System.out.println(LCA(n1, n2));
    }
    bf.close();
  }

  private static int LCA(int n1, int n2) {
    if (depths[n1] > depths[n2]) {
      int temp = n1;
      n1 = n2;
      n2 = temp;
    }

    for (int i = k - 1; i >= 0; --i) {
      if (Math.pow(2, i) <= depths[n2] - depths[n1]) {
        n2 = ancestors[i][n2];
      }
    }

    for (int i = k - 1; i >= 0; --i) {
      if (ancestors[i][n1] != ancestors[i][n2]) {
        n1 = ancestors[i][n1];
        n2 = ancestors[i][n2];
      }
    }

    if (n1 != n2) {
      return ancestors[0][n1];
    } else {
      return n1;
    }
  }

  private static void fillAncestors() {
    ancestors[0] = parents;
    for (int i = 1; i < k; ++i) {
      for (int j = 2; j < n + 1; ++j) {
        ancestors[i][j] = ancestors[i - 1][ancestors[i - 1][j]];
      }
    }
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
