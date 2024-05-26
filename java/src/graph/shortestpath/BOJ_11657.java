package graph.shortestpath;

import java.util.*;
import java.io.*;

public class BOJ_11657 {

  static Edge edgeList[];
  static long dist[];
  static int N;
  static int M;
  static StringBuffer sb = new StringBuffer();

  static class Edge {

    int src;
    int dst;
    int weight;

    Edge(int src, int dst, int weight) {
      this.src = src;
      this.dst = dst;
      this.weight = weight;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    edgeList = new Edge[M];
    dist = new long[N + 1];
    int a, b, c;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(bf.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      edgeList[i] = new Edge(a, b, c);
    }

    bellmanFord();

    if (sb.length() == 0) {
      for (int i = 2; i < N + 1; i++) {
        if (dist[i] == Integer.MAX_VALUE) {
          sb.append("-1\n");
        } else {
          sb.append(dist[i] + "\n");
        }
      }
    }

    System.out.print(sb);
  }

  private static void bellmanFord() {
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[1] = 0;

    for (int i = 1; i < N; ++i) {
      for (int j = 0; j < M; ++j) {
        int src = edgeList[j].src;
        int dst = edgeList[j].dst;
        int weight = edgeList[j].weight;

        if (dist[src] != Integer.MAX_VALUE
            && dist[dst] > dist[src] + weight) {
          dist[dst] = dist[src] + weight;
        }
      }
    }

    for (int j = 0; j < M; ++j) {
      int src = edgeList[j].src;
      int dst = edgeList[j].dst;
      int weight = edgeList[j].weight;

      if (dist[src] != Integer.MAX_VALUE
          && dist[dst] > dist[src] + weight) {
        sb = new StringBuffer("-1\n");
        return;
      }
    }
  }
}
