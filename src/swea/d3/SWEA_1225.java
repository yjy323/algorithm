package swea.d3;

import java.io.*;
import java.util.*;

public class SWEA_1225 {

  static public void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int tc = 1; tc <= 10 ; tc++) {
      br.readLine();
      StringTokenizer st = new StringTokenizer(br.readLine());
      Queue<Integer> queue = new LinkedList<>();
      for (int j = 0; j < 8; j++) {
        queue.add(Integer.parseInt(st.nextToken()));
      }

      int off = 0;
      while(true) {
        off = (off % 5) + 1;
        int n = queue.poll() - off;
        if (n < 1) {
          queue.add(0);
          break;
        } else {
          queue.add(n);
        }
      }
      bw.write("#" + tc + " ");
      for (int n : queue) {
        bw.write(n + " ");
      }
      bw.write("\n");
    }

    br.close();
    bw.flush();
    bw.close();
  }
}

