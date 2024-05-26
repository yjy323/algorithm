package sort;

import java.io.*;
import java.util.*;

public class BOJ_2751 {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bf.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(bf.readLine());
    }
    Arrays.sort(arr);

    StringBuffer sb = new StringBuffer();
    for (int ele : arr) {
      sb.append(ele + "\n");
    }
    System.out.println(sb);
  }
}
