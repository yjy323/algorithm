package dp;

import java.util.Scanner;

public class BOJ_11726 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    final int MAX_N = 1001;
    final int M = 10007;

    int[] t = new int[MAX_N];
    t[1] = 1;
    t[2] = 2;
    for (int i = 3; i <= n; i++) {
      t[i] = (t[i - 1] + t[i - 2]) % M;
    }
    System.out.println(t[n]);
  }
}
