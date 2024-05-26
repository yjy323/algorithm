package search;

import java.util.*;
import java.io.*;

public class BOJ_14502 {

  static int[] dx = new int[]{1, 0, -1, 0};
  static int[] dy = new int[]{0, 1, 0, -1};
  static int n, m;
  static int[][] map;
  static int maxSafeZone = Integer.MIN_VALUE;

  static class Node {

    int x;
    int y;

    public Node(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dfs(0);
    System.out.println(maxSafeZone);
  }

  private static void dfs(int wallCnt) {
    if (wallCnt == 3) {
      bfs();
      return;
    } else {
      for (int y = 0; y < n; y++) {
        for (int x = 0; x < m; x++) {
          if (map[y][x] == 0) {
            map[y][x] = 1;
            dfs(wallCnt + 1);
            map[y][x] = 0;
          }
        }
      }
    }
  }

  private static void bfs() {
    Queue<Node> queue = new LinkedList<>();

    for (int y = 0; y < n; y++) {
      for (int x = 0; x < m; x++) {
        if (map[y][x] == 2) {
          queue.add(new Node(y, x));
        }
      }
    }

    int[][] copyMap = map.clone();
    for (int i = 0; i < n; i++) {
      copyMap[i] = map[i].clone();
    }

    while (!queue.isEmpty()) {
      Node node = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = node.x + dx[i];
        int ny = node.y + dy[i];

        if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
          if (copyMap[ny][nx] == 0){
            queue.add(new Node(ny, nx));
            copyMap[ny][nx] = 2;
          }
        }
      }
    }
    countSafeZone(copyMap);
  }

  private static void countSafeZone(int[][] copyMap) {

    int cnt = 0;

    for (int y = 0; y < n; y++) {
      for (int x = 0; x < m; x++) {
        if (copyMap[y][x] == 0) {
          cnt++;
        }
      }
    }

    if (cnt > maxSafeZone) {
      maxSafeZone = cnt;
    }
  }
}
