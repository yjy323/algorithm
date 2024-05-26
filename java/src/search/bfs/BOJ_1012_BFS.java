package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012_BFS {

  static int[] dx = new int[]{1, 0, -1, 0};
  static int[] dy = new int[]{0, 1, 0, -1};
  static int[][] map;
  static boolean[][] visited;
  static int n, m;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int t = Integer.parseInt(bf.readLine());

    for (int i = 0; i < t; i++){
      st = new StringTokenizer(bf.readLine());
      m = Integer.parseInt(st.nextToken());
      n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      map = new int[n][m];
      visited = new boolean[n][m];
      for (int j = 0; j < k; j++){
        st = new StringTokenizer(bf.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        map[y][x] = 1;
      }

      int cnt = 0;
      for(int y = 0; y < n; y++){
        for(int x = 0; x < m; x++){
          if (map[y][x] == 1 && visited[y][x] == false) {
            visited[y][x] = true;
            bfs(y, x);
            cnt++;
          }
        }
      }
      System.out.println(cnt);
    }
  }

  private static void bfs(int y, int x) {
    Queue<int[]> queue = new LinkedList<>();
    int ny, nx;

    queue.add(new int[]{y, x});
    while (!queue.isEmpty()) {
      int[] w = queue.poll();
      for (int i = 0; i < 4; i++) {
        ny = w[0] + dy[i];
        nx = w[1] + dx[i];
        if (nx >= 0 && ny >= 0 && nx < m && ny < n && map[ny][nx] == 1
            && visited[ny][nx] == false) {
          visited[ny][nx] = true;
          queue.add(new int[]{ny, nx});
        }
      }
    }
  }
}
