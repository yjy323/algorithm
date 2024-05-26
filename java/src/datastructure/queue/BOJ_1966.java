package datastructure.queue;

import java.io.*;
import java.util.*;

public class BOJ_1966 {

  public static void main(String[] args) throws IOException {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    int cases = Integer.parseInt(bf.readLine());

    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < cases; i++) {

      Queue<Integer[]> queue = new LinkedList<>();
      StringTokenizer st = new StringTokenizer(bf.readLine());
      int n = Integer.parseInt(st.nextToken());
      int doc = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(bf.readLine());
      for (int j = 0; j < n; j++) {
        queue.add(new Integer[]{Integer.parseInt(st.nextToken()), j});
      }

      int cnt = 1;
      while (!queue.isEmpty()) {
        int max = Collections.max(queue, (o1, o2) -> o1[0].compareTo(o2[0]))[0];
        Integer[] polled = queue.poll();

        if (polled[0] < max) {
          queue.add(polled);
        } else if (doc == polled[1]) {
          sb.append(cnt + "\n");
        } else {
          cnt++;
        }
      }
    }
    System.out.println(sb);
  }
}
