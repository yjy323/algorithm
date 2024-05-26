package search.binary;

import java.io.*;
import java.util.*;

public class BOJ_1920 {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine());
    int[] arr = new int[n];

    StringTokenizer st = new StringTokenizer(bf.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);

    int m = Integer.parseInt(bf.readLine());
    st = new StringTokenizer(bf.readLine());
    for (int i = 0; i < m; i++) {
      int val = Integer.parseInt(st.nextToken());
      int startIdx = 0;
      int endIdx = arr.length - 1;
      boolean isFind = false;

      while (startIdx <= endIdx) {
        int midIdx = (endIdx + startIdx) / 2;
        if (val == arr[midIdx]) {
          isFind = true;
          break;
        } else if (val < arr[midIdx]) {
          endIdx = midIdx - 1;
        } else {
          startIdx = midIdx + 1;
        }
      }
      if (isFind) {
        System.out.println(1);
      } else {
        System.out.println(0);
      }
    }
  }
}
