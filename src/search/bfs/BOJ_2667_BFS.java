package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2667_BFS {

  static int[] dx = new int[]{1, 0, -1, 0};
  static int[] dy = new int[]{0, 1, 0, -1};

  static int[][] map;
  static boolean[][] visited;
  static int n;
  static ArrayList<Integer> complexCnt;
  static int cnt = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(bf.readLine());
    map = new int[n][n];
    visited = new boolean[n][n];
    complexCnt = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(bf.readLine());
      char[] line = st.nextToken().toCharArray();
      for (int j = 0; j < n; j++) {
        map[i][j] = line[j] - '0';
      }
    }

    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        if (map[y][x] == 1 && visited[y][x] == false) {
          cnt = 1;
          visited[y][x] = true;
          bfs(y, x);
          complexCnt.add(cnt);
        }
      }
    }
    System.out.println(complexCnt.size());
    Collections.sort(complexCnt);
    for (int cnt : complexCnt) {
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
        if (nx >= 0 && ny >= 0 && nx < n && ny < n && map[ny][nx] == 1
            && visited[ny][nx] == false) {
          cnt++;
          visited[ny][nx] = true;
          queue.add(new int[]{ny, nx});
        }
      }
    }
  }
}
