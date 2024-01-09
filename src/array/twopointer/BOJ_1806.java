package array.twopointer;

import java.io.*;
import java.util.*;

public class BOJ_1806 {

  public static void main(String[] args) throws IOException{

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int n = Integer.parseInt(st.nextToken());
    int s = Integer.parseInt(st.nextToken());

    int[] arr = new int[n + 1];
    int[] sumArr = new int[n + 1];

    st = new StringTokenizer(bf.readLine());
    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      sumArr[i] = sumArr[i - 1] + arr[i];
    }

    int start = 0;
    int end = 1;
    int len = Integer.MAX_VALUE;
    int tempLen = 0;

    int sum = 0;
    while (start <= end && end <= n) {
      sum = sumArr[end] - sumArr[start];
      if (sum >= s){
        tempLen = end - start;
        len = tempLen < len ? tempLen : len;
        start++;
      }
      else{
        end++;
      }
    }

    if (len == Integer.MAX_VALUE) {
      len = 0;
    }

    System.out.println(len);
  }
}
