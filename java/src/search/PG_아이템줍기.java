package search;

import java.util.*;

public class PG_아이템줍기 {

  static final int MAX_SIZE = 50 * 2 + 1;
  static int[] dx = new int[]{0, 1, 0, -1};
  static int[] dy = new int[]{1, 0, -1, 0};
  static int[][] map = new int[MAX_SIZE][MAX_SIZE];
  static boolean[][] visited = new boolean[MAX_SIZE][MAX_SIZE];

  static class Node {

    int x;
    int y;
    int depth;

    Node(int x, int y, int depth) {
      this.x = x;
      this.y = y;
      this.depth = depth;
    }
  }

  public static void main(String[] args) {
    int[][] rectangle = new int[4][4];
    rectangle[0] = new int[]{1, 1, 7, 4};
    rectangle[1] = new int[]{3, 2, 5, 5};
    rectangle[2] = new int[]{4, 3, 6, 9};
    rectangle[3] = new int[]{2, 6, 8, 8};

    System.out.println(solution(rectangle, 1, 3, 7, 8));
  }

  static void drawRect(int lowY, int highY, int lowX, int highX) {
    for (int y = lowY; y <= highY; y++) {
      for (int x = lowX; x <= highX; x++) {
        if (map[y][x] == 1) {
          continue;
        } else {
          map[y][x] = 1;
          if (y == lowY || y == highY || x == lowX || x == highX) {
            map[y][x] = 2;
          }
        }
      }
    }
  }

  public static int solution(int[][] rectangle, int characterX, int characterY, int itemX,
      int itemY) {

    for (int i = 0; i < rectangle.length; i++) {
      int[] rect = rectangle[i];
      drawRect(rect[1] * 2, rect[3] * 2, rect[0] * 2, rect[2] * 2);
    }

    return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
  }

  static int bfs(int characterX, int characterY, int itemX, int itemY) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(characterX, characterY, 0));

    while (!queue.isEmpty()) {
      Node node = queue.poll();
      if (node.y == itemY && node.x == itemX) {
        return node.depth / 2;
      }

      visited[node.y][node.x] = true;
      for (int i = 0; i < 4; i++) {
        int ny = node.y + dy[i];
        int nx = node.x + dx[i];

        if (ny > 0 && ny < MAX_SIZE && nx > 0 && nx < MAX_SIZE) {
          if (visited[ny][nx] == false && map[ny][nx] == 2) {
            queue.add(new Node(nx, ny, node.depth + 1));
          }
        }
      }
    }
    return -1;
  }
}