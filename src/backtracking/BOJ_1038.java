package backtracking;

import java.util.*;

public class BOJ_1038 {

  static int cnt = 0;
  static int n;
  static int[] arr = new int[10];

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    n = sc.nextInt() + 1;

    Arrays.fill(arr, -1);
    if (n > 1023) {
      System.out.println(-1);
    } else if (n <= 10) {
      System.out.println(n - 1);
    } else {
      for (int i = 0; i < 10; i++) {
        descend(i, 10);
      }

      StringBuffer sb = new StringBuffer();
      for (int i : arr) {
        if (i != -1) {
          sb.append(i);
        }
      }
      System.out.println(sb.reverse());
    }
  }

  private static void descend(int idx, int bigVal) {
    if (idx < 0) {
      ++cnt;
      return;
    }
    for (int i = 0; i < bigVal && cnt != n; i++) {
      arr[idx] = i;
      descend(idx - 1, arr[idx]);
    }
  }
}

