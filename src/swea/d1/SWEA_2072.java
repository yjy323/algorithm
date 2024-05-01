package swea.d1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_2072 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      int sum = 0;
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 10; j++) {
        int n = Integer.parseInt(st.nextToken());
        if (n % 2 == 1){
          sum += n;
        }
      }
      bw.write("#" + (i + 1) + " " + sum + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
