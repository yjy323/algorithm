package math;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class BOJ_1929 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();

    int[] arr = new int[n + 1];
    for (int i = 2; i <= n; i++) {
      arr[i] = i;
    }

    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (arr[i] == 0) {
        continue;
      } else {
        for (int j = i * i; j <= n; j += i) {
          arr[j] = 0;
        }
      }
    }

    StringBuffer sb = new StringBuffer();
    for (int i = m; i <= n; i++) {
      if (arr[i] != 0) {
        sb.append(i + "\n");
      }
    }
    System.out.println(sb);
  }
}
