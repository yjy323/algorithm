package swea.d3;

import java.io.*;

public class SWEA_1289 {

  static public void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());

    for (int tc = 1; tc <= t ; tc++) {
      int cnt = 0;

      char[] mem = br.readLine().toCharArray();
      char val = '0';
      for (char c : mem) {
        if (c != val) {
          val = val == '0' ? '1' : '0';
          cnt += 1;
        }
      }
      bw.write("#" + tc + " " + cnt + "\n");
    }

    br.close();
    bw.flush();
    bw.close();
  }
}
