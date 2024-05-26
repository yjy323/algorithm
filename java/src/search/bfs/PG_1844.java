package search.bfs;

import java.util.*;

public class PG_1844 {

  static int[] dx = new int[]{1, 0, -1, 0};
  static int[] dy = new int[]{0, 1, 0, -1};
  static boolean[][] visited;

  public int solution(int[][] maps) {
    int n = maps.length;
    int m = maps[0].length;

    visited = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      Arrays.fill(visited[i], false);
    }

    return BFS(maps, n, m);
  }

  static private int BFS(int[][] maps, int n, int m) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0, 0, 0});
    visited[0][0] = true;

    while (!queue.isEmpty()) {
      int[] v = queue.poll();
      for (int i = 0; i < 4; i++) {
        int x = v[0] + dx[i];
        int y = v[1] + dy[i];
        int depth = v[2] + 1;
        if (y == n - 1 && x == m - 1) {
          return depth + 1;
        } else if ((y >= 0 && x >= 0 && y < n && x < m)
            && maps[y][x] == 1
            && visited[y][x] == false) {
          visited[y][x] = true;
          queue.add(new int[]{x, y, depth});
        }
      }
    }
    return -1;
  }
}
