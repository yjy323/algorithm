package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8911 {

  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  static int maxX = 0;
  static int maxY = 0;
  static int minX = 0;
  static int minY = 0;

  static class Turtle {

    int x;
    int y;
    int dir;

    Turtle() {
      this.x = 0;
      this.y = 0;
      this.dir = 0;
    }

    void updateMinMax() {

      maxX = Math.max(this.x, maxX);
      maxY = Math.max(this.y, maxY);
      minX = Math.min(this.x, minX);
      minY = Math.min(this.y, minY);
    }

    void F() {
      this.x += dx[dir];
      this.y += dy[dir];
      updateMinMax();
    }

    void B() {
      this.x -= dx[dir];
      this.y -= dy[dir];
      updateMinMax();
    }

    void L() {
      this.dir = (this.dir + 3) % 4;

    }

    void R() {
      this.dir = (this.dir + 1) % 4;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(bf.readLine());
    char[] controlProgram;

    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < t; ++i) {
      controlProgram = bf.readLine().toCharArray();
      Turtle turtle = new Turtle();
      maxX = 0;
      maxY = 0;
      minX = 0;
      minY = 0;
      for (char c : controlProgram) {
        switch (c) {
          case 'F':
            turtle.F();
            break;
          case 'B':
            turtle.B();
            break;
          case 'L':
            turtle.L();
            break;
          case 'R':
            turtle.R();
            break;
          default:
            break;
        }
      }
      sb.append((maxX - minX) * (maxY - minY) + "\n");
    }
    System.out.print(sb);
    bf.close();
  }
}
