package simulation;

import java.io.*;
import java.util.*;

public class BOJ_5073 {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    StringBuffer sb = new StringBuffer();
    while (true) {
      st = new StringTokenizer(bf.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      int max = Math.max(a, Math.max(b, c));
      int counter = (a == b ? 1 : 0) + (a == c ? 1 : 0) + (b == c ? 1 : 0);

      if ((double) (a + b + c) / max <= 2) {
        sb.append("Invalid\n");
      } else if (counter == 3) {
        if (a == 0) {
          break;
        }
        sb.append("Equilateral\n");
      } else if (counter == 1) {
        sb.append("Isosceles\n");
      } else {
        sb.append("Scalene\n");
      }
    }
    System.out.println(sb);

    bf.close();
  }
}
