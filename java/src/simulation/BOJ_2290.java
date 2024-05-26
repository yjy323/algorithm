package simulation;

import java.util.Scanner;
import java.util.StringTokenizer;
import simulation.BOJ_2290.Info.H_FLAG;

public class BOJ_2290 {

  static StringBuffer sb = new StringBuffer();

  static class Info {

    enum H_FLAG {
      LEFT,
      RIGHT,
      BOTH
    }

    boolean topW;
    boolean midW;
    boolean bottomW;

    H_FLAG topH;
    H_FLAG bottomH;

    Info(boolean topW, boolean midW, boolean bottomW, H_FLAG topH, H_FLAG bottomH) {
      this.topW = topW;
      this.midW = midW;
      this.bottomW = bottomW;
      this.topH = topH;
      this.bottomH = bottomH;
    }
  }

  static void drawW(boolean isW, int s) {
    if (isW == false) {
      for (int i = 0; i < s + 2; i++) {
        sb.append(" ");
      }
    } else {
      sb.append(" ");
      for (int i = 0; i < s; i++) {
        sb.append("-");
      }
      sb.append(" ");
    }
  }

  static void drawH(H_FLAG flag, int s) {

    if (flag == H_FLAG.LEFT) {

      for (int i = 0; i < s + 1; i++) {
        sb.append(" ");
      }
      sb.append("|");
    } else if (flag == H_FLAG.RIGHT) {
      sb.append("|");
      for (int i = 0; i < s + 1; i++) {
        sb.append(" ");
      }
    } else {
      sb.append("|");
      for (int i = 0; i < s; i++) {
        sb.append(" ");
      }
      sb.append("|");
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");

    int s = Integer.parseInt(st.nextToken());
    char[] n = st.nextToken().toCharArray();

    Info[] infoList = new Info[10];
    infoList[1] = new Info(false, false, false, H_FLAG.LEFT, H_FLAG.LEFT);
    infoList[2] = new Info(true, true, true, H_FLAG.LEFT, H_FLAG.RIGHT);
    infoList[3] = new Info(true, true, true, H_FLAG.LEFT, H_FLAG.LEFT);
    infoList[4] = new Info(false, true, false, H_FLAG.BOTH, H_FLAG.LEFT);
    infoList[5] = new Info(true, true, true, H_FLAG.RIGHT, H_FLAG.LEFT);
    infoList[6] = new Info(true, true, true, H_FLAG.RIGHT, H_FLAG.BOTH);
    infoList[7] = new Info(true, false, false, H_FLAG.LEFT, H_FLAG.LEFT);
    infoList[8] = new Info(true, true, true, H_FLAG.BOTH, H_FLAG.BOTH);
    infoList[9] = new Info(true, true, true, H_FLAG.BOTH, H_FLAG.LEFT);
    infoList[0] = new Info(true, false, true, H_FLAG.BOTH, H_FLAG.BOTH);

    for (int i = 0; i < 5; i++) {
      int loop = 1;
      if (i % 2 == 1) {
        loop = s;
      }

      for (int j = 0; j < loop; j++) {
        for (char c : n) {
          int num = c - '0';
          Info numInfo = infoList[num];
          switch (i) {
            case 0:
              drawW(numInfo.topW, s);
              break;
            case 1:
              drawH(numInfo.topH, s);
              break;
            case 2:
              drawW(numInfo.midW, s);
              break;
            case 3:
              drawH(numInfo.bottomH, s);
              break;
            case 4:
              drawW(numInfo.bottomW, s);
              break;
          }
          sb.append(" ");
        }
        sb.append("\n");
      }
    }
    System.out.println(sb);
  }
}