package graph.unionfind;

import java.io.*;
import java.util.*;

public class BOJ_1717 {

  static int[] parent;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    parent = new int[n + 1];
    for (int i = 1; i < n + 1; i++) {
      parent[i] = i;
    }

    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(bf.readLine());
      int q = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if (q == 0) {
        union(a, b);
      } else {
        if (find(a) == find(b)) {
          sb.append("YES\n");
        } else {
          sb.append("NO\n");
        }
      }
    }
    System.out.println(sb);
  }

  private static void union(int a, int b) {
    a = find(a);
    b = find(b);

    if (a == b) {
      return;
    } else if (a < b) {
      parent[b] = a;
    } else {
      parent[a] = b;
    }
  }


  private static int find(int n) {
    if (n == parent[n]) {
      return n;
    } else {
      return parent[n] = find(parent[n]);
    }
  }
}
