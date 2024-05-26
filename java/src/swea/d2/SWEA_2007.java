package swea.d2;

import java.io.*;

public class SWEA_2007 {

  static public void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());

    for (int tc = 1; tc <= t ; tc++) {
      String line = br.readLine();

      for (int i = 1; i < 10; i++) {
        if (line.substring(0, i).equals(line.substring(i, i * 2))) {
          bw.write("#" + tc + " "  + i + "\n");
          break;
        }
      }
    }

    br.close();
    bw.flush();
    bw.close();
  }
}

