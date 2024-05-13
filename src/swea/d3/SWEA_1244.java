package swea.d3;

import java.io.*;
import java.util.*;

public class SWEA_1244 {
  static int optMax;
  static int max = Integer.MIN_VALUE;
  static char[] num;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      max = Integer.MIN_VALUE;
      StringTokenizer st = new StringTokenizer(br.readLine());
      num = st.nextToken().toCharArray();

      int cnt = Integer.parseInt(st.nextToken());
      calc(0, cnt);
      bw.write("#" + (i + 1) + " " + max + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
  private static void swap(char[] a, int f, int r) {
    char temp;
    temp = a[f];
    a[f] = a[r];
    a[r] = temp;
  }
  private static void calc(int s, int cnt) {
    if (cnt == 0){
      max = Math.max(max, Integer.parseInt(new String(num)));
      return;
    }
    for (int i = s; i < num.length; i++){
      for (int j = i + 1; j < num.length; j++){
        swap(num, i, j);
        calc(i,cnt - 1);
        swap(num, i, j);
      }
    }
  }
}
