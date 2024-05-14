package swea.d2;

import java.io.*;

public class SWEA_2005 {

  static public void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());

    for (int tc = 1; tc <= t ; tc++) {
      int n = Integer.parseInt(br.readLine());
      int size = 0;
      for (int i = 1; i <= n; i++) {
        size += i;
      }
      int[] arr = new int[size + 1];

      int start = 0;
      int end = 0;
      for (int i = 1; i <= n; i++) {
        end += i;
        start = end - i + 1;
        arr[start] = 1;
        arr[end] = 1;
        for (int j = start + 1; j < end; j++) {
          arr[j] = arr[j - i] + arr[j - i + 1];
        }
      }
      bw.write("#" + tc + "\n");

      int offset = 0;
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= i; j++) {
          bw.write(arr[offset + j] +  " ");
        }
        bw.write("\n");

        offset += i;
      }
    }

    br.close();
    bw.flush();
    bw.close();
  }
}

