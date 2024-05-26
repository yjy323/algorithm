package graph.topological;

import java.io.*;
import java.util.*;

public class BOJ_1005 {

  static int n, k;
  static ArrayList<Integer>[] graph;
  static int[] indegree;
  static int[] buildTime;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int t = Integer.parseInt(bf.readLine());
    for (int i = 0; i < t; i++) {
      st = new StringTokenizer(bf.readLine(), " ");
      n = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());

      graph = new ArrayList[n + 1];
      indegree = new int[n + 1];
      buildTime = new int[n + 1];
      st = new StringTokenizer(bf.readLine(), " ");
      for (int j = 1; j < n + 1; j++) {
        graph[j] = new ArrayList<>();
        buildTime[j] = Integer.parseInt(st.nextToken());
      }


      for (int j = 0; j < k; j++) {
        st = new StringTokenizer(bf.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        indegree[e]++;
        graph[s].add(e);
      }

      int w = Integer.parseInt(bf.readLine());
      topologicalSorting(w);
    }
  }

  private static void topologicalSorting(int w) {
    Queue<Integer> queue = new LinkedList<>();
    int[] cumulativeBuildTime = new int[n + 1];

    for (int i = 1; i < n + 1; i++) {
      cumulativeBuildTime[i] = buildTime[i];
      if (indegree[i] == 0) {
        queue.offer(i);
      }
    }

    while (!queue.isEmpty()) {
      int current = queue.poll();
      for (int next : graph[current]) {
        cumulativeBuildTime[next] = Math.max(cumulativeBuildTime[current] + buildTime[next],
            cumulativeBuildTime[next]);
        if(--indegree[next] == 0){
          queue.offer(next);
        }
      }
    }

    System.out.println(cumulativeBuildTime[w]);
  }
}
