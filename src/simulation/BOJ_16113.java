package simulation;

import java.util.Scanner;

public class BOJ_16113 {

  public static void main(String[] args) {
    String[] sigTable = new String[10];
    sigTable[0] = "####.##.##.####";
    sigTable[1] = "";
    sigTable[2] = "###..#####..###";
    sigTable[3] = "###..####..####";
    sigTable[4] = "";
    sigTable[5] = "####..###..####";
    sigTable[6] = "####..####.####";
    sigTable[7] = "###..#..#..#..#";
    sigTable[8] = "####.#####.####";
    sigTable[9] = "####.####..####";

    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
    final int w = n / 5;
    final int h = 5;

    String line = sc.nextLine();
    char[][] signal = new char[h][w];
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        signal[i][j] = line.charAt(i * w + j);
      }
    }

    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < w; i++) {
      if (signal[0][i] == '#') {
        if (i + 1 == w || i + 2 == w) {
          sb.append(1);
        } else if (signal[0][i + 1] == '.') {
          if (signal[3][i] == '.') {
            sb.append(4);
            i += 2;
          } else {
            sb.append(1);
          }
        } else {
          StringBuffer singleSignal = new StringBuffer();
          for (int k = 0; k < 5; k++) {
            for (int j = i; j < i + 3; j++) {
              singleSignal.append(signal[k][j]);
            }
          }
          for (int k = 0; k < 10; k++) {
            if (singleSignal.toString().equals(sigTable[k])) {
              sb.append(k);
              i += 2;
              break;
            }
          }
        }
      }
    }
    System.out.println(sb);
  }
}
