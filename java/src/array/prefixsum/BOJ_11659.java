package array.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    long[] s = new long[n + 1];
    s[0] = 0;
    st = new StringTokenizer(br.readLine());
    for (int idx = 1; idx < n + 1; idx++) {

      s[idx] = s[idx - 1] + Integer.parseInt(st.nextToken());
    }

    for (int idx = 0; idx < m; idx++) {

      st = new StringTokenizer(br.readLine());
      int i = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());
      System.out.println(s[j] - s[i - 1]);
    }
  }
}
