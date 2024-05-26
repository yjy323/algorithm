package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {

  static int[] dx = new int[]{1, 0, -1, 0};
  static int[] dy = new int[]{0, 1, 0, -1};
  static int n, m;
  static int[][] store;
  static Queue<tomato> queue = new LinkedList<>();

  static class tomato{
    int x;
    int y;
    int days;

    public tomato(int y, int x, int days){
      this.x = x;
      this.y = y;
      this.days = days;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    store = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(bf.readLine());
      for (int j = 0; j < m; j++) {
        store[i][j] = Integer.parseInt(st.nextToken());
        if (store[i][j] == 1) {
          queue.add(new tomato(i, j, 0));
        }
      }
    }
    bfs();
  }

  static boolean checkTomato() {
    for(int i=0; i<n; i++) {
      for(int j=0; j<m; j++) {
        if(store[i][j] == 0)
          return false;
      }
    }
    return true;
  }
  private static void bfs() {
    int ny, nx;
    int days = 0;

    while (!queue.isEmpty()) {
      tomato t = queue.poll();
      days = t.days;

      for (int i = 0; i < 4; i++) {
        ny = t.y + dy[i];
        nx = t.x + dx[i];
        if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
          if (store[ny][nx] == 0){
            store[ny][nx] = 1;
            queue.add(new tomato(ny, nx, days + 1));
          }
        }
      }
    }

    if (checkTomato()){
      System.out.println(days);
    } else{
      System.out.println(-1);
    }
  }
}