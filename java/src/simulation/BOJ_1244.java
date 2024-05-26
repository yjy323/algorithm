package simulation;

import java.util.*;
import java.io.*;

public class BOJ_1244 {

  public static void main(String[] args) throws IOException {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(bf.readLine());
    boolean[] switches = new boolean[n + 1];

    st = new StringTokenizer(bf.readLine());
    for (int i = 1; i < n + 1; ++i) {
      if (st.nextToken().equals("0")) {
        switches[i] = false;
      } else {
        switches[i] = true;
      }
    }

    int m = Integer.parseInt(bf.readLine());

    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(bf.readLine());
      int sex = Integer.parseInt(st.nextToken());
      int num = Integer.parseInt(st.nextToken());

      if (sex == 1) {
        for (int j = num; j < n + 1; j += num) {
          switches[j] = !switches[j];
        }
      } else {
        int j = num - 1;
        int k = num + 1;
        switches[num] = !switches[num];
        for (; j > 0 && k < n + 1; --j, ++k) {
          if (switches[j] == switches[k]) {
            switches[j] = !switches[j];
            switches[k] = !switches[k];
          } else {
            break;
          }
        }
      }
    }

    StringBuffer sb = new StringBuffer();
    for (int i = 1; i < n + 1; i++) {
      if (switches[i]) {
        sb.append("1");
      } else {
        sb.append("0");
      }
      if (i % 20 == 0) {
        sb.append("\n");
      } else {
        sb.append(" ");
      }
    }
    System.out.println(sb);
    bf.close();
  }
}