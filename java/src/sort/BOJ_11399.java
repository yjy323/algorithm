package sort;

import java.io.*;
import java.util.*;

public class BOJ_11399 {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bf.readLine());
    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(bf.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);
    int[] prefixSumArr = new int[n];
    prefixSumArr[0] = arr[0];
    for (int i = 1; i < n; i++) {
      prefixSumArr[i] = prefixSumArr[i - 1] + arr[i];
    }
    int sum = 0 ;
    for (int ele : prefixSumArr){
      sum += ele;
    }
    System.out.println(sum);
  }
}
