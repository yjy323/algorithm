package array.twopointer;

import java.io.*;
import java.util.*;

public class BOJ_2470 {

  public static void main(String[] args) throws IOException {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int n = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];

    st = new StringTokenizer(bf.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);

    int start = 0;
    int end = n - 1;
    int distance = Integer.MAX_VALUE;

    int tempDistance = 0;
    int ansMin = 0;
    int ansMax = 0;

    while (start < end) {
      tempDistance = arr[start] + arr[end];
      if (Math.abs(tempDistance) < distance) {
        distance = Math.abs(tempDistance);
        ansMin = start;
        ansMax = end;
      }
      if (tempDistance > 0) {
        end--;
      } else if (tempDistance < 0) {
        start++;
      } else {
        break;
      }
    }
    System.out.println(arr[ansMin] + " " + arr[ansMax]);
  }
}
