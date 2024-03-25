package simulation;

import java.util.*;
import java.io.*;

public class BOJ_6987 {

  static int[][] matches = {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}, {1, 2}, {1, 3}, {1, 4}, {1, 5},
      {2, 3}, {2, 4}, {2, 5}, {3, 4}, {3, 5}, {4, 5}};
  static int[][] results = new int[6][3];

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < 4; ++i) {
      st = new StringTokenizer(bf.readLine());
      int j = 0;
      for (j = 0; j < 6; ++j) {
        results[j][0] = Integer.parseInt(st.nextToken());
        results[j][1] = Integer.parseInt(st.nextToken());
        results[j][2] = Integer.parseInt(st.nextToken());

        if (results[j][0] + results[j][1] + results[j][2] != 5){
          break;
        }
      }
      if (j == 6 && dfs(0, 0) == 15) {
        sb.append("1 ");
      } else {
        sb.append("0 ");
      }
    }
    System.out.println(sb);
  }

  private static int dfs(int matchNum, int cnt) {
    if (cnt == 15) {
      return cnt;
    }
    for (int i = 0; i < 3; ++i) {
      int home = matches[matchNum][0];
      int away = matches[matchNum][1];

      if (results[home][i] > 0 && results[away][2 - i] > 0) {
        results[home][i] -= 1;
        results[away][2 - i] -= 1;
        if (dfs(matchNum + 1, cnt + 1) == 15) {
          return 15;
        }
        results[home][i] += 1;
        results[away][2 - i] += 1;
      }
    }
    return cnt;
  }
}