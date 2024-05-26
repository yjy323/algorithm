package search.bfs;

import java.io.*;
import java.util.*;

public class BOJ_2178 {

  static int[] dx = new int[]{0, 1, 0, -1};
  static int[] dy = new int[]{1, 0, -1, 0};
  static boolean[][] visited;
  static int[][] map;
  static int n, m;

  public static void main(String[] args) throws IOException {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    visited = new boolean[n][m];
    map = new int[n][m];
    for (int i = 0; i < n; i++) {
      char[] line = bf.readLine().toCharArray();
      for (int j = 0; j < m; j++) {
        map[i][j] = line[j] - '0';
      }
    }
    BFS(0, 0);
    System.out.println(map[n - 1][m - 1]);
  }

  private static void BFS(int i, int j) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{i, j});
    visited[i][j] = true;
    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      for (int d = 0; d < 4; d++) {
        int x = now[0] + dx[d];
        int y = now[1] + dy[d];
        if (x >= 0 && y >= 0 && x < n && y < m && map[x][y] == 1 && visited[x][y] == false) {
          visited[x][y] = true;
          map[x][y] = map[now[0]][now[1]] + 1;
          queue.add(new int[]{x, y});
        }
      }
    }
  }
}
