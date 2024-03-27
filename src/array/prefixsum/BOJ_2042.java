package array.prefixsum;

import java.util.*;
import java.io.*;

public class BOJ_2042 {

  static int n;
  static int t;
  static long[] tree;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int m, k;
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    t = (int) Math.pow(2, Math.ceil(Math.log(n) / Math.log(2)));
    tree = new long[t * 2];
    for (int i = 0; i < n; ++i) {
      tree[i + t] = Long.parseLong(bf.readLine());
    }
    for (int i = t; i > 1; i /= 2) {
      for (int j = i; j < i * 2; j += 2) {
        tree[j / 2] = tree[j] + tree[j + 1];
      }
    }

    for (int i = 0; i < m + k; ++i) {
      st = new StringTokenizer(bf.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      long c = Long.parseLong(st.nextToken());

      if (a == 1) {
        update(b, c);
      } else if (a == 2) {
        query(b, (int)c);
      }
    }
  }

  static void update(int idx, long val) {
    idx = idx + t - 1;

    tree[idx] = val;
    int sibling = 1;
    for (int i = idx; i > 1; i /= 2) {
      if (i % 2 == 0) {
        sibling = 1;
      } else {
        sibling = -1;
      }
      tree[i / 2] = tree[i] + tree[i + sibling];
    }
  }

  static void query(int s, int e) {
    s = s + t - 1;
    e = e + t - 1;
    long sum = 0;
    while (e >= s) {
      if (s % 2 == 1) {
        sum += tree[s];
      }
      if (e % 2 == 0) {
        sum += tree[e];
      }

      s = (s + 1) / 2;
      e = (e - 1) / 2;
    }
    System.out.println(sum);
  }
}
