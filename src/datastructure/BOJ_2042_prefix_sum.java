package datastructure;

import java.util.Scanner;

public class BOJ_2042_prefix_sum {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();

    int[] arr = new int[n + 1];
    int[] sumArr = new int[n + 1];

    for (int i = 1; i < n + 1; i++) {
      arr[i] = sc.nextInt();
      sumArr[i] = sumArr[i - 1] + arr[i];
      System.out.println(arr[i] + " " + sumArr[i]);
    }

    int a, b, c;
    for (int i = 0; i < m + k; i++) {
      a = sc.nextInt();
      b = sc.nextInt();
      c = sc.nextInt();

      switch (a){
        case 1:
          sumArr[b] = sumArr[b] - arr[b] + c;
          arr[b] = c;
          System.out.println(arr[b] + " " + sumArr[b]);
          break;
        case 2:
          System.out.println(sumArr[c] - sumArr[b - 1]);
          break;
      }
    }
  }
}
