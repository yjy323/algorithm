package swea.d2;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_1974 {

  static BufferedReader br;
  static BufferedWriter bw;

  static int sudoku() throws IOException {
    int result = 1;

    boolean[][] sq = new boolean[3][10];
    boolean[] vt = new boolean[10];
    boolean[][] hr = new boolean[9][10];

    for (int i = 0; i < 9; i++) {

      StringTokenizer st = new StringTokenizer(br.readLine());
      if (i % 3 == 0) {
        sq = new boolean[3][10];
      }
      vt = new boolean[10];

      for (int j = 0; j < 9; j++) {
        int n = Integer.parseInt(st.nextToken());

        if (vt[n] == true) {
          result = 0;
        } else {
          vt[n] = true;
        }

        if (hr[j][n] == true) {
          result = 0;
        } else {
          hr[j][n] = true;
        }

        if (sq[j / 3][n] == true) {
          result = 0;
        } else {
          sq[j / 3][n] = true;
        }
      }
    }
    return result;
  }

  static public void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());

    for (int tc = 1; tc <= t; tc++) {
      bw.write("#" + tc + " " + sudoku() + "\n");
    }

    br.close();
    bw.flush();
    bw.close();
  }
}

