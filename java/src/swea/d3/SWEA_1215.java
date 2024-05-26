package swea.d3;

import java.io.*;
import java.util.*;

public class SWEA_1215 {

  static public void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int tc = 1; tc <= 10 ; tc++) {
      int cnt = 0;

      int k = Integer.parseInt(br.readLine());
      char[][] board = new char[8][8];
      for (int i = 0; i < 8; i++) {
        board[i] = br.readLine().toCharArray();
      }

      for (int y = 0; y < 8; y++) {
        StringBuffer sb = new StringBuffer();
        for (int x = 0; x < k - 1; x++) {
          sb.append(board[y][x]);
        }
        for (int x = k - 1; x < 8; x++) {
          sb.append(board[y][x]);
          StringBuffer palindrome = new StringBuffer(sb);
          if (sb.toString().equals(palindrome.reverse().toString())) {
            cnt += 1;
          }
          sb = new StringBuffer(sb.substring(1));
        }
      }

      if (k > 1) {
        for (int x = 0; x < 8; x++) {
          StringBuffer sb = new StringBuffer();
          for (int y = 0; y < k - 1; y++) {
            sb.append(board[y][x]);
          }
          for (int y = k - 1; y < 8; y++) {
            sb.append(board[y][x]);
            StringBuffer palindrome = new StringBuffer(sb);
            if (sb.toString().equals(palindrome.reverse().toString())) {
              cnt += 1;
            }
            sb = new StringBuffer(sb.substring(1));
          }
        }
      }

      bw.write("#" + tc + " " + cnt + "\n");
    }

    br.close();
    bw.flush();
    bw.close();
  }
}

