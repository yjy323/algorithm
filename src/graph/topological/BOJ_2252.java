package graph.topological;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_2252 {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n + 1; i++) {
      graph.add(new ArrayList<>());
    }
    int[] indegree = new int[n + 1];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(bf.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      graph.get(s).add(e);
      indegree[e]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i < n + 1; i++) {
      if (indegree[i] == 0) {
        queue.offer(i);
      }
    }

    StringBuilder sb = new StringBuilder();
    while (!queue.isEmpty()) {
      int v = queue.poll();
      sb.append(v + " ");
      for (int w : graph.get(v)) {
        if (--indegree[w] == 0) {
          queue.offer(w);
        }
      }
    }
    System.out.println(sb);
  }
}
