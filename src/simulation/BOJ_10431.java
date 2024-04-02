package simulation;

import java.io.*;
import java.util.*;

public class BOJ_10431 {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[] arr = new int[20];

    int p = Integer.parseInt(bf.readLine());
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < p; ++i) {
      st = new StringTokenizer(bf.readLine());
      int t = Integer.parseInt(st.nextToken());
      int cnt = 0;
      for (int j = 0; j < 20; ++j) {
        arr[j] = Integer.parseInt(st.nextToken());
        for (int k = j; k > 0; --k) {
          if (arr[k] < arr[k - 1]) {
            int tmp = arr[k];
            arr[k] = arr[k - 1];
            arr[k - 1] = tmp;
            cnt += 1;
          }
        }
      }
      sb.append(t + " " + cnt + "\n");
    }
    System.out.print(sb);
  }
}
