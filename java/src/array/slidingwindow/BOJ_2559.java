package array.slidingwindow;

import java.util.*;
import java.io.*;

public class BOJ_2559 {

  public static void main(String[] args) throws IOException {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] arr = new int[n];
    st = new StringTokenizer(bf.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int sum = 0;
    int maxSum = 0;
    for (int i = 0; i < k; i++) {
      sum += arr[i];
    }
    maxSum = sum;

    for (int i = k; i < n; i++){
      sum = sum + arr[i] - arr[i - k];
      if (sum > maxSum)
        maxSum = sum;
    }

    System.out.println(maxSum);
  }
}
