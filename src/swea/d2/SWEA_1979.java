package swea.d2;

import java.io.*;
import java.util.*;

public class SWEA_1979 {

  static public void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());

    for (int tc = 1; tc <= t ; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      int[][] map = new int[n][n];
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      int cnt = 0;
      for (int y = 0; y < n; y++) {
        int length = 0;
        for (int x = 0; x < n; x++) {
          if (map[y][x] == 1) {
            length += 1;
          } else {
            if (length == k) {
              cnt += 1;
            }
            length = 0;
          }
        }
        if (length == k) {
          cnt += 1;
        }
      }

      for (int x = 0; x < n; x++) {
        int length = 0;
        for (int y = 0; y < n; y++) {
          if (map[y][x] == 1) {
            length += 1;
          } else {
            if (length == k) {
              cnt += 1;
            }
            length = 0;
          }
        }
        if (length == k) {
          cnt += 1;
        }
      }

      bw.write("#" + tc + " " + cnt + "\n");
    }

    br.close();
    bw.flush();
    bw.close();
  }
}

