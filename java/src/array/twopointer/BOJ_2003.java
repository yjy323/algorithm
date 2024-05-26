package array.twopointer;

import java.util.*;
import java.io.*;

public class BOJ_2003 {

  public static void main(String[] args) throws IOException {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] arr = new int[n + 1];

    st = new StringTokenizer(bf.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int start = 0;
    int end = 0;
    int cnt = 0;
    int sum = 0;
    while (end <= n) {
      if (sum >= m) {
        sum -= arr[start++];
      } else if (sum < m) {
        sum += arr[end++];
      }

      if (sum == m) {
        cnt++;
      }
    }
    System.out.println(cnt);
  }
}
