package swea.d3;

import java.io.*;
import java.util.*;

public class SWEA_1206 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int i = 0; i < 10; i++) {
      int sum = 0;
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        arr[j] =  Integer.parseInt(st.nextToken());
      }

      for (int j = 2; j < n - 2; j++){
        int max = Math.max(Math.max(arr[j - 2], arr[j - 1]), Math.max(arr[j + 2], arr[j + 1]));
        int res = arr[j] - max;
        sum += res > 0 ? res : 0;
      }
      bw.write("#" + (i + 1) + " " + sum + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
