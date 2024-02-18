package graph;

import java.util.*;
import java.io.*;

public class BOJ_18352 {
  static ArrayList<Integer>[] graph;
  static boolean[] visited;
  static ArrayList<Integer> cities = new ArrayList<>();
  public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());

    graph = new ArrayList[n + 1];
    visited = new boolean[n + 1];
    for (int i = 1; i < n + 1; i++) {
      graph[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(bf.readLine(), " ");
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      graph[s].add(e);
    }

    bfs(x, k);
    if (cities.isEmpty()){
      System.out.println(-1);
    } else{
      StringBuffer sb = new StringBuffer();
      Collections.sort(cities);
      for (int c : cities){
        sb.append(c + "\n");
      }
      System.out.println(sb);
    }
  }

  private static void bfs(int x, int k) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{x, 0});
    visited[x] = true;
    while (!queue.isEmpty()) {
      int[] node = queue.poll();
      int value = node[0];
      int depth = node[1];
      if (depth == k){
        cities.add(value);
      }
      for (int v : graph[value]) {
        if (visited[v] == false){
          queue.add(new int[]{v, depth + 1});
          visited[v] = true;
        }
      }
    }
  }
}
