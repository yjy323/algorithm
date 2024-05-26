package swea.d4;

import java.io.*;
import java.util.*;

public class SWEA_1249 {

  static class Node implements Comparable<Node>{
    int y;
    int x;
    int dist;

    Node(int y, int x, int dist){
      this.y = y;
      this.x = x;
      this.dist = dist;
    }

    public int compareTo(Node o) {
      return this.dist - o.dist;
    }

  }

  static public void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());

    int[] dx = new int[] {1, 0, -1, 0};
    int[] dy = new int[] {0, 1, 0, -1};

    for (int tc = 1; tc <= t ; tc++) {
      PriorityQueue<Node> pq = new PriorityQueue<Node>();
      int n = Integer.parseInt(br.readLine());
      int[][] map = new int[n][n];
      int[][] dist = new int[n][n];

      for (int i = 0; i < n; i++) {
        String[] st = br.readLine().split("");
        for (int j = 0; j < n; j++) {
          map[i][j] = Integer.parseInt(st[j]);
        }
        Arrays.fill(dist[i], Integer.MAX_VALUE);

      }
      dist[0][0] = 0;
      pq.add(new Node(0, 0, 0));
      while(!pq.isEmpty()) {
        Node v = pq.poll();
        int y = v.y;
        int x = v.x;
        if (y == n - 1 && x == n - 1) {
          break;
        }

        for (int i = 0; i < 4; i++) {
          int ny = y + dy[i];
          int nx = x + dx[i];
          if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
            continue;
          }
          if (dist[ny][nx] > v.dist + map[ny][nx]) {
            dist[ny][nx] = v.dist + map[ny][nx];
            pq.add(new Node(ny, nx, dist[ny][nx]));
          }
        }
      }
      bw.write("#" + tc + " " + dist[n - 1][n - 1]+ "\n");
    }

    br.close();
    bw.flush();
    bw.close();
  }
}
