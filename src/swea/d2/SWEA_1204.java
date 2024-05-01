package swea.d2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1204 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      String tc = br.readLine();
      int[] map = new int[101];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 1000; j++) {
        map[Integer.parseInt(st.nextToken())] += 1;
      }

      int max = 0;
      int maxIdx = 0;
      for (int j = 0; j < 101; j++) {
        if (max < map[j]) {
          max = map[j];
          maxIdx = j;
        }
      }
      bw.write("#" + tc + " " + maxIdx + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
