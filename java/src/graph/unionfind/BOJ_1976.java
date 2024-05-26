package graph.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976 {

  static int[] parent;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine());
    int m = Integer.parseInt(bf.readLine());
    parent = new int[n + 1];
    for (int i = 1; i < n + 1; i++) {
      parent[i] = i;
    }


    StringTokenizer st;
    for (int i = 0; i < n; i++){
      st = new StringTokenizer(bf.readLine(), " ");
      for (int j = 0; j < n; j++){
        if(Integer.parseInt(st.nextToken()) == 1){
          union(i + 1, j + 1);
        }
      }
    }

    st = new StringTokenizer(bf.readLine(), " ");
    int start = find(Integer.parseInt(st.nextToken()));
    boolean isLinked = true;
    for (int i = 1; i < m; i++){
      if (start != find(Integer.parseInt(st.nextToken()))){
        isLinked = false;
        break;
      }
    }
    if (isLinked == true){
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
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
