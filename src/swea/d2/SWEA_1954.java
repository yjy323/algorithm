package swea.d2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1954 {

  static int[][] arr;
  static int max;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      max = (int) Math.pow(n, 2);
      arr = new int[n + 1][n + 1];

      bw.write("#" + (i + 1) + "\n");
      loop(1, n, 1);
      for (int j = 1; j <= n; j++) {
        for (int k = 1; k <= n; k++) {
          bw.write(arr[j][k] + " ");
        }
        bw.write("\n");
      }
    }
    bw.flush();
    bw.close();
    br.close();
  }

  private static void loop(int s, int e, int val) {
    if (val > max){
      return;
    }

    arr[s][s] = val;
    if (arr[s][s] == max){
      return;
    }

    int c = e - s;
    for (int i = s + 1; i <= e; i++) {
      val += 1;
      arr[s][i] = val;
      arr[i][e] = val + c;
      arr[e][e - i + s] = val + c * 2;
      if ((e - i + s) != s) {
        arr[e - i + s][s] = val + c * 3;
      }
    }
    loop(s + 1, e - 1, val + c * 3);
  }
}
