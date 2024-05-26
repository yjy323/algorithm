package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1463 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    final int MAX_N = (int)Math.pow(10, 6) + 1;
    int[] dp = new int[MAX_N];

    dp[1] = 0;
    dp[2] = 1;
    dp[3] = 1;
    for (int i = 4; i <= N; i++) {
      int min = dp[i - 1];
      if (i % 2 == 0){
        min = Math.min(dp[i / 2], min);
      }
      if (i % 3 == 0){
        min = Math.min(dp[i / 3], min);
      }
      dp[i] = min + 1;
    }
    System.out.println(dp[N]);
  }
}
