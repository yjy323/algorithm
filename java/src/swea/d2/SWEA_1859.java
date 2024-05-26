package swea.d2;

import java.io.*;
import java.util.*;

public class SWEA_1859 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] arr = new int[n];
      for (int j = 0; j < n; j++) {
        arr[j] = Integer.parseInt(st.nextToken());
      }

      int today = n - 1;
      int maxPrice = arr[today];
      int maxPriceIdx = today;
      long sum = 0;
      for (; today > 0; today--) {
        int yesterday = today - 1;
        if (arr[yesterday] > maxPrice){
          for (int j = today; j < maxPriceIdx; j++) {
            sum += maxPrice - arr[j];
          }
          maxPrice = arr[yesterday];
          maxPriceIdx = yesterday;
        }
      }
      for (int j = 0; j < maxPriceIdx; j++) {
        sum += maxPrice - arr[j];
      }
      bw.write("#" + (i + 1) + " " + sum + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
