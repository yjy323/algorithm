package swea.d2;

import java.io.*;
import java.util.*;

public class SWEA_1284 {

  static public void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());

    for (int tc = 1; tc <= t ; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int p = Integer.parseInt(st.nextToken());
      int q = Integer.parseInt(st.nextToken());
      int r = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());


      bw.write("#" + tc + " " + Math.min(p * w, w > r ? q + (s * (w - r)) : q) + "\n");
    }

    br.close();
    bw.flush();
    bw.close();
  }
}
