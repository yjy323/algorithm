package swea.d2;

import java.io.*;

public class SWEA_1926 {

  static public void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());

    for (int i = 1; i <= n; i++) {
      int cnt = 0;
      int num = i;
      while (num > 0) {
        int digit = num % 10;
        if (digit == 3 || digit == 6 || digit == 9) {
          cnt += 1;
        }
        num /= 10;
      }
      if (cnt == 0) {
        bw.write(i + " ");
      } else {
        for (int j = 0; j < cnt; j++) {
          bw.write("-");
        }
        bw.write(" ");
      }
    }

    br.close();
    bw.flush();
    bw.close();
  }
}

