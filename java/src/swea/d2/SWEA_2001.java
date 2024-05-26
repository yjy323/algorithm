package swea.d2;

import java.io.*;
import java.util.*;

public class SWEA_2001 {

  // 2차원 배열 누적합
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      int[][] arr = new int[n][n];
      int[][] sum = new int[n + 1][n + 1];
      for (int j = 0; j < n; j++) {
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < n; k++) {
          arr[j][k] = Integer.parseInt(st.nextToken());
          sum[j + 1][k + 1] = sum[j + 1][k] + sum[j][k + 1] - sum[j][k] + arr[j][k];
        }
      }

      int maxSum = 0;
      for (int j = m; j <= n; j++) {
        for (int k = m; k <= n; k++) {
          int prefixSum = sum[j][k] - sum[j - m][k] - sum[j][k - m] + sum[j - m][k - m];
          maxSum = Math.max(maxSum, prefixSum);
        }
      }
      bw.write("#" + (i + 1) + " " + maxSum + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
