package array.twopointer;

import java.util.*;
import java.io.*;

public class BOJ_1253 {

  public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int n = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];
    st = new StringTokenizer(bf.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);

    int start, end, sum;
    int cnt = 0;
    for (int i = 0; i < n; i++) {

      start = 0;
      end = n - 1;
      while (start < end) {
        if (start == i)
          start++;
        else if (end == i)
          end--;

        sum = arr[start] + arr[end];
        if (sum > arr[i]) {
          end--;
        } else if (sum < arr[i]) {
          start++;
        } else {
          cnt++;
          break;
        }
      }
    }
    System.out.println(cnt);
  }
}
