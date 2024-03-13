package graph.shortestpath;

import java.util.*;
import java.io.*;

public class BOJ_11403 {

  static int adjacentMatrix[][];
  static int V;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    V = Integer.parseInt(bf.readLine());

    adjacentMatrix = new int[V][V];
    for (int i = 0; i < V; i++) {
      st = new StringTokenizer(bf.readLine(), " ");
      for (int j = 0; j < V; j++) {
        adjacentMatrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    floydWarshall();

    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < V; i++) {
      for (int j = 0; j < V; j++) {
        sb.append(adjacentMatrix[i][j] + " ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }

  private static void floydWarshall() {
    for (int k = 0; k < V; k++) {
      for (int s = 0; s < V; s++) {
        for (int e = 0; e < V; e++) {

          if (adjacentMatrix[s][k] == 1 && adjacentMatrix[k][e] == 1) {
            adjacentMatrix[s][e] = 1;
          }
        }
      }
    }
  }
}
