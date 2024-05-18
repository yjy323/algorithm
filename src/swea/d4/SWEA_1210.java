package swea.d4;

import java.io.*;
import java.util.*;

public class SWEA_1210 {

  static int[][] ladder;
  static boolean[][] visited;
  static int[] dx = new int[] {1, -1, 0};
  static int[] dy = new int[] {0, 0, -1};

  static public void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int tc = 1; tc <= 10 ; tc++) {
      br.readLine();

      int x = 0;

      ladder = new int[100][100];
      visited = new boolean[100][100];
      for (int i = 0; i < 100; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < 100; j++) {
          ladder[i][j] = Integer.parseInt(st.nextToken());
          if (ladder[i][j] == 2) {
            x = j;
          }
        }
      }
      bw.write("#" + tc + " " + dfs(x, 99) + "\n");
    }

    br.close();
    bw.flush();
    bw.close();
  }

  static public int dfs(int x, int y) {
    int ret = -1;
    if (y == 0) {
      return x;
    }

    for (int i = 0; i < 3; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx < 0 || nx >= 100 || ny < 0 || ny >= 100
          || ladder[ny][nx] == 0 || visited[ny][nx] == true) {
        continue;
      }

      visited[ny][nx] = true;
      ret = dfs(nx, ny);
      if (ret != -1) {
        return ret;
      }
    }
    return ret;
  }
}
