package datastructure.queue;

import java.awt.Point;
import java.io.*;
import java.util.*;

public class BOJ_3190 {

  private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  private static StringTokenizer st;

  static int n, k, l;
  static int[][] map;
  static Queue<Point> snake = new LinkedList<>();
  static HashMap<Integer, String> changeDirTimeTable = new HashMap<>();

  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {

    n = Integer.parseInt(bf.readLine());
    map = new int[n][n];

    k = Integer.parseInt(bf.readLine());
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(bf.readLine());
      map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
    }

    l = Integer.parseInt(bf.readLine());
    for (int i = 0; i < l; i++) {
      st = new StringTokenizer(bf.readLine());
      changeDirTimeTable.put(Integer.parseInt(st.nextToken()), st.nextToken());
    }

    int timer = 0;
    int curX = 0;
    int curY = 0;
    int d = 0;
    snake.add(new Point(0, 0));
    while (true) {

      timer++;
      curX += dx[d];
      curY += dy[d];

      Point updateHead = new Point(curX, curY);

      if (isEnd(updateHead)) {
        break;
      }

      if (map[curY][curX] == 1) {
        snake.add(updateHead);
        map[curY][curX] = 0;
      } else {
        snake.add(updateHead);
        snake.poll();
      }

      d = updateDir(timer, d);
    }
    System.out.println(timer);
  }

  private static int updateDir(int key, int d) {
    if (changeDirTimeTable.containsKey(key)) {
      if (changeDirTimeTable.get(key).equals("D")) {
        d = (d + 1) % 4;
      } else {
        d = --d < 0 ? 3 : d;
      }
    }
    return d;
  }

  private static boolean isEnd(Point point) {
    if (point.getX() < 0 || point.getX() > n - 1 || point.getY() < 0 || point.getY() > n - 1) {
      return true;
    } else if (snake.contains(point)) {
      return true;
    } else {
      return false;
    }
  }
}
