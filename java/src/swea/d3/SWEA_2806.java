package swea.d3;

import java.io.*;

public class SWEA_2806 {

  static int n;
  static int[] board;
  static int cnt;

  static public void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());

    for (int tc = 1; tc <= t; tc++) {
      n = Integer.parseInt(br.readLine());
      board = new int[n + 1];
      cnt = 0;
      n_queen(1, 0);

      bw.write("#" + tc + " " + cnt + "\n");
    }

    br.close();
    bw.flush();
    bw.close();
  }

  static public void n_queen(int s, int depth) {
    if (depth == n) {
      cnt += 1;
      return;
    }

    for (int i = 1; i <= n; i++) {
      boolean check = true;
      for (int j = 1; j < s; j++) {
        if (board[j] == i
            || Math.abs(s - j) == Math.abs(i - board[j])) {
          check = false;
          break;
        }
      }
      if (check == true) {
        board[s] = i;
        n_queen(s + 1, depth + 1);
        board[s] = 0;
      }
    }
  }
}