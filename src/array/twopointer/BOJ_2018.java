package array.twopointer;

import java.util.Scanner;

public class BOJ_2018 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] arr = new int[n];

    int sum = 1;
    int count = 1;
    int start = 1;
    int end = 1;

    for (int i = 1; i < n ;i++) {
      if (sum < n) {
        sum += ++end;
      }
      else if (sum > n) {
        sum -= start++;
      }
      else {
        sum += ++end;
        count++;
      }
    }
    System.out.println(count);
  }
}
