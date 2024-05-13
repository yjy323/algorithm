package swea.d3;

import java.io.*;

public class SWEA_2805 {

  static public void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());

    for (int tc = 1; tc <= t ; tc++) {
      int n = Integer.parseInt(br.readLine());
      int mid = n / 2;

      int sum = 0;
      for (int i = 0; i < n; i++) {
        char[] line = br.readLine().toCharArray();
        int diff = Math.abs(mid - i);
        for (int j = diff; j < n - diff; j++) {
          sum += (int)line[j] - '0';
        }
      }
      bw.write("#" + tc + " " + sum + "\n");
    }

    br.close();
    bw.flush();
    bw.close();
  }
}
