package datastructure.queue;

import java.util.*;
import java.io.*;

public class BOJ_10845 {

  public static void main(String[] args) throws IOException {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine());

    Queue<Integer> queue = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    int last = 0;
    for (int i = 0; i < n; i++) {

      StringTokenizer st = new StringTokenizer(bf.readLine());
      String cmd = st.nextToken();

      switch (cmd) {
        case "push":
          last = Integer.parseInt(st.nextToken());
          queue.add(last);
          break;
        case "pop":
          if (queue.isEmpty()) {
            sb.append("-1\n");
          } else {
            sb.append(queue.poll() + "\n");
          }
          break;
        case "size":
          sb.append(queue.size() + "\n");
          break;
        case "empty":
          if (queue.isEmpty()) {
            sb.append("1\n");
          } else {
            sb.append("0\n");
          }
          break;
        case "front":
          if (queue.isEmpty()) {
            sb.append("-1\n");
          } else {
            sb.append(queue.peek() + "\n");
          }
          break;
        case "back":
          if (queue.isEmpty()) {
            sb.append("-1\n");
          } else {
            sb.append(last + "\n");
          }
          break;
      }
    }
    System.out.println(sb);
  }
}
