package swea.d3;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_1209 {

  static BufferedReader br;
  static BufferedWriter bw;


  static public void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int tc = 1; tc <= 10 ; tc++) {

      br.readLine();

      long maxSum = Long.MIN_VALUE;
      long[] hrSums = new long[100];
      long dgSum1 = 0;
      long dgSum2 = 0;
      for (int i = 0; i < 100; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());

        long vtSum = 0;
        for (int j = 0; j < 100; j++) {
          int n = Integer.parseInt(st.nextToken());
          vtSum += n;
          hrSums[j] += n;

          if (i == j) {
            dgSum1 += n;
          }

          if (i + j == 99) {
            dgSum2 += n;
          }
        }
        maxSum = Math.max(maxSum, vtSum);
      }
      maxSum = Math.max(maxSum, dgSum1);
      maxSum = Math.max(maxSum, dgSum2);
      for (int i = 0; i < 100; i++) {
        maxSum = Math.max(maxSum, hrSums[i]);
      }
      bw.write("#" + tc + " " + maxSum + "\n");
    }


    br.close();
    bw.flush();
    bw.close();
  }
}

