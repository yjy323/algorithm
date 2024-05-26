package math;

import java.util.*;
import java.io.*;

public class BOJ_11723 {

  public static void main(String[] args) throws IOException {
    HashSet<Integer> set = new HashSet<>();
    Integer[] initList = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
        18, 19,
        20};

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuffer sb = new StringBuffer();
    int m = Integer.parseInt(bf.readLine());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(bf.readLine());
      String cmd = st.nextToken();
      if (cmd.equals("all")) {
        set = new HashSet<>(Arrays.asList(initList));
      } else if (cmd.equals("empty")) {
        set.clear();
      } else {
        int x = Integer.parseInt(st.nextToken());
        if (cmd.equals("add")) {
          set.add(x);
        } else if (cmd.equals("remove")) {
          set.remove(x);
        } else if (cmd.equals("toggle")) {
          if (set.contains(x)) {
            set.remove(x);
          } else {
            set.add(x);
          }
        } else if (cmd.equals("check")) {
          if (set.contains(x)) {
            sb.append("1\n");
          } else {
            sb.append("0\n");
          }
        }
      }
    }
    System.out.println(sb);
  }
}
