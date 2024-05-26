package graph.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11404 {

  static final int MAX_WEIGHT = 100000 * 100;
  static int adjacentMatrix[][];
  static int n, m;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    n = Integer.parseInt(bf.readLine());
    m = Integer.parseInt(bf.readLine());

    adjacentMatrix = new int[n + 1][n + 1];
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (i != j) {
          adjacentMatrix[i][j] = MAX_WEIGHT;
        }
      }
    }

    int a, b, c;
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(bf.readLine(), " ");
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());

      adjacentMatrix[a][b] = Math.min(adjacentMatrix[a][b], c);
    }

    floydWarshall();

    StringBuffer sb = new StringBuffer();
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (adjacentMatrix[i][j] == MAX_WEIGHT) {
          adjacentMatrix[i][j] = 0;
        }
        sb.append(adjacentMatrix[i][j] + " ");
      }
      sb.append("\n");
    }

    System.out.print(sb);
    bf.close();
  }

  private static void floydWarshall() {

    for (int k = 1; k < n + 1; k++) {
      for (int s = 1; s < n + 1; s++) {
        for (int e = 1; e < n + 1; e++) {

          adjacentMatrix[s][e] = Math.min(adjacentMatrix[s][e],
              adjacentMatrix[s][k] + adjacentMatrix[k][e]);
        }
      }
    }
  }
}
