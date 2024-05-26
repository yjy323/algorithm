package swea.d3;

import java.io.*;
import java.util.*;

public class SWEA_1208 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int[] boxes = new int[100];

    for (int t = 1; t <= 10; t++) {
      int dump = Integer.parseInt(br.readLine());

      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < 100; i++) {
        boxes[i] = Integer.parseInt(st.nextToken());
      }

      int height = 0;
      for (int i = 0; i < dump; i++) {
        Arrays.sort(boxes);
        height = boxes[99] - boxes[0];
        if (height == 1 || height == 0) {
          break;
        } else {
          boxes[99] -= 1;
          boxes[0] += 1;
        }
      }
      height = Arrays.stream(boxes).max().getAsInt()
          - Arrays.stream(boxes).min().getAsInt();
      bw.write("#" + t + " " + height + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
