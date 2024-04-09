package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2512 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] budgets = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    int max = -1;
    int sum = 0;
    for (int i = 0; i < n; ++i) {
      budgets[i] = Integer.parseInt(st.nextToken());
      max = Math.max(max, budgets[i]);
      sum += budgets[i];
    }
    long m = Long.parseLong(br.readLine());

    if (sum > m) {
      int left = 0;
      int right = max;

      while (left <= right) {
        int mid = (left + right) / 2;
        sum = 0;
        for (int budget : budgets){
          sum += Math.min(budget, mid);
        }

        if (sum < m){
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
      System.out.println(right);
    } else {
      System.out.println(Arrays.stream(budgets).max().getAsInt());
    }
    br.close();
  }
}